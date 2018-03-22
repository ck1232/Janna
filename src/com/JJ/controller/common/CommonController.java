package com.JJ.controller.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.JJ.controller.common.vo.FileVO;
import com.JJ.controller.common.vo.MenuVO;
import com.JJ.controller.common.vo.ModuleVO;
import com.JJ.controller.common.vo.SubModulePermissionVO;
import com.JJ.controller.common.vo.SubModuleVO;
import com.JJ.controller.common.vo.UserRoleVO;
import com.JJ.controller.common.vo.UserVO;
import com.JJ.helper.GeneralUtils;
import com.JJ.service.common.CommonService;
import com.JJ.service.modulemanagement.ModuleManagementService;
import com.JJ.service.permissionmanagement.PermissionManagementService;
import com.JJ.service.roleassignment.RoleAssignmentService;
import com.JJ.service.submodulemanagement.SubModuleManagementService;
import com.JJ.service.usermanagement.UserManagementService;


@Controller  
@SessionAttributes
@PropertySources({
	@PropertySource(value = "classpath:admin-dev-config.properties", ignoreResourceNotFound = false),
	@PropertySource(value = "file:C:\\Inetpub\\vhosts\\ziumlight.com\\Configuration\\application-${spring.profiles.active}.properties", ignoreResourceNotFound=true)
})
@Scope("session")
@RequestMapping(value = "/")
public class CommonController implements Serializable{

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(CommonController.class);
	private SubModuleManagementService subModuleManagementService;
	private ModuleManagementService moduleManagementService;
	private RoleAssignmentService roleAssignmentService;
	private UserManagementService userManagementService;
	private PermissionManagementService permissionManagementService;
	private CommonService commonService;
	
	@Value("${log.path}")
	private String logUrl;
	
	@Value("${jdbc.driver}")
	private String driver;
	
	@Value("${jdbc.url}")
    private String url;
	
	@Value("${jdbc.query.user}")
    private String user;
	
	@Value("${jdbc.query.password}")
    private String password;
	
	@Value("${image.folder}")
    private String imageFolderSource;
	
	@Autowired
	public CommonController(SubModuleManagementService subModuleManagementService, ModuleManagementService moduleManagementService,
			RoleAssignmentService roleAssignmentService, UserManagementService userManagementService,
			PermissionManagementService permissionManagementService, CommonService commonService){
		this.subModuleManagementService = subModuleManagementService;
		this.moduleManagementService = moduleManagementService;
		this.roleAssignmentService = roleAssignmentService;
		this.userManagementService = userManagementService;
		this.permissionManagementService = permissionManagementService;
		this.commonService = commonService;
	}
	
	@RequestMapping(value={"/","/dashboard"})  
    public String loadDashboard(HttpSession session) {  
    	logger.debug("dashboard is executed!");
    	Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	if(principal instanceof UserDetails){
    		UserDetails userDetails = (UserDetails)principal ;
	    	session.setAttribute("userAccount", principal);
	    	session.setAttribute("menu", this.populateMenu(userDetails));
	    	List<String> roleList = new ArrayList<String>();
	    	for(GrantedAuthority authority : SecurityContextHolder.getContext().getAuthentication().getAuthorities()){
	    		roleList.add(authority.getAuthority());
	    	}
	    	List<String> urlList = commonService.getAllowedUrlByRoleName(roleList);
	    	session.setAttribute("allowedUrl", urlList);
    	}else if(principal instanceof String){
    		logger.debug("principal:"+principal.toString());
    	}
        return "dashboard";  
    }
	
