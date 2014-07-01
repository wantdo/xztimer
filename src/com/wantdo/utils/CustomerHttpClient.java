package com.wantdo.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.HttpVersion;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HTTP;


/**
 * 

* @ClassName: CustomerHttpClient 

* @Description: 封装的HttpClient

* @author sa luanx@wantdo.com

* @date 2014-6-10 下午5:26:45 

*
 */

public class CustomerHttpClient {
	
	private static final int BUFFER_SIZE=1024;
	private static final int MAX_ROUTE_CONNECTIONS=20;
	
	private static HttpClient httpClient;
	

	public CustomerHttpClient() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public static synchronized HttpClient getHttpClient(){
		if (httpClient==null) {
			//设置一些基本参数
			
			HttpParams params=new BasicHttpParams();
			HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
			HttpProtocolParams.setContentCharset(params, HTTP.UTF_8);
			HttpProtocolParams.setUseExpectContinue(params, true);
			HttpProtocolParams.setUserAgent(params, 
					"Mozilla/5.0(Linux;U;Android 2.2.1;en-us;Nexus One Build.FRG83) " +
					"AppleWebKit/553.1(KHTML,like Gecko) Version/4.0 Mobile Safari/533.1");
			
			/*
			//超时设置
			//从连接池中取连接的超时时间
			ConnManagerParams.setTimeout(params, 5000);
			//通过网络与服务器建立连接的超时时间
			HttpConnectionParams.setConnectionTimeout(params, 10000);
			*/
			//Socket读取数据的超时时间，即从服务器获取响应数据需要等待的时间
			 HttpConnectionParams.setSoTimeout(params, 10000);
			 
			
		  //  MAX_ROUTE_CONNECTIONS为要设置的每个路由最大连接数
			ConnPerRouteBean connPerRoute = new ConnPerRouteBean(MAX_ROUTE_CONNECTIONS);
			ConnManagerParams.setMaxConnectionsPerRoute(params,connPerRoute);
			
			//设置HttpClient支持HTTP和HTTPS两种模式
			SchemeRegistry schemeRegistry=new SchemeRegistry();
			schemeRegistry.register(new Scheme("http", 
					PlainSocketFactory.getSocketFactory(), 80));
			schemeRegistry.register(new Scheme("https", 
					SSLSocketFactory.getSocketFactory(), 443));
			//使用线程安全的连接管理来创建HttpClient
			ClientConnectionManager cm=new ThreadSafeClientConnManager();
			httpClient=new DefaultHttpClient(cm, params);
		}
		return httpClient;
	}

	//封装简单的get请求
	public static void get(File file,String uri) throws IOException{
		// TODO Auto-generated method stub
		HttpClient httpClient=null;
		BufferedInputStream is=null;
		BufferedOutputStream os=null;
		HttpGet httpGet=null;
		try {
			httpClient=getHttpClient();
			httpGet=new HttpGet(uri);
			HttpResponse httpResponse=httpClient.execute(httpGet);
			if (httpResponse.getStatusLine().getStatusCode()!=HttpStatus.SC_OK) {
				throw new RuntimeException("the request failed");
			}
			HttpEntity entity=httpResponse.getEntity();
			os=new BufferedOutputStream(new FileOutputStream(file));
			if (entity!=null) {
				is=new BufferedInputStream(entity.getContent());
				byte[] buffer=new byte[BUFFER_SIZE];
				int len=0;
				while ((len=is.read(buffer))!=-1) {
					os.write(buffer,0,len);
				}
			}else {
				System.out.println("entity from uri is null");
			}
			os.flush();
			os.close();
			is.close();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				if (os!=null) {
					os.close();
				}
				if (is!=null) {
					is.close();
				}
				httpGet.releaseConnection();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	

}
