package com.wantdo.common.xmlparser;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Element;

import com.wantdo.common.XmlParser;
import com.wantdo.domain.XzJpnz;
import com.wantdo.utils.DateParseUtil;
import com.wantdo.utils.StringUtils;

/**
 * 

* @ClassName: XzJpnzParser 

* @Description: xz_jpnz的xml文件解析类

* @author sa luanx@wantdo.com

* @date 2014-6-16 上午11:53:34 

*
 */

public class XzJpnzParser extends XmlParser{
	
	private final Log logger=LogFactory.getLog(getClass());

	@Override
	public List<XzJpnz> getAllItem(String path,String cdata,String xpath) {
		// TODO Auto-generated method stub
		List<XzJpnz> list=new ArrayList<XzJpnz>();
		File[] files=getFiles(path);
		for(File file:files){
			String clue=getItemList(file, cdata).get(0).getStringValue();
			List<Element> itemList=getItemList(file, xpath);
			if (itemList.size()==0) {
				throw new RuntimeException("xpath error");
			}else {
				for(Element element:itemList){
					String shopId=element.elementText("shop_id");
					shopId=StringUtils.replaceBlank(shopId, "\\s*|\t|\r|\n");
					String shopHref=element.elementText("shop_href");
					String taobaoHref=element.elementText("taobao_href");
					String shopAlias=element.elementText("shop_alias");
					list.add(new XzJpnz(shopId, shopHref, taobaoHref, shopAlias, 
							DateParseUtil.date2Timestamp(new Date()), clue,shopId));
				}
			}
		}
		return list;
	}


}
