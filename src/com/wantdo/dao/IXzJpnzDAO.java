package com.wantdo.dao;

import java.util.List;

import com.wantdo.domain.XzJpnz;

public interface IXzJpnzDAO {

	public abstract void save(XzJpnz transientInstance);

	public abstract void saveAll(List list);

	public abstract void delete(XzJpnz persistentInstance);

	public abstract XzJpnz findById(java.lang.Integer id);

	public abstract List findAll();

}