package com.wantdo.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 

* @ClassName: DateParseUtil 

* @Description: ����ת��������

* @author sa luanx@wantdo.com

* @date 2014-6-18 ����4:57:11 

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
	* @Description: ��ʽ�����ڶ���
	* @param @param date
	* @param @param formatStr
	* @param @return    �趨�ļ� 
	* @return Date    �������� 
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
	* @Description: ʱ�����ת��Ϊ�ַ���
	* @param @param date
	* @param @param formatStr
	* @param @return    �趨�ļ� 
	* @return String    �������� 
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
	* @Description: sqlʱ�����ת��Ϊ�ַ���
	* @param @param timestamp
	* @param @param formatStr
	* @param @return    �趨�ļ� 
	* @return String    �������� 
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
	* @Description: �ַ���ת��Ϊʱ�����
	* @param @param dateStr
	* @param @param formatStr
	* @param @return    �趨�ļ� 
	* @return Date    �������� 
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
	* @Description: Date����ת��ΪTimestamp����
	* @param @param date
	* @param @return    �趨�ļ� 
	* @return Timestamp    �������� 
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
	* @Description: ��õ�ǰ���
	* @param @return    �趨�ļ� 
	* @return String    �������� 
	* @throws
	 */
	public static String getNowYear(){
		SimpleDateFormat sdf=new SimpleDateFormat(YYYY);
		return sdf.format(new Date());
	}
	
	/**
	 * 
	* @Title: getNowMonth 
	* @Description: ��õ�ǰ�·�
	* @param @return    �趨�ļ� 
	* @return String    �������� 
	* @throws
	 */
	public static String getNowMonth(){
		SimpleDateFormat sdf=new SimpleDateFormat(MM);
		return sdf.format(new Date());
	}
	
	/**
	 * 
	* @Title: getNowDay 
	* @Description: ��õ�ǰ����
	* @param @return    �趨�ļ� 
	* @return String    �������� 
	* @throws
	 */
	public static String getNowDay(){
		SimpleDateFormat sdf=new SimpleDateFormat(DD);
		return sdf.format(new Date());
	}

}
