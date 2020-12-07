package com.javacodegeeks.enterprise.jsf.hellojsf;

import java.io.Serializable;

import javax.annotation.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class HelloBean1 implements Serializable{
	private static final long serialVersionUID = 1L;
	private String name;
	public String getName() {
	return name;
	}
	public void setName(String name) {
	this.name = name;
	}

}
