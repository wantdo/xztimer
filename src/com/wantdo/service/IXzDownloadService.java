package com.wantdo.service;

import java.util.List;

import com.wantdo.domain.XzDownload;

public interface IXzDownloadService {
	
	public abstract void save(XzDownload transientInstance);

	public abstract void delete(XzDownload persistentInstance);

	public abstract XzDownload getById(com.wantdo.domain.XzDownloadId id);

	public abstract List getAll();

}
