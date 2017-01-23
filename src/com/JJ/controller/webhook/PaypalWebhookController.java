package com.JJ.controller.webhook;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.JJ.controller.webhook.vo.Webhook;
import com.JJ.model.JsonResponse;

@Controller  
@EnableWebMvc
@RequestMapping(value = "/paypal")
public class PaypalWebhookController {
	private static final Logger logger = Logger.getLogger(PaypalWebhookController.class);
	@RequestMapping(value = "/webhook", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody JsonResponse notification(HttpServletRequest request, @RequestBody Webhook webhook) throws Exception {
		logger.debug("ok");
	    return new JsonResponse("ok");
	}
	
	@RequestMapping(value={"/","/dashboard"})
	public String loadDashboard(HttpSession session) {  
		return "dashboard";
	}
}
