package com.wantdo.service;

import java.util.List;

import com.wantdo.domain.XzFirst;

public interface IXzFirstService {
	
	public abstract void save(XzFirst transientInstance);

	public abstract void saveAll(List list);

	public abstract void delete(XzFirst persistentInstance);

	public abstract XzFirst getById(java.lang.Integer id);

	public abstract List getAll();

}
