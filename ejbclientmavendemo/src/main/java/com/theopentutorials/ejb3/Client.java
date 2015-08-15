package com.theopentutorials.ejb3;

import javax.naming.Context;
import javax.naming.NamingException;

import com.tma.ejb.DataBeanRemote;
import com.tma.model.Account;

public class Client {
	public static void main(String[] args) {
		DataBeanRemote bean = doLookup();
		Account account = new Account("1", "huunhan", "dsa", "das");
		bean.addAccount(account);
		System.out.println(bean.checkLogin("", "")); // 4. Call business logic
	}

	private static DataBeanRemote doLookup() {
		Context context = null;
		DataBeanRemote bean = null;
		try {
			// 1. Obtaining Context
			context = ClientUtility.getInitialContext();
			// 2. Generate JNDI Lookup name
			String lookupName = getLookupName();
			// 3. Lookup and cast
			bean = (DataBeanRemote) context.lookup(lookupName);

		} catch (NamingException e) {
			e.printStackTrace();
		}
		return bean;
	}

	private static String getLookupName() {
		String appName = "";
		String moduleName = "springhibernate-1.0-SNAPSHOT";

		String distinctName = "";
		String beanName = "DataBean";
		final String interfaceName = "com.tma.ejb.DataBeanRemote";

		String name = "ejb:" + appName + "/" + moduleName + "/" + distinctName
				+ "/" + beanName + "!" + interfaceName;

		return name;
	}
}
