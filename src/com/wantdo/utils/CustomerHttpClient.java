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

* @Description: ��װ��HttpClient

* @author sa luanx@wantdo.com

* @date 2014-6-10 ����5:26:45 

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
			//����һЩ��������
			
			HttpParams params=new BasicHttpParams();
			HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
			HttpProtocolParams.setContentCharset(params, HTTP.UTF_8);
			HttpProtocolParams.setUseExpectContinue(params, true);
			HttpProtocolParams.setUserAgent(params, 
					"Mozilla/5.0(Linux;U;Android 2.2.1;en-us;Nexus One Build.FRG83) " +
					"AppleWebKit/553.1(KHTML,like Gecko) Version/4.0 Mobile Safari/533.1");
			
			/*
			//��ʱ����
			//�����ӳ���ȡ���ӵĳ�ʱʱ��
			ConnManagerParams.setTimeout(params, 5000);
			//ͨ��������������������ӵĳ�ʱʱ��
			HttpConnectionParams.setConnectionTimeout(params, 10000);
			*/
			//Socket��ȡ���ݵĳ�ʱʱ�䣬���ӷ�������ȡ��Ӧ������Ҫ�ȴ���ʱ��
			 HttpConnectionParams.setSoTimeout(params, 10000);
			 
			
		  //  MAX_ROUTE_CONNECTIONSΪҪ���õ�ÿ��·�����������
			ConnPerRouteBean connPerRoute = new ConnPerRouteBean(MAX_ROUTE_CONNECTIONS);
			ConnManagerParams.setMaxConnectionsPerRoute(params,connPerRoute);
			
			//����HttpClient֧��HTTP��HTTPS����ģʽ
			SchemeRegistry schemeRegistry=new SchemeRegistry();
			schemeRegistry.register(new Scheme("http", 
					PlainSocketFactory.getSocketFactory(), 80));
			schemeRegistry.register(new Scheme("https", 
					SSLSocketFactory.getSocketFactory(), 443));
			//ʹ���̰߳�ȫ�����ӹ���������HttpClient
			ClientConnectionManager cm=new ThreadSafeClientConnManager();
			httpClient=new DefaultHttpClient(cm, params);
		}
		return httpClient;
	}

	//��װ�򵥵�get����
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
