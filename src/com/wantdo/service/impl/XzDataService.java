package com.wantdo.service.impl;

import java.util.List;

import com.wantdo.dao.IXzDataDAO;
import com.wantdo.domain.XzData;
import com.wantdo.service.IXzDataService;

public class XzDataService implements IXzDataService {
	
	private IXzDataDAO xzDataDAO;

	@Override
	public void save(XzData transientInstance) {
		// TODO Auto-generated method stub
		xzDataDAO.save(transientInstance);
	}

	@Override
	public Object getById(Integer id) {
		// TODO Auto-generated method stub
		return xzDataDAO.findById(id);
	}

	@Override
	public List getAll() {
		// TODO Auto-generated method stub
		return xzDataDAO.findAll();
	}

	@Override
	public void saveAll(List list) {
		// TODO Auto-generated method stub
		xzDataDAO.saveAll(list);
	}

	@Override
	public void delete(XzData persistentInstance) {
		// TODO Auto-generated method stub
		xzDataDAO.delete(persistentInstance);
	}

	public IXzDataDAO getXzDataDAO() {
		return xzDataDAO;
	}

	public void setXzDataDAO(IXzDataDAO xzDataDAO) {
		this.xzDataDAO = xzDataDAO;
	}
	
}
