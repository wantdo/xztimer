package com.wantdo.domain;

import java.sql.Timestamp;

/**
 * XzDownloadId entity. @author MyEclipse Persistence Tools
 */

public class XzDownloadId implements java.io.Serializable {

	// Fields

	private String shopId;
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
	public XzDownloadId() {
	}

	/** minimal constructor */
	public XzDownloadId(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public XzDownloadId(String shopId, Integer id, String dataTitle,
			String dataSize, String dataHref, Timestamp dataTime,
			Timestamp uploadTime, String clue, String alias) {
		this.shopId = shopId;
		this.id = id;
		this.dataTitle = dataTitle;
		this.dataSize = dataSize;
		this.dataHref = dataHref;
		this.dataTime = dataTime;
		this.uploadTime = uploadTime;
		this.clue = clue;
		this.alias = alias;
	}

	// Property accessors

	public String getShopId() {
		return this.shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

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

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof XzDownloadId))
			return false;
		XzDownloadId castOther = (XzDownloadId) other;

		return ((this.getShopId() == castOther.getShopId()) || (this
				.getShopId() != null && castOther.getShopId() != null && this
				.getShopId().equals(castOther.getShopId())))
				&& ((this.getId() == castOther.getId()) || (this.getId() != null
						&& castOther.getId() != null && this.getId().equals(
						castOther.getId())))
				&& ((this.getDataTitle() == castOther.getDataTitle()) || (this
						.getDataTitle() != null
						&& castOther.getDataTitle() != null && this
						.getDataTitle().equals(castOther.getDataTitle())))
				&& ((this.getDataSize() == castOther.getDataSize()) || (this
						.getDataSize() != null
						&& castOther.getDataSize() != null && this
						.getDataSize().equals(castOther.getDataSize())))
				&& ((this.getDataHref() == castOther.getDataHref()) || (this
						.getDataHref() != null
						&& castOther.getDataHref() != null && this
						.getDataHref().equals(castOther.getDataHref())))
				&& ((this.getDataTime() == castOther.getDataTime()) || (this
						.getDataTime() != null
						&& castOther.getDataTime() != null && this
						.getDataTime().equals(castOther.getDataTime())))
				&& ((this.getUploadTime() == castOther.getUploadTime()) || (this
						.getUploadTime() != null
						&& castOther.getUploadTime() != null && this
						.getUploadTime().equals(castOther.getUploadTime())))
				&& ((this.getClue() == castOther.getClue()) || (this.getClue() != null
						&& castOther.getClue() != null && this.getClue()
						.equals(castOther.getClue())))
				&& ((this.getAlias() == castOther.getAlias()) || (this
						.getAlias() != null && castOther.getAlias() != null && this
						.getAlias().equals(castOther.getAlias())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getShopId() == null ? 0 : this.getShopId().hashCode());
		result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
		result = 37 * result
				+ (getDataTitle() == null ? 0 : this.getDataTitle().hashCode());
		result = 37 * result
				+ (getDataSize() == null ? 0 : this.getDataSize().hashCode());
		result = 37 * result
				+ (getDataHref() == null ? 0 : this.getDataHref().hashCode());
		result = 37 * result
				+ (getDataTime() == null ? 0 : this.getDataTime().hashCode());
		result = 37
				* result
				+ (getUploadTime() == null ? 0 : this.getUploadTime()
						.hashCode());
		result = 37 * result
				+ (getClue() == null ? 0 : this.getClue().hashCode());
		result = 37 * result
				+ (getAlias() == null ? 0 : this.getAlias().hashCode());
		return result;
	}

}