	private List<SubModuleVO> getAllSubModuleByUserId(String userId){
		List<Integer> roleIdList = new ArrayList<Integer>();
		List<Integer> subModuleIdList = new ArrayList<Integer>();
		UserVO dbUser = userManagementService.findByUserName(userId);
		if(dbUser == null){
			return null;
		}
		List<UserRoleVO> roleList = roleAssignmentService.getRoleListByUserId(dbUser.getUserId());
		for(UserRoleVO userRole: roleList){
			roleIdList.add(userRole.getRoleId());
		}
		if(roleIdList.size() == 0){
			return null;
		}
		List<SubModulePermissionVO> submodulepermissionList = permissionManagementService.getSubmoduleByRole(roleIdList);
		for(SubModulePermissionVO obj : submodulepermissionList){
			subModuleIdList.add(obj.getSubmoduleId());
		}
		if(subModuleIdList.size() == 0){
			return null;
		}
		return subModuleManagementService.getSubmodulesById(subModuleIdList);
	}
	public MenuVO populateMenu(UserDetails user){
		MenuVO menu = new MenuVO();
		
		List<SubModuleVO> subModuleList = getAllSubModuleByUserId(user.getUsername());
		List<ModuleVO> moduleList = moduleManagementService.getAllModules();
//		List<Submodule> submoduleList = subModuleManagementService.getAllSubmodules();
		
		if(subModuleList != null && subModuleList.size() > 0){
			Map<Long, List<SubModuleVO>> subModuleMap = new HashMap<Long, List<SubModuleVO>>();
			for(SubModuleVO subModule : subModuleList){
				if(subModuleMap.get(subModule.getParentId().longValue()) == null){
					subModuleMap.put(subModule.getParentId().longValue(), new ArrayList<SubModuleVO>());
				}
				subModuleMap.get(subModule.getParentId().longValue()).add(subModule);
			}
			for(ModuleVO module : moduleList){
				module.setSubModuleList(subModuleMap.get(module.getModuleId()));
			}
			
		}
		menu.setModuleList(moduleList);
		menu.setDteUpdated(new Date());
		return menu;
	}
	@RequestMapping(value={"/login"},method = RequestMethod.GET)  
    public String login() {  
        return "login";  
    }
	
	@RequestMapping(value="/home",method = RequestMethod.POST)
	public String userAuthenticated(){
		logger.debug("dashboard is executed!");
		return "dashboard";
	}
	
