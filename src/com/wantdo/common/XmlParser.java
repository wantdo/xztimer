package com.wantdo.common;

import java.io.File;
import java.io.FilenameFilter;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.wantdo.domain.XzJpnz;

public abstract class XmlParser implements IXmlParser {
	
	private final Log logger=LogFactory.getLog(getClass());
	
	
	//��ȡ�ļ��������е�xml�ļ�
	@Override
	public File[] getFiles(String path){
		File dir=new File(path);
		//����ļ����Ƿ����
		if (!dir.exists()) {
			return null;
		}
		File[] files=dir.listFiles(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				// TODO Auto-generated method stub
				return name.endsWith(".xml");
			}
		});
		logger.info("xml file count:"+files.length);
		return files;
	}

	//��ȡ�ļ��ж�Ӧ·���µ�Element�б�
	@Override
	public List<Element> getItemList(File file,String path) {
		// TODO Auto-generated method stub
		SAXReader saxReader=new SAXReader();
		Document document;
		try {
			document = saxReader.read(file);
			return document.selectNodes(path);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	@Override
	public abstract List getAllItem(String path,String cdata,String xpath);

}
