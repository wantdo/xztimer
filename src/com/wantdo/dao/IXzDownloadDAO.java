package com.wantdo.dao;

import java.util.List;

import com.wantdo.domain.XzDownload;

public interface IXzDownloadDAO {

	public abstract void save(XzDownload transientInstance);

	public abstract void delete(XzDownload persistentInstance);

	public abstract XzDownload findById(com.wantdo.domain.XzDownloadId id);

	public abstract List findAll();

}