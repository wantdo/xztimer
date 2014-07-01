package com.wantdo.domain;

import java.sql.Timestamp;

/**
 * XzShop entity. @author MyEclipse Persistence Tools
 */

public class XzShop implements java.io.Serializable {

	// Fields

	private Integer id;
	private String shopName;
	private String shopData;
	private Timestamp uploadTime;
	private String clue;
	private String alias;

	// Constructors

	/** default constructor */
	public XzShop() {
	}

	/** minimal constructor */
	public XzShop(String shopName) {
		this.shopName = shopName;
	}

	/** full constructor */
	public XzShop(String shopName, String shopData, Timestamp uploadTime,
			String clue, String alias) {
		this.shopName = shopName;
		this.shopData = shopData;
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

	public String getShopName() {
		return this.shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getShopData() {
		return this.shopData;
	}

	public void setShopData(String shopData) {
		this.shopData = shopData;
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