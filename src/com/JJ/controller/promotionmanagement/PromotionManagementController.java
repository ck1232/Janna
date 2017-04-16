package com.JJ.controller.promotionmanagement;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.JJ.controller.promotionmanagement.vo.PromotionVO;
import com.JJ.helper.GeneralUtils;
import com.JJ.service.promotionmanagement.PromotionManagementService;
import com.JJ.validator.PromotionFormValidator;


@Controller  
@EnableWebMvc
@Scope("request")
@RequestMapping(value = "/product/promotion")
public class PromotionManagementController {
	private static final Logger logger = Logger.getLogger(PromotionManagementController.class);
	
	private PromotionManagementService promotionManagementService;
	private PromotionFormValidator promotionFormValidator;
	
	@Autowired
	public PromotionManagementController(PromotionManagementService promotionManagementService,
			PromotionFormValidator promotionFormValidator) {
		this.promotionManagementService = promotionManagementService;
		this.promotionFormValidator = promotionFormValidator;
	}
	
	
	@RequestMapping("/listPromotion")  
    public String listPromotion() {  
    	logger.debug("loading listPromotion");
        return "listPromotion";  
    }  
	
	@RequestMapping(value = "/getPromotionList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getPromotionList() {
		logger.debug("getting promotion list");
		List<PromotionVO> promotionList = promotionManagementService.getAllPromotions();
		return GeneralUtils.convertListToJSONString(promotionList);
	}
	
	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/createPromotion", method = RequestMethod.GET)
    public String showAddPromotionForm(Model model) {  
    	logger.debug("loading showAddPromotionForm");
    	PromotionVO promotionVo = new PromotionVO();
    	promotionVo.setIsActive("1");
    	DateFormat df = new SimpleDateFormat("dd-MM-YYYY K:mm a");
    	Date now = new Date();
    	Date startDate = new Date(now.getYear(), now.getMonth(), now.getDate());
    	Date endDate = new Date(now.getYear(), now.getMonth(), now.getDate(),23,59,59);
    	if(promotionVo.getPromotionStartDate() == null){
    		promotionVo.setPromotionStartDate(startDate);
    	}
    	if(promotionVo.getPromotionEndDate() == null){
    		promotionVo.setPromotionEndDate(endDate);
    	}
    	String startDateString = df.format(promotionVo.getPromotionStartDate());
    	String endDateString = df.format(promotionVo.getPromotionEndDate());
    	promotionVo.setPromotionperiod(startDateString + " - " + endDateString);
    	
    	model.addAttribute("promotionForm", promotionVo);
        return "createPromotion";  
    }  
    
    @InitBinder("promotionForm")
	protected void initBinder(WebDataBinder binder) {
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd kk:mm");
    	binder.registerCustomEditor(Date.class, "promotionstartdate", new CustomDateEditor(dateFormat, false));
    	binder.registerCustomEditor(Date.class, "promotionenddate", new CustomDateEditor(dateFormat, false));
		binder.setValidator(promotionFormValidator);
	}
	
	@RequestMapping(value = "/createPromotion", method = RequestMethod.POST)
    public String savePromotion(@ModelAttribute("promotionForm") @Validated PromotionVO promotionVo, 
    		BindingResult result, Model model, final RedirectAttributes redirectAttributes) {
		
		promotionVo.setDeleteInd(GeneralUtils.NOT_DELETED);
		logger.debug("savePromotion() : " + promotionVo.toString());
		if (result.hasErrors()) {
			return "createPromotion";
		} else {
			promotionManagementService.savePromotion(promotionVo);
			redirectAttributes.addFlashAttribute("css", "success");
			redirectAttributes.addFlashAttribute("msg", "Promotion added successfully!");
		}
		
		
        return "redirect:listPromotion";  
    }  
	
	@RequestMapping(value = "/deletePromotion", method = RequestMethod.POST)
	public String deletePromotion(@RequestParam(value = "checkboxId", required=false) List<String> ids,
			final RedirectAttributes redirectAttributes) {
		if(ids == null || ids.size() < 1){
			redirectAttributes.addFlashAttribute("css", "danger");
			redirectAttributes.addFlashAttribute("msg", "Please select at least one record!");
			return "redirect:listPromotion";
		}
		for (String id : ids) {
			promotionManagementService.deletePromotion(new Integer(id));
			logger.debug("deleted "+ id);
		}
		redirectAttributes.addFlashAttribute("css", "success");
		redirectAttributes.addFlashAttribute("msg", "Promotion(s) deleted successfully!");
		return "redirect:listPromotion";
	}
	
	@RequestMapping(value = "/updatePromotion", method = RequestMethod.POST)
	public String getPromotionToUpdate(@RequestParam("editBtn") String id, Model model) {
		
		PromotionVO promotionVO = promotionManagementService.findById(new Integer(id));
		logger.debug("Loading update promotion page for " + promotionVO.toString());
		DateFormat df = new SimpleDateFormat("dd-MM-YYYY K:mm a");
		String startDateString = df.format(promotionVO.getPromotionStartDate());
    	String endDateString = df.format(promotionVO.getPromotionEndDate());
    	promotionVO.setPromotionperiod(startDateString + " - " + endDateString);
    	
		model.addAttribute("promotionForm", promotionVO);
		return "updatePromotion";
	}
	
	@RequestMapping(value = "/updatePromotionToDb", method = RequestMethod.POST)
	public String updatePromotion(@ModelAttribute("promotionForm") @Validated PromotionVO promotionVO,
			BindingResult result, Model model, final RedirectAttributes redirectAttributes) {
		
		logger.debug("updatePromotion() : " + promotionVO.toString());
		
		if (result.hasErrors()) {
			return "updatePromotion";
		} else {
			promotionManagementService.updatePromotion(promotionVO);
			redirectAttributes.addFlashAttribute("css", "success");
			redirectAttributes.addFlashAttribute("msg", "Promotion updated successfully!");
		}
		
		return "redirect:listPromotion";
	}
	
	
	@RequestMapping(value = "/viewPromotion", method = RequestMethod.POST)
	public String viewPromotion(@RequestParam("viewBtn") String id, Model model) {
		logger.debug("id = " + id);
		PromotionVO promotionVO = promotionManagementService.findById(new Integer(id));
		if (promotionVO == null) {
			model.addAttribute("css", "danger");
			model.addAttribute("msg", "Promotion not found");
		}
		model.addAttribute("promotion", promotionVO);

		return "viewPromotion";

	}
	
	
}