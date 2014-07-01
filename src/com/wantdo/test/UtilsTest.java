package com.wantdo.test;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import antlr.FileLineFormatter;

import com.wantdo.utils.FileUtils;

public class UtilsTest {

	@Test
	public void testgetFileSize() throws IOException {
		System.out.println(FileUtils.getFileSize(new File("D:\\xz\\精品105 6月5号新款(105).zip")));
	}
	
	@Test
	public void getUnCompFile() throws IOException{
		File file=new File("d:\\xz");
		File[] files=file.listFiles();
		int num=0;
		for(File tmp:files){
			String size=FileUtils.getFileSize(tmp);
			if (size.equals("1KB")) {
				++num;
			}
		}
		System.out.println("num:"+num);
	}
	

}
