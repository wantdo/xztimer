package com.wantdo.test;

import java.io.File;
import java.util.List;

import org.dom4j.Element;
import org.junit.Test;
import org.springframework.beans.factory.xml.XmlBeanFactory;

import com.wantdo.common.XmlParser;
import com.wantdo.common.xmlparser.XzDataParser;
import com.wantdo.dao.IXzDataDAO;
import com.wantdo.domain.XzJpnz;
import com.wantdo.service.IXzDataService;

public class XzDataTest {

private XmlBeanFactory factory;
	
	public XzDataTest() {
		super();
		factory=BeanFactory.getFactory();
	}
	
	
	@Test
	public void testgetFiles(){
		XmlParser xmlParser=new XzDataParser();
		File[] files=xmlParser.getFiles("D:\\DataScraperWorks\\xz_data");
		System.out.println(files.length);
	}
	

	@Test
	public void testgetItemList() {
		XmlParser xmlParser=new XzDataParser();
		List<Element> list=xmlParser.getItemList(
				new File("D:\\DataScraperWorks\\xz_data\\xz_data_77604968_2565195800.xml"), 
				"//extraction/data/item");
		System.out.println(list.size());
	}
	
	@Test
	public void testgetItemDetail(){
		XmlParser xmlParser=new XzDataParser();
		List<XzJpnz> list=xmlParser.getAllItem("D:\\DataScraperWorks\\xz_data", 
				"//extraction/fullpath","//extraction/data/item");
		System.out.println(list.size());
	}

	@Test
	public void testDaosaveAll() {
		IXzDataDAO dao=(IXzDataDAO)factory.getBean("XzDataDAO");
		XmlParser xmlParser=new XzDataParser();
		List list=xmlParser.getAllItem("D:\\DataScraperWorks\\xz_data", 
				"//extraction/fullpath","//extraction/data/item");
		System.out.println(list.size());
		dao.saveAll(list);
		System.out.println("save successed");
	}
	
	@Test
	public void testServicesaveAll() {
		IXzDataService service=(IXzDataService)factory.getBean("XzDataService");
		XmlParser xmlParser=new XzDataParser();
		List list=xmlParser.getAllItem("D:\\DataScraperWorks\\xz_data", 
				"//extraction/fullpath","//extraction/data/item");
		System.out.println(list.size());
		service.saveAll(list);
		System.out.println("save successed");
	}

}
