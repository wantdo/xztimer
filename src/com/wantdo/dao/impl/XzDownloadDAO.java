package com.wantdo.dao.impl;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.wantdo.dao.IXzDownloadDAO;
import com.wantdo.domain.XzDownload;

/**
 * A data access object (DAO) providing persistence and search support for
 * XzDownload entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.wantdo.domain.XzDownload
 * @author MyEclipse Persistence Tools
 */
public class XzDownloadDAO extends HibernateDaoSupport implements IXzDownloadDAO {
	private static final Logger log = LoggerFactory
			.getLogger(XzDownloadDAO.class);

	// property constants

	protected void initDao() {
		// do nothing
	}

	
	/* (非 Javadoc) 
	* <p>Title: save</p> 
	* <p>Description: </p> 
	* @param transientInstance 
	* @see com.wantdo.dao.impl.IXzDownloadDAO#save(com.wantdo.domain.XzDownload) 
	*/ 
	@Override
	public void save(XzDownload transientInstance) {
		log.debug("saving XzDownload instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	
	/* (非 Javadoc) 
	* <p>Title: delete</p> 
	* <p>Description: </p> 
	* @param persistentInstance 
	* @see com.wantdo.dao.impl.IXzDownloadDAO#delete(com.wantdo.domain.XzDownload) 
	*/ 
	@Override
	public void delete(XzDownload persistentInstance) {
		log.debug("deleting XzDownload instance");
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
	* @see com.wantdo.dao.impl.IXzDownloadDAO#findById(com.wantdo.domain.XzDownloadId) 
	*/ 
	@Override
	public XzDownload findById(com.wantdo.domain.XzDownloadId id) {
		log.debug("getting XzDownload instance with id: " + id);
		try {
			XzDownload instance = (XzDownload) getHibernateTemplate().get(
					"com.wantdo.domain.XzDownload", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(XzDownload instance) {
		log.debug("finding XzDownload instance by example");
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
		log.debug("finding XzDownload instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from XzDownload as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	
	/* (非 Javadoc) 
	* <p>Title: findAll</p> 
	* <p>Description: </p> 
	* @return 
	* @see com.wantdo.dao.impl.IXzDownloadDAO#findAll() 
	*/ 
	@Override
	public List findAll() {
		log.debug("finding all XzDownload instances");
		try {
			String queryString = "from XzDownload";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public XzDownload merge(XzDownload detachedInstance) {
		log.debug("merging XzDownload instance");
		try {
			XzDownload result = (XzDownload) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(XzDownload instance) {
		log.debug("attaching dirty XzDownload instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(XzDownload instance) {
		log.debug("attaching clean XzDownload instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static IXzDownloadDAO getFromApplicationContext(ApplicationContext ctx) {
		return (IXzDownloadDAO) ctx.getBean("XzDownloadDAO");
	}
}