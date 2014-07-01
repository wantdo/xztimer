package com.wantdo.domain;

import java.sql.Timestamp;

/**
 * XzFirst entity. @author MyEclipse Persistence Tools
 */

public class XzFirst implements java.io.Serializable {

	// Fields

	private Integer id;
	private String dataTitle;
	private String dataSize;
	private String dataHref;
	private Timestamp dataTime;
	private Timestamp uploadTime;
	private String clue;
	private String alias;

	// Constructors

	/** default constructor */
	public XzFirst() {
	}

	/** full constructor */
	public XzFirst(String dataTitle, String dataSize, String dataHref,
			Timestamp dataTime, Timestamp uploadTime, String clue, String alias) {
		this.dataTitle = dataTitle;
		this.dataSize = dataSize;
		this.dataHref = dataHref;
		this.dataTime = dataTime;
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

	public String getDataTitle() {
		return this.dataTitle;
	}

	public void setDataTitle(String dataTitle) {
		this.dataTitle = dataTitle;
	}

	public String getDataSize() {
		return this.dataSize;
	}

	public void setDataSize(String dataSize) {
		this.dataSize = dataSize;
	}

	public String getDataHref() {
		return this.dataHref;
	}

	public void setDataHref(String dataHref) {
		this.dataHref = dataHref;
	}

	public Timestamp getDataTime() {
		return this.dataTime;
	}

	public void setDataTime(Timestamp dataTime) {
		this.dataTime = dataTime;
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