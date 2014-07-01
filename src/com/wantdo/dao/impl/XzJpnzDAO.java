package com.wantdo.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.wantdo.dao.IXzJpnzDAO;
import com.wantdo.domain.XzJpnz;

/**
 * A data access object (DAO) providing persistence and search support for
 * XzJpnz entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.wantdo.domain.XzJpnz
 * @author MyEclipse Persistence Tools
 */
public class XzJpnzDAO extends HibernateDaoSupport implements IXzJpnzDAO {
	private static final Logger log = LoggerFactory.getLogger(XzJpnzDAO.class);
	// property constants
	public static final String SHOP_ID = "shopId";
	public static final String SHOP_HREF = "shopHref";
	public static final String TAOBAO_HREF = "taobaoHref";
	public static final String SHOP_ALIAS = "shopAlias";
	public static final String CLUE = "clue";
	public static final String ALIAS = "alias";

	protected void initDao() {
		// do nothing
	}

	
	/* (非 Javadoc) 
	* <p>Title: save</p> 
	* <p>Description: </p> 
	* @param transientInstance 
	* @see com.wantdo.dao.impl.IXzJpnzDAO#save(com.wantdo.domain.XzJpnz) 
	*/ 
	@Override
	public void save(XzJpnz transientInstance) {
		log.debug("saving XzJpnz instance");
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
	* @see com.wantdo.dao.impl.IXzJpnzDAO#saveAll(java.util.List) 
	*/ 
	@Override
	public void saveAll(final List list){
		log.debug("saving all XzJpnz instance");
		try {
			getHibernateTemplate().execute(new HibernateCallback() {

				@Override
				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					// TODO Auto-generated method stub
					Connection conn=null;
					CallableStatement cs=null;
					try {
						String proc="call sp_insert_jpnz(?,?,?,?,?,?,?)";
						conn=session.connection();
						cs=conn.prepareCall(proc);
						for(Object object:list){
							XzJpnz xzJpnz=(XzJpnz)object;
							cs.setString(1, xzJpnz.getShopId());
							cs.setString(2, xzJpnz.getShopHref());
							cs.setString(3, xzJpnz.getTaobaoHref());
							cs.setString(4, xzJpnz.getShopAlias());
							cs.setTimestamp(5, xzJpnz.getUploadTime());
							cs.setString(6, xzJpnz.getClue());
							cs.setString(7, xzJpnz.getAlias());
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
	* @see com.wantdo.dao.impl.IXzJpnzDAO#delete(com.wantdo.domain.XzJpnz) 
	*/ 
	@Override
	public void delete(XzJpnz persistentInstance) {
		log.debug("deleting XzJpnz instance");
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
	* @see com.wantdo.dao.impl.IXzJpnzDAO#findById(java.lang.Integer) 
	*/ 
	@Override
	public XzJpnz findById(java.lang.Integer id) {
		log.debug("getting XzJpnz instance with id: " + id);
		try {
			XzJpnz instance = (XzJpnz) getHibernateTemplate().get(
					"com.wantdo.domain.XzJpnz", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(XzJpnz instance) {
		log.debug("finding XzJpnz instance by example");
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
		log.debug("finding XzJpnz instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from XzJpnz as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByShopId(Object shopId) {
		return findByProperty(SHOP_ID, shopId);
	}

	public List findByShopHref(Object shopHref) {
		return findByProperty(SHOP_HREF, shopHref);
	}

	public List findByTaobaoHref(Object taobaoHref) {
		return findByProperty(TAOBAO_HREF, taobaoHref);
	}

	public List findByShopAlias(Object shopAlias) {
		return findByProperty(SHOP_ALIAS, shopAlias);
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
	* @see com.wantdo.dao.impl.IXzJpnzDAO#findAll() 
	*/ 
	@Override
	public List findAll() {
		log.debug("finding all XzJpnz instances");
		try {
			String queryString = "from XzJpnz";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public XzJpnz merge(XzJpnz detachedInstance) {
		log.debug("merging XzJpnz instance");
		try {
			XzJpnz result = (XzJpnz) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(XzJpnz instance) {
		log.debug("attaching dirty XzJpnz instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(XzJpnz instance) {
		log.debug("attaching clean XzJpnz instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static IXzJpnzDAO getFromApplicationContext(ApplicationContext ctx) {
		return (IXzJpnzDAO) ctx.getBean("XzJpnzDAO");
	}
}