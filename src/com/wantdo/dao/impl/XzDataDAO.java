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

import com.wantdo.dao.IXzDataDAO;
import com.wantdo.domain.XzData;
import com.wantdo.domain.XzJpnz;

/**
 * A data access object (DAO) providing persistence and search support for
 * XzData entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.wantdo.domain.XzData
 * @author MyEclipse Persistence Tools
 */
public class XzDataDAO extends HibernateDaoSupport implements IXzDataDAO {
	private static final Logger log = LoggerFactory.getLogger(XzDataDAO.class);
	// property constants
	public static final String TITLE = "title";
	public static final String CLUE = "clue";
	public static final String ALIAS = "alias";

	protected void initDao() {
		// do nothing
	}

	
	/* (非 Javadoc) 
	* <p>Title: save</p> 
	* <p>Description: </p> 
	* @param transientInstance 
	* @see com.wantdo.dao.impl.IXzDataDAO#save(com.wantdo.domain.XzData) 
	*/ 
	@Override
	public void save(XzData transientInstance) {
		log.debug("saving XzData instance");
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
	* @see com.wantdo.dao.impl.IXzDataDAO#saveAll(java.util.List) 
	*/ 
	@Override
	public void saveAll(final List list){
		log.debug("saving all XzData instance");
		try {
			getHibernateTemplate().execute(new HibernateCallback() {

				@Override
				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					// TODO Auto-generated method stub
					Connection conn=null;
					CallableStatement cs=null;
					try {
						String proc="call sp_insert_data(?,?,?,?)";
						conn=session.connection();
						cs=conn.prepareCall(proc);
						for(Object object:list){
							XzData xzData=(XzData)object;
							cs.setString(1, xzData.getTitle());
							cs.setTimestamp(2, xzData.getUploadTime());
							cs.setString(3, xzData.getClue());
							cs.setString(4, xzData.getAlias());
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
	* @see com.wantdo.dao.impl.IXzDataDAO#delete(com.wantdo.domain.XzData) 
	*/ 
	@Override
	public void delete(XzData persistentInstance) {
		log.debug("deleting XzData instance");
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
	* @see com.wantdo.dao.impl.IXzDataDAO#findById(java.lang.Integer) 
	*/ 
	@Override
	public XzData findById(java.lang.Integer id) {
		log.debug("getting XzData instance with id: " + id);
		try {
			XzData instance = (XzData) getHibernateTemplate().get(
					"com.wantdo.domain.XzData", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(XzData instance) {
		log.debug("finding XzData instance by example");
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
		log.debug("finding XzData instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from XzData as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByTitle(Object title) {
		return findByProperty(TITLE, title);
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
	* @see com.wantdo.dao.impl.IXzDataDAO#findAll() 
	*/ 
	@Override
	public List findAll() {
		log.debug("finding all XzData instances");
		try {
			String queryString = "from XzData";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public XzData merge(XzData detachedInstance) {
		log.debug("merging XzData instance");
		try {
			XzData result = (XzData) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(XzData instance) {
		log.debug("attaching dirty XzData instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(XzData instance) {
		log.debug("attaching clean XzData instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static IXzDataDAO getFromApplicationContext(ApplicationContext ctx) {
		return (IXzDataDAO) ctx.getBean("XzDataDAO");
	}
}