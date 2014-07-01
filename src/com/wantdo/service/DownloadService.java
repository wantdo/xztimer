package com.wantdo.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.wantdo.domain.FileBean;
import com.wantdo.domain.XzDownload;
import com.wantdo.domain.XzDownloadId;
import com.wantdo.utils.CustomerHttpClient;
import com.wantdo.utils.FileUtils;

/**
 * 

* @ClassName: DownloadService 

* @Description: 定时下载任务类

* @author sa luanx@wantdo.com

* @date 2014-6-13 下午5:28:12 

*
 */

public class DownloadService extends QuartzJobBean {
	
	private final Log logger=LogFactory.getLog(getClass());
	private static final String FILE_PATH="d:\\xz";
	
	private IXzDownloadService xzDownloadService;
	private static File dir;
	
	static{
		mkdir();
	}
	
	private static void mkdir() {
		// TODO Auto-generated method stub
		dir=new File(FILE_PATH);
		if (!dir.exists()) {
			dir.mkdirs();
		}
	}

	@Override
	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException {
		// TODO Auto-generated method stub
		logger.info("download job is started");
		List<XzDownload> list=xzDownloadService.getAll();
		logger.info("xzDownloadService get all:"+list.size());
		List<FileBean> downList=null;
		try {
			downList=new ArrayList<FileBean>();
			if (list.size()!=0) {
				int threadId=0;
				for(XzDownload xzDownload:list){
					XzDownloadId downloadId=xzDownload.getId();
					String dataHref=downloadId.getDataHref();
					if(dataHref.equals("/note/1.htm")){
						continue;
					}
					String dataAlias=downloadId.getAlias();
					String shopId=downloadId.getShopId();
					String title=dataAlias.substring(0, dataAlias.lastIndexOf('.'))+"("
							+shopId+")"+dataAlias.substring(dataAlias.lastIndexOf('.'));
					File file=new File(dir.getAbsolutePath()+File.separator+title);
					String dataSize=downloadId.getDataSize();
					try {
						if (file.exists()) {
							if (dataSize.equals(FileUtils.getFileSize(file))) {
								continue;
							}
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					downList.add(new FileBean(file, dataHref));
				}
				logger.info("download list size : "+downList.size());
				GetThread[] threads=new GetThread[downList.size()];
				for(int i=0;i<downList.size();++i){
					threads[i]=new GetThread(downList.get(i));
				}
				for(int i=0;i<downList.size();++i){
					threads[i].start();
				}
				for(int i=0;i<downList.size();++i){
					threads[i].join();
				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("download job is end");
	}


	public IXzDownloadService getXzDownloadService() {
		return xzDownloadService;
	}

	public void setXzDownloadService(IXzDownloadService xzDownloadService) {
		this.xzDownloadService = xzDownloadService;
	}
	
	/**
	 * 
	
	* @ClassName: GetThread 
	
	* @Description: 下载线程类
	
	* @author sa luanx@wantdo.com
	
	* @date 2014-6-19 下午2:33:33 
	
	*
	 */
	private final class GetThread extends Thread{
		
		private FileBean fileBean;
		
		public GetThread(FileBean fileBean) {
			super();
			this.fileBean=fileBean;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			logger.info(Thread.currentThread().getName()+" -about to get something from "+fileBean.getUri());
			try {
				CustomerHttpClient.get(fileBean.getFile(),fileBean.getUri());
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
