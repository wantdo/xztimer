package com.wantdo.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.text.NumberFormat;
import java.util.Locale;

public class FileUtils {

	/**
	 * 
	* @Title: getFileSize 
	* @Description: ��ȡ�ļ���С
	* @param @param file
	* @param @return
	* @param @throws IOException    �趨�ļ� 
	* @return String    �������� 
	* @throws
	 */
	public static String getFileSize(File file) throws IOException {
		FileInputStream is=null;
		FileChannel fc=null;
		long s=0;
		if (file.exists()) {
			is=new FileInputStream(file);
			fc=is.getChannel();
			s=fc.size();
		}
		NumberFormat usFormat = NumberFormat.getIntegerInstance(Locale.US);
 		return usFormat.format(Math.round(s*1.0f/1024))+"KB";
	}
	
}
