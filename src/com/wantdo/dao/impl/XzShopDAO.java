package com.wantdo.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.wantdo.dao.IXzShopDAO;
import com.wantdo.domain.XzJpnz;
import com.wantdo.domain.XzShop;

/**
 * A data access object (DAO) providing persistence and search support for
 * XzShop entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.wantdo.domain.XzShop
 * @author MyEclipse Persistence Tools
 */
public class XzShopDAO extends HibernateDaoSupport implements IXzShopDAO {
	private static final Logger log = LoggerFactory.getLogger(XzShopDAO.class);
	// property constants
	public static final String SHOP_NAME = "shopName";
	public static final String SHOP_DATA = "shopData";
	public static final String CLUE = "clue";
	public static final String ALIAS = "alias";

	protected void initDao() {
		// do nothing
	}

	
	/* (非 Javadoc) 
	* <p>Title: save</p> 
	* <p>Description: </p> 
	* @param transientInstance 
	* @see com.wantdo.dao.impl.IXzShopDAO#save(com.wantdo.domain.XzShop) 
	*/ 
	@Override
	public void save(XzShop transientInstance) {
		log.debug("saving XzShop instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	
	
	/* (非 Javadoc) 
	* <p>Title: saveAll</p> 
	* <p>Description: </p> 
	* @param list 
	* @see com.wantdo.dao.impl.IXzShopDAO#saveAll(java.util.List) 
	*/ 
	@Override
	public void saveAll(final List list){
		log.debug("saving all XzShop instance");
		try {
			getHibernateTemplate().execute(new HibernateCallback() {

				@Override
				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					// TODO Auto-generated method stub
					Connection conn=null;
					CallableStatement cs=null;
					try {
						String proc="call sp_insert_shop(?,?,?,?,?)";
						conn=session.connection();
						cs=conn.prepareCall(proc);
						for(Object object:list){
							XzShop xzShop=(XzShop)object;
							cs.setString(1, xzShop.getShopName());
							cs.setString(2, xzShop.getShopData());
							cs.setTimestamp(3, xzShop.getUploadTime());
							cs.setString(4, xzShop.getClue());
							cs.setString(5, xzShop.getAlias());
							cs.execute();
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally{
						try {
							if (cs!=null) {
								cs.close();
							}
							if (conn!=null) {
								conn.close();
							}
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					return null;
				}
			});
		} catch (RuntimeException re) {
			// TODO: handle exception
			log.error("save all failed",re);
			throw re;
		}
	}

	
	/* (非 Javadoc) 
	* <p>Title: delete</p> 
	* <p>Description: </p> 
	* @param persistentInstance 
	* @see com.wantdo.dao.impl.IXzShopDAO#delete(com.wantdo.domain.XzShop) 
	*/ 
	@Override
	public void delete(XzShop persistentInstance) {
		log.debug("deleting XzShop instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	
	/* (非 Javadoc) 
	* <p>Title: findById</p> 
	* <p>Description: </p> 
	* @param id
	* @return 
	* @see com.wantdo.dao.impl.IXzShopDAO#findById(java.lang.Integer) 
	*/ 
	@Override
	public XzShop findById(java.lang.Integer id) {
		log.debug("getting XzShop instance with id: " + id);
		try {
			XzShop instance = (XzShop) getHibernateTemplate().get(
					"com.wantdo.domain.XzShop", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(XzShop instance) {
		log.debug("finding XzShop instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding XzShop instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from XzShop as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByShopName(Object shopName) {
		return findByProperty(SHOP_NAME, shopName);
	}

	public List findByShopData(Object shopData) {
		return findByProperty(SHOP_DATA, shopData);
	}

	public List findByClue(Object clue) {
		return findByProperty(CLUE, clue);
	}

	public List findByAlias(Object alias) {
		return findByProperty(ALIAS, alias);
	}

	
	/* (非 Javadoc) 
	* <p>Title: findAll</p> 
	* <p>Description: </p> 
	* @return 
	* @see com.wantdo.dao.impl.IXzShopDAO#findAll() 
	*/ 
	@Override
	public List findAll() {
		log.debug("finding all XzShop instances");
		try {
			String queryString = "from XzShop";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public XzShop merge(XzShop detachedInstance) {
		log.debug("merging XzShop instance");
		try {
			XzShop result = (XzShop) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(XzShop instance) {
		log.debug("attaching dirty XzShop instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(XzShop instance) {
		log.debug("attaching clean XzShop instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static IXzShopDAO getFromApplicationContext(ApplicationContext ctx) {
		return (IXzShopDAO) ctx.getBean("XzShopDAO");
	}
}