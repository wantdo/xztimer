package com.wantdo.dao;

import java.util.List;

import com.wantdo.domain.XzData;

public interface IXzDataDAO {

	public abstract void save(XzData transientInstance);

	public abstract void saveAll(List list);

	public abstract void delete(XzData persistentInstance);

	public abstract XzData findById(java.lang.Integer id);

	public abstract List findAll();

}