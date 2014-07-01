package com.wantdo.domain;

import java.io.File;
import java.io.Serializable;

public class FileBean implements Serializable{
	
	private File file;
	private String uri;
	public FileBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FileBean(File file, String uri) {
		super();
		this.file = file;
		this.uri = uri;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	@Override
	public String toString() {
		return "FileBean [file=" + file + ", uri=" + uri + "]";
	}
	
	
	

}
