package com.wantdo.service.impl;

import java.util.List;

import com.wantdo.dao.IXzFirstDAO;
import com.wantdo.domain.XzFirst;
import com.wantdo.service.IXzFirstService;

public class XzFirstService implements IXzFirstService {
	
	private IXzFirstDAO xzFirstDAO;

	@Override
	public void save(XzFirst transientInstance) {
		// TODO Auto-generated method stub
		xzFirstDAO.save(transientInstance);
	}

	@Override
	public void saveAll(List list) {
		// TODO Auto-generated method stub
		xzFirstDAO.saveAll(list);
	}

	@Override
	public void delete(XzFirst persistentInstance) {
		// TODO Auto-generated method stub
		xzFirstDAO.delete(persistentInstance);
	}

	@Override
	public XzFirst getById(Integer id) {
		// TODO Auto-generated method stub
		return xzFirstDAO.findById(id);
	}

	@Override
	public List getAll() {
		// TODO Auto-generated method stub
		return xzFirstDAO.findAll();
	}

	public IXzFirstDAO getXzFirstDAO() {
		return xzFirstDAO;
	}

	public void setXzFirstDAO(IXzFirstDAO xzFirstDAO) {
		this.xzFirstDAO = xzFirstDAO;
	}
	
	

}
