package com.hqblicai.http;

public class RequestWarper {

	private String url;
	private String userAgent="java";
	private String referUrl="hqb java httpurlconnection";
	private String method;
	private String content;
	private String title;

	private boolean isHttps;
	private boolean isReceive = true;

	/** 
	 * 设置连接超时
	 */
	private int connectTimeout=10000;
	
	/**
	 * 从主机读取数据的超时时间
	 */
	private int readTimeout=15000;

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url
	 *            the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMethod() {
		return this.method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the userAgent
	 */
	public String getUserAgent() {
		return userAgent;
	}

	/**
	 * @param userAgent
	 *            the userAgent to set
	 */
	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	/**
	 * @return the referUrl
	 */
	public String getReferUrl() {
		return referUrl;
	}

	/**
	 * @param referUrl
	 *            the referUrl to set
	 */
	public void setReferUrl(String referUrl) {
		this.referUrl = referUrl;
	}

	/**
	 * @return the isHttps
	 */
	public boolean isHttps() {
		return isHttps;
	} 

	/**
	 * @param isHttps
	 *            the isHttps to set
	 */
	public void setHttps(boolean isHttps) {
		this.isHttps = isHttps;
	}

	/**
	 * @return the isReceive
	 */
	public boolean isReceive() {
		return isReceive;
	}

	/**
	 * @param isReceive
	 *            the isReceive to set
	 */
	public void setReceive(boolean isReceive) {
		this.isReceive = isReceive;
	}

	/**
	 * @return the connectTimeout
	 */
	public int getConnectTimeout() {
		return connectTimeout;
	}

	/**
	 * @param connectTimeout
	 *            the connectTimeout to set
	 */
	public void setConnectTimeout(int connectTimeout) {
		this.connectTimeout = connectTimeout;
	}

	/**
	 * @return the readTimeout
	 */
	public int getReadTimeout() {
		return readTimeout;
	}

	/**
	 * @param readTimeout
	 *            the readTimeout to set
	 */
	public void setReadTimeout(int readTimeout) {
		this.readTimeout = readTimeout;
	}

	public RequestWarper(int readTimeout,int connectTimeout){
		this.readTimeout=readTimeout;
		this.connectTimeout=connectTimeout;
	}
	public RequestWarper(){
		
	}
}
