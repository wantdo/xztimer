package com.wantdo.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 

* @ClassName: StringUtils 

* @Description: String������

* @author sa luanx@wantdo.com

* @date 2014-6-17 ����5:57:03 

*
 */

public class StringUtils {
	
	public static String replaceBlank(String str,String regex){
		String dest="";
		if (str!=null) {
			Pattern pattern=Pattern.compile(regex);
			Matcher matcher=pattern.matcher(str);
			dest=matcher.replaceAll("");
		}
		return dest;
	}

}
