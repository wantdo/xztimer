package com.wantdo.service.impl;

import java.util.List;

import com.wantdo.dao.IXzDownloadDAO;
import com.wantdo.domain.XzDownload;
import com.wantdo.domain.XzDownloadId;
import com.wantdo.service.IXzDownloadService;

public class XzDownloadService implements IXzDownloadService {
	
	private IXzDownloadDAO xzDownloadDAO;

	@Override
	public void save(XzDownload transientInstance) {
		// TODO Auto-generated method stub
		xzDownloadDAO.save(transientInstance);
	}

	@Override
	public void delete(XzDownload persistentInstance) {
		// TODO Auto-generated method stub
		xzDownloadDAO.delete(persistentInstance);
	}

	@Override
	public XzDownload getById(XzDownloadId id) {
		// TODO Auto-generated method stub
		return xzDownloadDAO.findById(id);
	}

	@Override
	public List getAll() {
		// TODO Auto-generated method stub
		return xzDownloadDAO.findAll();
	}

	public IXzDownloadDAO getXzDownloadDAO() {
		return xzDownloadDAO;
	}

	public void setXzDownloadDAO(IXzDownloadDAO xzDownloadDAO) {
		this.xzDownloadDAO = xzDownloadDAO;
	}
	

}
