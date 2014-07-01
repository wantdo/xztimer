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

import com.wantdo.dao.IXzFirstDAO;
import com.wantdo.domain.XzFirst;
import com.wantdo.domain.XzShop;

/**
 * A data access object (DAO) providing persistence and search support for
 * XzFirst entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.wantdo.domain.XzFirst
 * @author MyEclipse Persistence Tools
 */
public class XzFirstDAO extends HibernateDaoSupport implements IXzFirstDAO {
	private static final Logger log = LoggerFactory.getLogger(XzFirstDAO.class);
	// property constants
	public static final String DATA_TITLE = "dataTitle";
	public static final String DATA_SIZE = "dataSize";
	public static final String DATA_HREF = "dataHref";
	public static final String CLUE = "clue";
	public static final String ALIAS = "alias";

	protected void initDao() {
		// do nothing
	}

	
	/* (非 Javadoc) 
	* <p>Title: save</p> 
	* <p>Description: </p> 
	* @param transientInstance 
	* @see com.wantdo.dao.impl.IXzFirstDAO#save(com.wantdo.domain.XzFirst) 
	*/ 
	@Override
	public void save(XzFirst transientInstance) {
		log.debug("saving XzFirst instance");
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
	* @see com.wantdo.dao.impl.IXzFirstDAO#saveAll(java.util.List) 
	*/ 
	@Override
	public void saveAll(final List list){
		log.debug("saving all XzFirst instance");
		try {
			getHibernateTemplate().execute(new HibernateCallback() {

				@Override
				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					// TODO Auto-generated method stub
					Connection conn=null;
					CallableStatement cs=null;
					try {
						String proc="call sp_insert_first(?,?,?,?,?,?,?)";
						conn=session.connection();
						cs=conn.prepareCall(proc);
						for(Object object:list){
							XzFirst xzFirst=(XzFirst)object;
							cs.setString(1, xzFirst.getDataTitle());
							cs.setString(2, xzFirst.getDataSize());
							cs.setString(3, xzFirst.getDataHref());
							cs.setTimestamp(4, xzFirst.getDataTime());
							cs.setTimestamp(5, xzFirst.getUploadTime());
							cs.setString(6, xzFirst.getClue());
							cs.setString(7, xzFirst.getAlias());
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
	* @see com.wantdo.dao.impl.IXzFirstDAO#delete(com.wantdo.domain.XzFirst) 
	*/ 
	@Override
	public void delete(XzFirst persistentInstance) {
		log.debug("deleting XzFirst instance");
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
	* @see com.wantdo.dao.impl.IXzFirstDAO#findById(java.lang.Integer) 
	*/ 
	@Override
	public XzFirst findById(java.lang.Integer id) {
		log.debug("getting XzFirst instance with id: " + id);
		try {
			XzFirst instance = (XzFirst) getHibernateTemplate().get(
					"com.wantdo.domain.XzFirst", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(XzFirst instance) {
		log.debug("finding XzFirst instance by example");
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
		log.debug("finding XzFirst instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from XzFirst as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByDataTitle(Object dataTitle) {
		return findByProperty(DATA_TITLE, dataTitle);
	}

	public List findByDataSize(Object dataSize) {
		return findByProperty(DATA_SIZE, dataSize);
	}

	public List findByDataHref(Object dataHref) {
		return findByProperty(DATA_HREF, dataHref);
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
	* @see com.wantdo.dao.impl.IXzFirstDAO#findAll() 
	*/ 
	@Override
	public List findAll() {
		log.debug("finding all XzFirst instances");
		try {
			String queryString = "from XzFirst";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public XzFirst merge(XzFirst detachedInstance) {
		log.debug("merging XzFirst instance");
		try {
			XzFirst result = (XzFirst) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(XzFirst instance) {
		log.debug("attaching dirty XzFirst instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(XzFirst instance) {
		log.debug("attaching clean XzFirst instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static IXzFirstDAO getFromApplicationContext(ApplicationContext ctx) {
		return (IXzFirstDAO) ctx.getBean("XzFirstDAO");
	}
}