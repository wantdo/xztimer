package com.wantdo.test;

import java.io.File;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.dom4j.Element;
import org.junit.Test;
import org.springframework.beans.factory.xml.XmlBeanFactory;

import com.wantdo.common.XmlParser;
import com.wantdo.common.xmlparser.XzJpnzParser;
import com.wantdo.common.xmlparser.XzShopParser;
import com.wantdo.dao.IXzShopDAO;
import com.wantdo.domain.XzJpnz;
import com.wantdo.domain.XzShop;
import com.wantdo.service.IXzShopService;

public class XzShopTest {

private XmlBeanFactory factory;
	
	public XzShopTest() {
		super();
		factory=BeanFactory.getFactory();
	}
	
	
	@Test
	public void testgetFiles(){
		XmlParser xmlParser=new XzShopParser();
		File[] files=xmlParser.getFiles("D:\\DataScraperWorks\\xz_shop");
		System.out.println(files.length);
	}
	

	@Test
	public void testgetItemList() {
		XmlParser xmlParser=new XzShopParser();
		List<Element> list=xmlParser.getItemList(
				new File("D:\\DataScraperWorks\\xz_shop\\xz_shop_77604513_2564854004.xml"), 
				"//extraction/shop/item");
		System.out.println(list.size());
	}
	
	@Test
	public void testgetItemDetail(){
		XmlParser xmlParser=new XzShopParser();
		List<XzJpnz> list=xmlParser.getAllItem("D:\\DataScraperWorks\\xz_shop", 
				"//extraction/fullpath","//extraction/shop/item");
		System.out.println(list.size());
	}

	@Test
	public void testDaosaveAll() {
		IXzShopDAO dao=(IXzShopDAO)factory.getBean("XzShopDAO");
		XmlParser xmlParser=new XzShopParser();
		List list=xmlParser.getAllItem("D:\\DataScraperWorks\\xz_shop", 
				"//extraction/fullpath","//extraction/shop/item");
		System.out.println(list.size());
		dao.saveAll(list);
		System.out.println("save successed");
	}
	
	@Test
	public void testServicesaveAll() {
		IXzShopService service=(IXzShopService)factory.getBean("XzShopService");
		XmlParser xmlParser=new XzShopParser();
		List list=xmlParser.getAllItem("D:\\DataScraperWorks\\xz_shop", 
				"//extraction/fullpath","//extraction/shop/item");
		System.out.println(list.size());
		service.saveAll(list);
		System.out.println("save successed");
	}
	

}
