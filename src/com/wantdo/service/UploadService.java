package com.wantdo.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.wantdo.common.xmlparser.XzDataParser;
import com.wantdo.common.xmlparser.XzFirstParser;
import com.wantdo.common.xmlparser.XzJpnzParser;
import com.wantdo.common.xmlparser.XzShopParser;

/**
 * 

* @ClassName: UploadService 

* @Description: 定时上传任务类

* @author sa luanx@wantdo.com

* @date 2014-6-13 下午4:38:39 

*
 */

public class UploadService extends QuartzJobBean {
	
	private final  Log logger=LogFactory.getLog(getClass());
	private static final String ROOT="D:\\DataScraperWorks\\";
	
	private IXzJpnzService xzJpnzService;
	private IXzShopService xzShopService;
	private IXzDataService xzDataService;
	private IXzFirstService xzFirstService;
	
	@Override
	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException {
		// TODO Auto-generated method stub
		logger.info("upload job is started");
		logger.info("xzjpnz:"+xzJpnzService);
		new XzJpnzUploadThread(new XzJpnzParser().getAllItem(
				ROOT+"xz_jpnz", "//extraction/fullpath",
				"//extraction/shop_content/item")).start();
		new XzShopUploadThread(new XzShopParser().getAllItem(
				ROOT+"xz_shop", "//extraction/fullpath",
				"//extraction/shop/item")).start();
		new XzDataUploadThread(new XzDataParser().getAllItem(
				ROOT+"xz_data", "//extraction/fullpath",
				"//extraction/data/item")).start();
		new XzFirstUploadThread(new XzFirstParser().getAllItem(
				ROOT+"xz_first", "//extraction/fullpath",
				"//extraction/data_link/item")).start();
	}


	public IXzJpnzService getXzJpnzService() {
		return xzJpnzService;
	}


	public void setXzJpnzService(IXzJpnzService xzJpnzService) {
		this.xzJpnzService = xzJpnzService;
	}



	public IXzShopService getXzShopService() {
		return xzShopService;
	}
	
	


	public IXzDataService getXzDataService() {
		return xzDataService;
	}


	public void setXzDataService(IXzDataService xzDataService) {
		this.xzDataService = xzDataService;
	}


	public IXzFirstService getXzFirstService() {
		return xzFirstService;
	}


	public void setXzFirstService(IXzFirstService xzFirstService) {
		this.xzFirstService = xzFirstService;
	}


	public void setXzShopService(IXzShopService xzShopService) {
		this.xzShopService = xzShopService;
	}


	private final class XzJpnzUploadThread extends Thread{
		
		private List list;
		
		public XzJpnzUploadThread(List list) {
			super();
			this.list = list;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			logger.info(xzJpnzService);
			xzJpnzService.saveAll(list);
		}
		
	}
	
	private final class XzShopUploadThread extends Thread{
		
		private List list;
		
		public XzShopUploadThread(List list) {
			super();
			this.list = list;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			logger.info(xzShopService);
			xzShopService.saveAll(list);
		}
		
	}
	

	private final class XzDataUploadThread extends Thread{
	
		private List list;
	
		public XzDataUploadThread(List list) {
			super();
			this.list = list;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			logger.info(xzDataService);
			xzDataService.saveAll(list);
		}
	
	}

	private final class XzFirstUploadThread extends Thread{
	
		private List list;
	
		public XzFirstUploadThread(List list) {
			super();
			this.list = list;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			logger.info(xzFirstService);
			xzFirstService.saveAll(list);
		}
	
	}
	

}
