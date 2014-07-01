package com.wantdo.dao;

import java.util.List;

import com.wantdo.domain.XzShop;

public interface IXzShopDAO {

	public abstract void save(XzShop transientInstance);

	public abstract void saveAll(List list);

	public abstract void delete(XzShop persistentInstance);

	public abstract XzShop findById(java.lang.Integer id);

	public abstract List findAll();

}