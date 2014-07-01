package com.wantdo.common;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.dom4j.Element;

import com.wantdo.domain.XzJpnz;

/**
 * 

* @ClassName: IXmlParser 

* @Description: Xml解析接口

* @author sa luanx@wantdo.com

* @date 2014-6-16 下午2:01:49 

*
 */

public interface IXmlParser {
	
	public abstract File[] getFiles(String path);
	
	public abstract List<Element> getItemList(File file,String path);
	
	public  abstract List getAllItem(String path,String cdata,String xpath);

}
