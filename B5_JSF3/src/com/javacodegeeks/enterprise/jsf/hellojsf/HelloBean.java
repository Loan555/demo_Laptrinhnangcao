package com.javacodegeeks.enterprise.jsf.hellojsf;
import java.io.Serializable;

import javax.annotation.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class HelloBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private String name;
	private String pass;
	public String getName() {
	return name;
	}
	public void setName(String name) {
	this.name = name;
	}
	public String getpass() {
		return pass;
		}
	public void setpass(String pass) {
		this.pass = pass;
		}
	public String sayWelcome() {
			if("".equals(name) || name == null)
			 return "" ; 
			else {
			return "Ajax message : Welcome " + name +pass ;
			}
	}
}
