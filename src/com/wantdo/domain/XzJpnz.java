package com.wantdo.domain;

import java.sql.Timestamp;

/**
 * XzJpnz entity. @author MyEclipse Persistence Tools
 */

public class XzJpnz implements java.io.Serializable {

	// Fields

	private Integer id;
	private String shopId;
	private String shopHref;
	private String taobaoHref;
	private String shopAlias;
	private Timestamp uploadTime;
	private String clue;
	private String alias;

	// Constructors

	/** default constructor */
	public XzJpnz() {
	}

	/** full constructor */
	public XzJpnz(String shopId, String shopHref, String taobaoHref,
			String shopAlias, Timestamp uploadTime, String clue, String alias) {
		this.shopId = shopId;
		this.shopHref = shopHref;
		this.taobaoHref = taobaoHref;
		this.shopAlias = shopAlias;
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

	public String getShopId() {
		return this.shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	public String getShopHref() {
		return this.shopHref;
	}

	public void setShopHref(String shopHref) {
		this.shopHref = shopHref;
	}

	public String getTaobaoHref() {
		return this.taobaoHref;
	}

	public void setTaobaoHref(String taobaoHref) {
		this.taobaoHref = taobaoHref;
	}

	public String getShopAlias() {
		return this.shopAlias;
	}

	public void setShopAlias(String shopAlias) {
		this.shopAlias = shopAlias;
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