package com.wantdo.test;


import java.io.File;
import java.util.List;

import org.dom4j.Element;
import org.junit.Test;

import com.wantdo.common.XmlParser;
import com.wantdo.common.xmlparser.XzJpnzParser;
import com.wantdo.domain.XzJpnz;

public class XmlParserTest {
	
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
				"//extraction/full_path","//extraction/shop_content/item");
		System.out.println(list.size());
	}

}
