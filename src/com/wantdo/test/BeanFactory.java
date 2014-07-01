package com.wantdo.test;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class BeanFactory {
	
	public static XmlBeanFactory factory;
	
	static{
		factory=new XmlBeanFactory(new ClassPathResource("config/applicationContext.xml"));
	}
	
	public static XmlBeanFactory getFactory(){
		return factory;
	}

}