	@RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
		logger.debug("access denied!");
        model.addAttribute("user", getPrincipal());
        return "accessDenied";
    }
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
       Authentication auth = SecurityContextHolder.getContext().getAuthentication();
       if (auth != null){    
          new SecurityContextLogoutHandler().logout(request, response, auth);
       }
       request.getSession().setAttribute("user", null);
       request.getSession().setAttribute("menu", null);
       return "redirect:/login?logout";
    }
	
	@RequestMapping(value={"/query","/q"}, method = RequestMethod.GET)
	public String queryPage (Model model) {
		return "query";
	}
	
	/*@RequestMapping(value={"/404",}, method = RequestMethod.GET)
	public String errorPage (Model model) {
		return "404";
	}
	
	@RequestMapping(value={"/500",}, method = RequestMethod.GET)
	public String notFoundPage (Model model) {
		return "500";
	}*/
	
	@RequestMapping(value={"/viewLogs"}, method = RequestMethod.POST)
	public String viewLogsPage (HttpServletResponse response, @RequestParam(value="view", required=true) int hashCode, Model model) throws Exception{
//		String url = System.getProperty("wtp.deploy");
//		String url = "C:\\Inetpub\\vhosts\\ziumlight.com";
//		File folder = new File(url + "\\logs");
		File folder = new File(logUrl);
		List<File> fileList = Arrays.asList(folder.listFiles());
		List<FileVO> filesList = convertToFileVO(fileList);
		if(filesList != null && filesList.size() > 0){
			for(FileVO vo :filesList){
				if(vo.hashCode()==hashCode){
					File file = vo.getFile();
					String content = "";
					BufferedReader br = new BufferedReader(new FileReader(file));
					String line = null;
					StringBuilder sb = new StringBuilder();
					while ((line = br.readLine()) != null) {
						sb.append(line);
						sb.append("<br/>");
					}
					br.close();
					content = sb.toString();
					model.addAttribute("content", content);
					return "viewLogs";
				}
			}
		}
		return "redirect:logs";
	}
	
	@RequestMapping(value={"/downloadLogs"}, method = RequestMethod.POST)
	public String downloadLogsPage (HttpServletResponse response, @RequestParam(value="download", required=true) int hashCode) throws Exception{
		File folder = new File(logUrl);
		List<File> fileList = Arrays.asList(folder.listFiles());
		List<FileVO> filesList = convertToFileVO(fileList);
		if(filesList != null && filesList.size() > 0){
			for(FileVO vo :filesList){
				if(vo.hashCode()==hashCode){
					response.setContentType("application/octet-stream");
		         	response.addHeader("Content-Disposition", "attachment; filename="+vo.getFileName()+".logs");
		         	File file = vo.getFile();
		         	FileInputStream fileIn = new FileInputStream(file);
		            ServletOutputStream out = response.getOutputStream();
		            byte[] outputByte = new byte[(int)file.length()];
		            //copy binary contect to output stream
		            while(fileIn.read(outputByte, 0, (int)file.length()) != -1)
		            {
		            	out.write(outputByte, 0, (int)file.length());
		            }
		            out.flush();
		            fileIn.close();
		            return null;
				}
			}
		}
		return "logs";
	}
	
	@RequestMapping(value={"/logs","/l"}, method = RequestMethod.GET)
	public String logsPage (Model model) throws Exception{
//		String url = System.getProperty("wtp.deploy");
//		File folder = new File(url + "//logs");
		File folder = new File(logUrl);
		List<File> fileList = Arrays.asList(folder.listFiles());
		List<FileVO> filesList = convertToFileVO(fileList);
		model.addAttribute("files", filesList);
		/*Properties props = System.getProperties();
		for(Object propsString : props.keySet()){
			logger.debug(propsString.toString()+"="+props.getProperty(propsString.toString()));
		}*/
		
		return "logs";
	}
	
	private List<FileVO> convertToFileVO(List<File> fileList) {
		List<FileVO> fileVOList = new ArrayList<FileVO>();
		if(fileList != null && fileList.size() > 0){
			for(File file : fileList){
				if(file.isDirectory()) continue;
				FileVO vo = new FileVO();
				vo.setFileName(file.getName());
				vo.setLastModified(file.lastModified());
				vo.setHashCode(vo.hashCode());
				vo.setFile(file);
				fileVOList.add(vo);
			}
		}
		return fileVOList;
	}

	@RequestMapping(value="/query", method = RequestMethod.POST)
	public String runSqlpage (@RequestParam(value="sqlStatement", required=true) String sqlStatement, final RedirectAttributes redirectAttributes, Model model) {
		Statement statement = null;
		String message = null;
		if(sqlStatement != null && !sqlStatement.trim().isEmpty()){
			try{
				sqlStatement = sqlStatement.trim();
				if(sqlStatement.charAt(sqlStatement.length()-1) != ';'){
					sqlStatement += ';';
				}
				Class.forName(driver);
				Connection connection = DriverManager.getConnection(url, user, password);
				statement = connection.createStatement();
				String sqlType = sqlStatement.substring(0, 6);
				String sqlType2 = sqlStatement.substring(0, 4);
				logger.debug("loading sql :"+ sqlStatement);
				if (sqlType.equalsIgnoreCase("select") || sqlType2.equalsIgnoreCase("desc")){
			         ResultSet resultSet = statement.executeQuery(sqlStatement);
			         message =  GeneralUtils.getHtmlRows(resultSet);
			         statement.close();
			     }else{
			    	 int i = statement.executeUpdate(sqlStatement);
			    	 statement.close();
			    	 message =  "<tr><td>" +
		               "The statement executed successfully.<br>" +
		               i + " row(s) affected." +
		             "</td></tr>";
			     }
			}catch(Exception ex){
				ex.printStackTrace();
				logger.debug(ex.getMessage());
				if(statement != null){
					try {
						statement.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if(ex.getMessage().contains("denied ")){
					message =  "<tr><td>Error executing the SQL statement: <br>"+
				               "Access denied!"+
				             "</td></tr>";
				}else{
					message =  "<tr><td>Error executing the SQL statement: <br>"+
				               ex.getMessage()+
				             "</td></tr>";
				}
			}
		}
		model.addAttribute("sqlStatement", sqlStatement);
		redirectAttributes.addFlashAttribute("sqlStatement", sqlStatement);
		redirectAttributes.addFlashAttribute("message", message);
		return "redirect:query";
	}
	
	/*@RequestMapping(value="/images/{imageName}", method = RequestMethod.GET)
	public ResponseEntity<FileSystemResource> getImage (@PathVariable String imageName) {
		try{
			File file = new File(imageFolderSource+imageName+".jpg");
			if(!file.exists()){
				file = new File(imageFolderSource+"No-image-found.jpg");
			}
			FileSystemResource fys = new FileSystemResource(file);
			return ResponseEntity.ok().contentLength(fys.contentLength())
					.contentType(MediaType.IMAGE_JPEG).body(fys);
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity.ok().contentLength(0)
					.contentType(MediaType.IMAGE_JPEG).body(null);
		}
	}*/
	
	@RequestMapping(value="/query/export", method = RequestMethod.POST)
	public String runSqlExportPage (@RequestParam(value="sqlStatement", required=true) String sqlStatement,
			final RedirectAttributes redirectAttributes, Model model, HttpServletResponse response) {
		Statement statement = null;
		String message = null;
		if(sqlStatement != null && !sqlStatement.trim().isEmpty()){
			try{
				sqlStatement = sqlStatement.trim();
				if(sqlStatement.charAt(sqlStatement.length()-1) != ';'){
					sqlStatement += ';';
				}
				Class.forName(driver);
				Connection connection = DriverManager.getConnection(url, user, password);
				statement = connection.createStatement();
				String sqlType = sqlStatement.substring(0, 6);
				String sqlType2 = sqlStatement.substring(0, 4);
				logger.debug("loading sql :"+ sqlStatement);
				if (sqlType.equalsIgnoreCase("select") || sqlType2.equalsIgnoreCase("desc")){
			         ResultSet resultSet = statement.executeQuery(sqlStatement);
			         Workbook wb =  ExcelFileHelper.writeToFile(resultSet);
			         statement.close();
			         if(wb != null){
			         	response.setContentType("application/vnd.ms-excel");
			         	response.addHeader("Content-Disposition", "attachment; filename=data.xls");
			             try{
			             	wb.write(response.getOutputStream());
			                response.getOutputStream().flush();
			             } 
			             catch (IOException ex) {
			                 ex.printStackTrace();
			             }
			         }
			         return null;
			     }else{
			    	 int i = statement.executeUpdate(sqlStatement);
			    	 statement.close();
			    	 message =  "<tr><td>" +
		               "The statement executed successfully.<br>" +
		               i + " row(s) affected." +
		             "</td></tr>";
			     }
			}catch(Exception ex){
				ex.printStackTrace();
				logger.debug(ex.getMessage());
				if(statement != null){
					try {
						statement.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if(ex.getMessage().contains("denied ")){
					message =  "<tr><td>Error executing the SQL statement: <br>"+
				               "Access denied!"+
				             "</td></tr>";
				}else{
					message =  "<tr><td>Error executing the SQL statement: <br>"+
				               ex.getMessage()+
				             "</td></tr>";
				}
				
			}
		}
		model.addAttribute("sqlStatement", sqlStatement);
		redirectAttributes.addFlashAttribute("sqlStatement", sqlStatement);
		redirectAttributes.addFlashAttribute("message", message);
		return "redirect:query";
	}
	
	private String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
 
        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }
	
	@ExceptionHandler(Exception.class)
	public String handleAllException(Exception ex) throws Exception{
		logger.error(ex);
		throw ex;
	}
}