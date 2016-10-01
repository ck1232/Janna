package janna.testing.controller;

import java.io.Serializable;

import javax.ejb.Init;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.stereotype.Controller;
@Controller
@ManagedBean
@ViewScoped
public class IndexController implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String value = "testing123";

	@Init
	public void init(){
		System.out.println("ok");
	}
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
