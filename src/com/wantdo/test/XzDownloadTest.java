package com.wantdo.test;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.xml.XmlBeanFactory;

import com.wantdo.dao.IXzDownloadDAO;
import com.wantdo.service.IXzDownloadService;

public class XzDownloadTest {
	
private XmlBeanFactory factory;
	
	public XzDownloadTest() {
		super();
		factory=BeanFactory.getFactory();
	}

	@Test
	public void testDaofindAll() {
		IXzDownloadDAO dao=(IXzDownloadDAO)factory.getBean("XzDownloadDAO");
		List list=dao.findAll();
		System.out.println(list.size());
	}
	
	@Test
	public void testServicefindAll() {
		IXzDownloadService service=(IXzDownloadService)factory.getBean("XzDownloadService");
		List list=service.getAll();
		System.out.println(list.size());
	}

}
