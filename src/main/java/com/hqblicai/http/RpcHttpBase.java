package com.hqblicai.http;

import java.net.SocketTimeoutException;

import org.apache.http.conn.ConnectTimeoutException;
import org.apache.log4j.Logger;

public class RpcHttpBase {
	public static final Object HTTP_ERROR_CODE = "4000";
	public static String HTTP_ERROR="HTTP_ERROR";
	public static String HTTP_ERROR_CODE1="h0001";
	public static String HTTP_ERROR_CODE2="h0002";
	public static String HTTP_ERROR_CODE9999="h9999";
	
	private Logger logger=Logger.getLogger(RpcHttpBase.class);
	
	protected void logConnectTime(String url, long start) {
		long end = System.currentTimeMillis();
		logger.info("请求[" + url + "]消耗时间 " + (end - start)
				+ "毫秒");
	}
	
	/**
	 * read time out =h0002
	 * 404 =h9999 
	 * Connection refused= h9999
	 * @param url
	 * @param start
	 * @param e
	 */
	protected void dealHttpException(String url, long start, Exception e) {
		logger.info("dealHttpException:"+e.getMessage());
		logConnectTime(url, start);
		if(e instanceof ConnectTimeoutException){
			throw new RpcHttpException(RpcHttpBase.HTTP_ERROR_CODE1);
		}else if(e instanceof SocketTimeoutException){
			throw new RpcHttpException(RpcHttpBase.HTTP_ERROR_CODE2);
		}else{
			throw new RpcHttpException(RpcHttpBase.HTTP_ERROR_CODE9999);
		}
	}
}
