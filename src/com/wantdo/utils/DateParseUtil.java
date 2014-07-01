package com.wantdo.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 

* @ClassName: DateParseUtil 

* @Description: 日期转换工具类

* @author sa luanx@wantdo.com

* @date 2014-6-18 下午4:57:11 

*
 */

public class DateParseUtil {
	
	public static final String ENG_DATE_FROMAT = "EEE, d MMM yyyy HH:mm:ss z";  
    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";  
    public static final String YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";  
    public static final String YYYY_MM_DD = "yyyy-MM-dd";  
    public static final String YYYY = "yyyy";  
    public static final String MM = "MM";  
    public static final String DD = "dd"; 
	
	/**
	 * 
	* @Title: date2date 
	* @Description: 格式化日期对象
	* @param @param date
	* @param @param formatStr
	* @param @return    设定文件 
	* @return Date    返回类型 
	* @throws
	 */
	public static Date date2date(Date date,String formatStr){
		SimpleDateFormat sdf=new SimpleDateFormat(formatStr);
		String str=sdf.format(date);
		try {
			date=sdf.parse(str);
			return date;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	* @Title: date2string 
	* @Description: 时间对象转换为字符串
	* @param @param date
	* @param @param formatStr
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	public static String date2string(Date date,String formatStr){
		String strDate="";
		SimpleDateFormat sdf=new SimpleDateFormat(formatStr);
		strDate=sdf.format(date);
		return strDate;
	}
	
	/**
	 * 
	* @Title: timestamp2string 
	* @Description: sql时间对象转换为字符串
	* @param @param timestamp
	* @param @param formatStr
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	public static String timestamp2string(Timestamp timestamp,String formatStr){
		String strDate="";
		SimpleDateFormat sdf=new SimpleDateFormat(formatStr);
		strDate=sdf.format(timestamp);
		return strDate;
	}
	
	/**
	 * 
	* @Title: string2date 
	* @Description: 字符串转换为时间对象
	* @param @param dateStr
	* @param @param formatStr
	* @param @return    设定文件 
	* @return Date    返回类型 
	* @throws
	 */
	public static Date string2date(String dateStr,String formatStr){
		Date formatDate=null;
		SimpleDateFormat sdf=new SimpleDateFormat(formatStr);
		try {
			formatDate=sdf.parse(dateStr);
			return formatDate;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	* @Title: date2Timestamp 
	* @Description: Date类型转换为Timestamp类型
	* @param @param date
	* @param @return    设定文件 
	* @return Timestamp    返回类型 
	* @throws
	 */
	public static Timestamp date2Timestamp(Date date){
		if (date==null) {
			return null;
		}
		return new Timestamp(date.getTime());
	}
	
	public static Timestamp string2Timestamp(String dateStr){
		Date date=string2date(dateStr, "yyyy-MM-dd HH:mm:ss");
		return date2Timestamp(date);
	}
	
	/**
	 * 
	* @Title: getNowYear 
	* @Description: 获得当前年份
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	public static String getNowYear(){
		SimpleDateFormat sdf=new SimpleDateFormat(YYYY);
		return sdf.format(new Date());
	}
	
	/**
	 * 
	* @Title: getNowMonth 
	* @Description: 获得当前月份
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	public static String getNowMonth(){
		SimpleDateFormat sdf=new SimpleDateFormat(MM);
		return sdf.format(new Date());
	}
	
	/**
	 * 
	* @Title: getNowDay 
	* @Description: 获得当前日期
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	public static String getNowDay(){
		SimpleDateFormat sdf=new SimpleDateFormat(DD);
		return sdf.format(new Date());
	}

}
