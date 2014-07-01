package com.wantdo.common.xmlparser;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Element;

import com.wantdo.common.XmlParser;
import com.wantdo.domain.XzData;
import com.wantdo.utils.DateParseUtil;

/**
 * 

* @ClassName: XzDataParser 

* @Description: xz_data的xml文件解析类

* @author sa luanx@wantdo.com

* @date 2014-6-17 下午5:29:55 

*
 */

public class XzDataParser extends XmlParser{
	
	private final Log logger=LogFactory.getLog(getClass());

	@Override
	public List<XzData> getAllItem(String path,String cdata,String xpath) {
		// TODO Auto-generated method stub
		List<XzData> list=new ArrayList<XzData>();
		File[] files=getFiles(path);
		for(File file:files){
			String clue=getItemList(file, cdata).get(0).getStringValue();
			List<Element> itemList=getItemList(file, xpath);
			if (itemList.size()==0) {
				throw new RuntimeException("xpath error");
			}else {
				for(Element element:itemList){
					String title=element.elementText("title");
					list.add(new XzData(title,
							DateParseUtil.date2Timestamp(new Date()), clue,title));
				}
			}
		}
		return list;
	}


}
