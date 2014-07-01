package com.wantdo.domain;

import java.sql.Timestamp;

/**
 * XzData entity. @author MyEclipse Persistence Tools
 */

public class XzData implements java.io.Serializable {

	// Fields

	private Integer id;
	private String title;
	private Timestamp uploadTime;
	private String clue;
	private String alias;

	// Constructors

	/** default constructor */
	public XzData() {
	}

	/** full constructor */
	public XzData(String title, Timestamp uploadTime, String clue, String alias) {
		this.title = title;
		this.uploadTime = uploadTime;
		this.clue = clue;
		this.alias = alias;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Timestamp getUploadTime() {
		return this.uploadTime;
	}

	public void setUploadTime(Timestamp uploadTime) {
		this.uploadTime = uploadTime;
	}

	public String getClue() {
		return this.clue;
	}

	public void setClue(String clue) {
		this.clue = clue;
	}

	public String getAlias() {
		return this.alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

}