package com.wantdo.domain;

/**
 * XzDownload entity. @author MyEclipse Persistence Tools
 */

public class XzDownload implements java.io.Serializable {

	// Fields

	private XzDownloadId id;

	// Constructors

	/** default constructor */
	public XzDownload() {
	}

	/** full constructor */
	public XzDownload(XzDownloadId id) {
		this.id = id;
	}

	// Property accessors

	public XzDownloadId getId() {
		return this.id;
	}

	public void setId(XzDownloadId id) {
		this.id = id;
	}

}