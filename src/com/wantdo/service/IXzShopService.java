package com.wantdo.service;

import java.util.List;

import com.wantdo.domain.XzShop;

public interface IXzShopService{
	
	public abstract void save(XzShop transientInstance);

	public abstract Object getById(java.lang.Integer id);

	public abstract List getAll();
	
	public abstract void saveAll(List list);
	
	public abstract void delete(XzShop persistentInstance);

}
