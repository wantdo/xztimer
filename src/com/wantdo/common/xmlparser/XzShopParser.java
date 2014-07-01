package com.wantdo.common.xmlparser;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Element;

import com.wantdo.common.XmlParser;
import com.wantdo.domain.XzJpnz;
import com.wantdo.domain.XzShop;
import com.wantdo.utils.DateParseUtil;
import com.wantdo.utils.StringUtils;

/**
 * 

* @ClassName: XzShopParser 

* @Description: xz_shop的xml文件解析类

* @author sa luanx@wantdo.com

* @date 2014-6-17 下午5:29:55 

*
 */

public class XzShopParser extends XmlParser{
	
	private final Log logger=LogFactory.getLog(getClass());

	@Override
	public List<XzShop> getAllItem(String path,String cdata,String xpath) {
		// TODO Auto-generated method stub
		List<XzShop> list=new ArrayList<XzShop>();
		File[] files=getFiles(path);
		for(File file:files){
			String clue=getItemList(file, cdata).get(0).getStringValue();
			List<Element> itemList=getItemList(file, xpath);
			if (itemList.size()==0) {
				throw new RuntimeException("xpath error");
			}else {
				for(Element element:itemList){
					String shopName=element.elementText("shop_name");
					shopName=StringUtils.replaceBlank(shopName, "\\s*|\t|\r|\n");
					String shopData=element.elementText("shop_data");
					list.add(new XzShop(shopName, shopData,
							DateParseUtil.date2Timestamp(new Date()),clue,shopName));
				}
			}
		}
		return list;
	}


}
