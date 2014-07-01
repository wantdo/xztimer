package com.wantdo.common.xmlparser;

import java.io.File;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Element;

import com.wantdo.common.XmlParser;
import com.wantdo.domain.XzData;
import com.wantdo.domain.XzFirst;
import com.wantdo.domain.XzJpnz;
import com.wantdo.utils.DateParseUtil;
import com.wantdo.utils.StringUtils;

/**
 * 

* @ClassName: XzFirstParser 

* @Description: xz_first的xml文件解析类

* @author sa luanx@wantdo.com

* @date 2014-6-17 下午5:29:55 

*
 */

public class XzFirstParser extends XmlParser{
	
	private final Log logger=LogFactory.getLog(getClass());

	@Override
	public List<XzFirst> getAllItem(String path,String cdata,String xpath) {
		// TODO Auto-generated method stub
		List<XzFirst> list=new ArrayList<XzFirst>();
		File[] files=getFiles(path);
		for(File file:files){
			String clue=getItemList(file, cdata).get(0).getStringValue();
			List<Element> itemList=getItemList(file, xpath);
			if (itemList.size()==0) {
				throw new RuntimeException("xpath error");
			}else {
				for(Element element:itemList){
					//将data_title中的信息拆开并分别存入dataTitle和dataSize
					String title=element.elementText("data_title");
					String dataTitle=title.substring(0,title.lastIndexOf(' '));
					String dataSize=StringUtils.replaceBlank(
							title.substring(title.lastIndexOf(' '), title.length()), "\\s*|\t|\r|\n");
					String dataHref=element.elementText("data_href");
					//将url中的空格，中括号转义
					dataHref=dataHref.replaceAll(" ", "%20").replaceAll("\\[", "%5B")
							.replaceAll("\\]", "%5D").replaceAll("/note/fd.htm\\?", "");
					String time=element.elementText("data_time");
					Timestamp dataTime=DateParseUtil.string2Timestamp(time.substring(time.indexOf(":")+1, time.length()));
					list.add(new XzFirst(dataTitle, dataSize, dataHref, dataTime, 
							DateParseUtil.date2Timestamp(new Date()), clue,dataTitle));
				}
			}
		}
		return list;
	}


}
