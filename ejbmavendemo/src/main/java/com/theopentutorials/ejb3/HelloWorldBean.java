package com.theopentutorials.ejb3;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class HelloWorldBean
 */
@Stateless
public class HelloWorldBean implements HelloWorld {

	public HelloWorldBean() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String sayHello() {
		return "Hello Java Dinh Huu Nhan";
	}

}
