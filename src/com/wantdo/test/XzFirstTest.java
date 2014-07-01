package com.wantdo.test;

import java.io.File;
import java.util.List;

import org.dom4j.Element;
import org.junit.Test;
import org.springframework.beans.factory.xml.XmlBeanFactory;

import com.wantdo.common.XmlParser;
import com.wantdo.common.xmlparser.XzFirstParser;
import com.wantdo.dao.IXzFirstDAO;
import com.wantdo.domain.XzFirst;
import com.wantdo.domain.XzJpnz;
import com.wantdo.service.IXzFirstService;

public class XzFirstTest {

private XmlBeanFactory factory;
	
	public XzFirstTest() {
		super();
		factory=BeanFactory.getFactory();
	}
	
	
	@Test
	public void testgetFiles(){
		XmlParser xmlParser=new XzFirstParser();
		File[] files=xmlParser.getFiles("D:\\DataScraperWorks\\xz_first");
		System.out.println(files.length);
	}
	

	@Test
	public void testgetItemList() {
		XmlParser xmlParser=new XzFirstParser();
		List<Element> list=xmlParser.getItemList(
				new File("D:\\DataScraperWorks\\xz_first\\xz_first_77604968_2565198160.xml"), 
				"//extraction/data_link/item");
		System.out.println(list.size());
	}
	
	@Test
	public void testgetItemDetail(){
		XmlParser xmlParser=new XzFirstParser();
		List<XzJpnz> list=xmlParser.getAllItem("D:\\DataScraperWorks\\xz_first", 
				"//extraction/fullpath","//extraction/data_link/item");
		System.out.println(list.size());
	}

	@Test
	public void testDaosaveAll() {
		IXzFirstDAO dao=(IXzFirstDAO)factory.getBean("XzFirstDAO");
		XmlParser xmlParser=new XzFirstParser();
		List list=xmlParser.getAllItem("D:\\DataScraperWorks\\xz_first", 
				"//extraction/fullpath","//extraction/data_link/item");
		System.out.println(list.size());
		dao.saveAll(list);
		System.out.println("save successed");
	}
	
	@Test
	public void testServicesaveAll() {
		IXzFirstService service=(IXzFirstService)factory.getBean("XzFirstService");
		XmlParser xmlParser=new XzFirstParser();
		List list=xmlParser.getAllItem("D:\\DataScraperWorks\\xz_first", 
				"//extraction/fullpath","//extraction/data_link/item");
		System.out.println(list.size());
		service.saveAll(list);
		System.out.println("save successed");
	}
	

}
