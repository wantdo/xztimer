package com.wantdo.test;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.dom4j.Element;
import org.junit.Test;
import org.springframework.beans.factory.xml.XmlBeanFactory;

import com.wantdo.common.IXmlParser;
import com.wantdo.common.XmlParser;
import com.wantdo.common.xmlparser.XzJpnzParser;
import com.wantdo.dao.IXzJpnzDAO;
import com.wantdo.domain.XzJpnz;
import com.wantdo.service.IXzJpnzService;

public class XzJpnzTest {
	
	private XmlBeanFactory factory;
	
	public XzJpnzTest() {
		super();
		factory=BeanFactory.getFactory();
	}
	
	@Test
	public void testgetFiles(){
		XmlParser xmlParser=new XzJpnzParser();
		File[] files=xmlParser.getFiles("D:\\DataScraperWorks\\xz_jpnz");
		System.out.println(files.length);
	}
	

	@Test
	public void testgetItemList() {
		XmlParser xmlParser=new XzJpnzParser();
		List<Element> list=xmlParser.getItemList(
				new File("D:\\DataScraperWorks\\xz_jpnz\\xz_jpnz_77604511_2564849566.xml"), 
				"//extraction/shop_content/item");
		System.out.println(list.size());
	}
	
	@Test
	public void testgetItemDetail(){
		XmlParser xmlParser=new XzJpnzParser();
		List<XzJpnz> list=xmlParser.getAllItem("D:\\DataScraperWorks\\xz_jpnz", 
				"//extraction/fullpath","//extraction/shop_content/item");
		System.out.println(list.size());
	}
	

	@Test
	public void testDaosaveAll() {
		IXzJpnzDAO dao=(IXzJpnzDAO)factory.getBean("XzJpnzDAO");
		XmlParser xmlParser=new XzJpnzParser();
		List list=xmlParser.getAllItem("D:\\DataScraperWorks\\xz_jpnz", 
				"//extraction/fullpath","//extraction/shop_content/item");
		System.out.println(list.size());
		dao.saveAll(list);
		System.out.println("save successed");
	}
	
	@Test
	public void testServicesaveAll() {
		IXzJpnzService service=(IXzJpnzService)factory.getBean("XzJpnzService");
		XmlParser xmlParser=new XzJpnzParser();
		List list=xmlParser.getAllItem("D:\\DataScraperWorks\\xz_jpnz", 
				"//extraction/fullpath","//extraction/shop_content/item");
		System.out.println(list.size());
		service.saveAll(list);
		System.out.println("save successed");
	}

}
