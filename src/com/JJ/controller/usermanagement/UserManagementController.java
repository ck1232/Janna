package com.JJ.controller.usermanagement;

import java.util.List;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.JJ.helper.GeneralUtils;
import com.JJ.model.User;
import com.JJ.service.usermanagement.UserManagementService;
import com.JJ.validator.UserFormValidator;
import com.mysql.jdbc.util.Base64Decoder;


@Controller  
@EnableWebMvc
@RequestMapping(value = "/admin")
public class UserManagementController {
	private static final Logger logger = Logger.getLogger(UserManagementController.class);
	
	private UserManagementService userManagementService;
	private UserFormValidator userFormValidator;
	
	@Autowired
	public UserManagementController(UserManagementService userManagementService,
			UserFormValidator userFormValidator) {
		this.userManagementService = userManagementService;
		this.userFormValidator = userFormValidator;
	}
	
	
	@RequestMapping(value = "/listUser", method = RequestMethod.GET)  
    public String listUser() {  
    	logger.debug("loading listUser");
        return "listUser";  
    }  
	
	@RequestMapping(value = "/getUserList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getUserList() {
		logger.debug("getting user list");
		List<User> userList = userManagementService.getAllUsers();
		return GeneralUtils.convertListToJSONString(userList);
	}
	
	@RequestMapping(value = "/createUser", method = RequestMethod.GET)
    public String showAddUserForm(Model model) {  
    	logger.debug("loading showAddUserForm");
    	User user = new User();
    	
    	user.setEnabled(true);
    	model.addAttribute("userForm", user);
        return "createUser";  
    }  
	
	@InitBinder("userForm")
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(userFormValidator);
	}
	
	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("userForm") @Validated User user, 
    		BindingResult result, Model model, final RedirectAttributes redirectAttributes) {  
    	
		logger.debug("saveUser() : " + user.toString());
		if (result.hasErrors()) {
			return "createUser";
		} else {
			
			userManagementService.saveUser(user);
			redirectAttributes.addFlashAttribute("css", "success");
			redirectAttributes.addFlashAttribute("msg", "User added successfully!");
		}
		
		
        return "redirect:listUser";  
    }  
	
	@RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
	public String deleteUser(@RequestParam(value = "checkboxId", required=false) List<String> ids,
			final RedirectAttributes redirectAttributes) {
		if(ids == null || ids.size() < 1){
			redirectAttributes.addFlashAttribute("css", "danger");
			redirectAttributes.addFlashAttribute("msg", "Please select at least one record!");
			return "redirect:listUser";
		}
		for (String id : ids) {
			userManagementService.deleteUser(new Integer(id));
			logger.debug("deleted "+ id);
		}
		redirectAttributes.addFlashAttribute("css", "success");
		redirectAttributes.addFlashAttribute("msg", "User(s) deleted successfully!");
		return "redirect:listUser";
	}
	
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public String getUserToUpdate(@RequestParam("editBtn") String id, Model model) {
		
		User user = userManagementService.findById(new Integer(id));
		logger.debug("Loading update user page for " + user.toString());
		
		model.addAttribute("userForm", user);
		return "updateUser";
	}
	
	@RequestMapping(value = "/updateUserById/{userid}", method = RequestMethod.GET)
	public String getUserToUpdateByUserId(@PathVariable String userid, Model model) {
		User user = userManagementService.findByUserId(userid);
		logger.debug("Loading update user page for " + user.toString());
		model.addAttribute("userForm", user);
		return "updateUser";
	}
	
	@RequestMapping(value = "/resetpassword", method = RequestMethod.POST)
	public String resetPassword(HttpServletRequest request, @RequestParam(value="userid", required=false) String userid, @RequestParam(value="password", required=false) String password, RedirectAttributes redirectAttributes) {
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		String csrf = token.getToken();
		int size = csrf.getBytes().length;
		String data[] = password.split(":");
        String salt_hex = data[0];
        String iv_hex = data[1];
        String msg64 = data[2];
        String jskey_hex = data[3];
        byte[] jskey = hexStringToByteArray(jskey_hex);
        byte[] iv = hexStringToByteArray(iv_hex);
        byte[] salt = hexStringToByteArray(salt_hex);
        Base64Decoder decoder = new Base64Decoder();
        byte[] msg = decoder.decode(msg64.getBytes(), 0, msg64.length());
        String plaintext = "";
        try {
            SecretKey key = new SecretKeySpec(jskey, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(iv));
            plaintext = new String(cipher.doFinal(msg), "UTF-8");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		userManagementService.resetPassword(userid, plaintext);
		redirectAttributes.addFlashAttribute("css", "success");
		redirectAttributes.addFlashAttribute("msg", "Password reset!");
		return "redirect:updateUserById/"+userid;
	}
	
	@RequestMapping(value = "/updateUserToDb", method = RequestMethod.POST)
	public String updateUser(@ModelAttribute("userForm") @Validated User user,
			BindingResult result, Model model, final RedirectAttributes redirectAttributes) {
		
		logger.debug("updateUser() : " + user.toString());
		
		if (result.hasErrors()) {
			return "updateUser";
		} else {
			userManagementService.updateUser(user);
			redirectAttributes.addFlashAttribute("css", "success");
			redirectAttributes.addFlashAttribute("msg", "User updated successfully!");
		}
		
		return "redirect:listUser";
	}
	
	@RequestMapping(value = "/viewUser", method = RequestMethod.POST)
	public String viewUser(@RequestParam("viewBtn") String id, Model model) {
		logger.debug("id = " + id);
		User user = userManagementService.findById(new Integer(id));
		if (user == null) {
			model.addAttribute("css", "danger");
			model.addAttribute("msg", "User not found");
		}
		model.addAttribute("user", user);

		return "viewUser";

	}
	
	 //Converting a string of hex character to bytes
	  public static byte[] hexStringToByteArray(String s) {
	  int len = s.length();
	  byte[] data = new byte[len / 2];
	  for (int i = 0; i < len; i += 2){
	  data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
	  + Character.digit(s.charAt(i+1), 16));
	  }
	  return data;
	  }
	
}