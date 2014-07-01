package com.wantdo.service.impl;

import java.util.List;

import com.wantdo.dao.IXzShopDAO;
import com.wantdo.domain.XzShop;
import com.wantdo.service.IXzShopService;

public class XzShopService implements IXzShopService {
	
	private IXzShopDAO xzShopDAO;

	@Override
	public void save(XzShop transientInstance) {
		// TODO Auto-generated method stub
		xzShopDAO.save(transientInstance);
	}

	@Override
	public Object getById(Integer id) {
		// TODO Auto-generated method stub
		return xzShopDAO.findById(id);
	}

	@Override
	public List getAll() {
		// TODO Auto-generated method stub
		return xzShopDAO.findAll();
	}

	@Override
	public void saveAll(List list) {
		// TODO Auto-generated method stub
		xzShopDAO.saveAll(list);
	}

	public IXzShopDAO getXzShopDAO() {
		return xzShopDAO;
	}

	public void setXzShopDAO(IXzShopDAO xzShopDAO) {
		this.xzShopDAO = xzShopDAO;
	}

	@Override
	public void delete(XzShop persistentInstance) {
		// TODO Auto-generated method stub
		xzShopDAO.delete(persistentInstance);
	}
	
	

}
