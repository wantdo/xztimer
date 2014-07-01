package com.wantdo.dao;

import java.util.List;

import com.wantdo.domain.XzFirst;

public interface IXzFirstDAO {

	public abstract void save(XzFirst transientInstance);

	public abstract void saveAll(List list);

	public abstract void delete(XzFirst persistentInstance);

	public abstract XzFirst findById(java.lang.Integer id);

	public abstract List findAll();

}