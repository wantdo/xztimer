package com.wantdo.service.impl;

import java.util.List;

import com.wantdo.dao.IXzJpnzDAO;
import com.wantdo.domain.XzJpnz;
import com.wantdo.domain.XzShop;
import com.wantdo.service.IXzJpnzService;

public class XzJpnzService implements IXzJpnzService {
	
	private IXzJpnzDAO xzJpnzDAO;

	@Override
	public  void save(XzJpnz transientInstance) {
		// TODO Auto-generated method stub
		xzJpnzDAO.save(transientInstance);
	}

	@Override
	public Object getById(Integer id) {
		// TODO Auto-generated method stub
		return xzJpnzDAO.findById(id);
	}


	@Override
	public List getAll() {
		// TODO Auto-generated method stub
		return xzJpnzDAO.findAll();
	}

	@Override
	public void saveAll(List list) {
		// TODO Auto-generated method stub
		xzJpnzDAO.saveAll(list);
	}

	public IXzJpnzDAO getXzJpnzDAO() {
		return xzJpnzDAO;
	}

	public void setXzJpnzDAO(IXzJpnzDAO xzJpnzDAO) {
		this.xzJpnzDAO = xzJpnzDAO;
	}

	@Override
	public void delete(XzJpnz persistentInstance) {
		// TODO Auto-generated method stub
		xzJpnzDAO.delete(persistentInstance);
	}
	
	

}
