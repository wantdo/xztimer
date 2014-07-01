package com.wantdo.service;

import java.util.List;

import com.wantdo.domain.XzData;
import com.wantdo.domain.XzShop;

public interface IXzDataService{
	
	public abstract void save(XzData transientInstance);

	public abstract Object getById(java.lang.Integer id);

	public abstract List getAll();
	
	public abstract void saveAll(List list);
	
	public abstract void delete(XzData persistentInstance);

}
