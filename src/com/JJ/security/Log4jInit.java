package com.JJ.security;

import java.io.File;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

public class Log4jInit extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@Autowired
	private Environment environment;
	
	public void init(ServletConfig config) {
		try{
			super.init(config);
		    SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
		    String profile = this.environment.getActiveProfiles()[0];
		    String fileName =  "C:/Inetpub/vhosts/ziumlight.com/Configuration/log4j-"+profile+".properties";
	    
	    	File file = new File(fileName);
	    	if(file.exists() && file != null) {
	  	      PropertyConfigurator.configure(fileName);
	  	    }
	    }catch(Exception ex){
	    	
	    }
	    
	    // if the log4j-init-file is not set, then no point in trying
	    
	  }
	
  public void doGet(HttpServletRequest req, HttpServletResponse res) {
	  
  }

}
