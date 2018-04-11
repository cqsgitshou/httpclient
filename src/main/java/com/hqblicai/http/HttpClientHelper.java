package com.hqblicai.http;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

public class HttpClientHelper extends RpcHttpBase{

	public String postsend(RequestWarper requestWarper) {
		long start = System.currentTimeMillis();
		StringBuffer sb = new StringBuffer();
		if (requestWarper.isHttps()) {
			initSSL();
		}

		String result = "";

		try {
			URL conurl = new URL(requestWarper.getUrl());
			HttpURLConnection connection = (HttpURLConnection) conurl
					.openConnection();
			
			// 设置请求超时时间
			connection.setConnectTimeout(requestWarper.getConnectTimeout());
			connection.setReadTimeout(requestWarper.getReadTimeout());
			
			connection.setRequestMethod("POST");
			connection.setUseCaches(false);
			connection.setDoOutput(true);
			connection.setRequestProperty("X-Requested-With", "XMLHttpRequest");
			connection.setRequestProperty("User-Agent",
					requestWarper.getUserAgent());
			connection.setRequestProperty("Referer",
					requestWarper.getReferUrl());
			connection.setRequestProperty("Content-type",
					"application/x-www-form-urlencoded");

			connection.connect(); 

			OutputStreamWriter osw = new OutputStreamWriter(
					connection.getOutputStream(), "UTF-8");
			System.out.println(requestWarper.getContent());
			osw.write(requestWarper.getContent());
			osw.flush();
			osw.close();
			InputStream inputStream = connection.getInputStream();
			if (requestWarper.isReceive()) {
				Reader reader = new InputStreamReader(inputStream, "UTF-8");
				BufferedReader bufferedReader = new BufferedReader(reader);
				String str = null;

				while ((str = bufferedReader.readLine()) != null) {
					sb.append(str);
				}

				reader.close();
				result = sb.toString();
			}

			connection.disconnect();
		} catch (Exception e) {
			dealHttpException(requestWarper.getUrl(), start, e);
			return e.getMessage();
		}
		return result;
	}
	
	public String postsendWithWarp(RequestWarper requestWarper) {
		long start = System.currentTimeMillis();
		StringBuffer sb = new StringBuffer();
		if (requestWarper.isHttps()) {
			initSSL();
		}

		String result = "";

		try {
			URL conurl = new URL(requestWarper.getUrl());
			HttpURLConnection connection = (HttpURLConnection) conurl
					.openConnection();
			
			// 设置请求超时时间 
			connection.setConnectTimeout(requestWarper.getConnectTimeout());
			connection.setReadTimeout(requestWarper.getReadTimeout());
			
			connection.setRequestMethod("POST");
			connection.setUseCaches(false);
			connection.setDoOutput(true);
			connection.setRequestProperty("X-Requested-With", "XMLHttpRequest");
			connection.setRequestProperty("User-Agent",
					requestWarper.getUserAgent());
			connection.setRequestProperty("Referer",
					requestWarper.getReferUrl());
			connection.setRequestProperty("Content-type",
					"application/x-www-form-urlencoded");

			connection.connect(); 

			OutputStreamWriter osw = new OutputStreamWriter(
					connection.getOutputStream(), "UTF-8");
			System.out.println(requestWarper.getContent());
			osw.write(requestWarper.getContent());
			osw.flush();
			osw.close();
			InputStream inputStream = connection.getInputStream();
			if (requestWarper.isReceive()) {
				Reader reader = new InputStreamReader(inputStream, "UTF-8");
				BufferedReader bufferedReader = new BufferedReader(reader);
				String str = null;

				while ((str = bufferedReader.readLine()) != null) {
					sb.append(str);
					sb.append("\n");
				}

				reader.close();
				result = sb.toString();
			}

			connection.disconnect();
		} catch (Exception e) {
			dealHttpException(requestWarper.getUrl(), start, e);
			return e.getMessage();
		}
		return result;
	}

	public String getFormHttp(RequestWarper requestWarper) {
		String result = "";
		StringBuffer sb = new StringBuffer();

		if (requestWarper.isHttps()) {
			initSSL();
		}

		System.out.println(requestWarper.getUrl() + "?"
					+ requestWarper.getContent());
		try {
			URL getUrl = new URL(requestWarper.getUrl() + "?"
					+ requestWarper.getContent());

			HttpURLConnection connection = (HttpURLConnection) getUrl
					.openConnection();

			connection.setRequestProperty("User-Agent",
					requestWarper.getUserAgent());
			connection.setRequestProperty("Referer",
					requestWarper.getReferUrl());
			// 设置请求超时时间
			connection.setConnectTimeout(requestWarper.getConnectTimeout());
			connection.setReadTimeout(requestWarper.getReadTimeout());

			connection.connect();
			
			InputStream inputStream = connection.getInputStream();

			if (requestWarper.isReceive()) {
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(inputStream, "UTF-8"));
				String lines;
				while ((lines = reader.readLine()) != null) {

					sb.append(lines);
				}
				reader.close();

				result = sb.toString();
			}

			connection.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
			result="error";
		}
		return result;
	}

	private void initSSL() {
		try {
			TrustManager[] tmCerts = new TrustManager[1];
			tmCerts[0] = new SimpleTrustManager();
			SSLContext sc = SSLContext.getInstance("SSL");
			sc.init(null, tmCerts, null);
			HttpsURLConnection
					.setDefaultSSLSocketFactory(sc.getSocketFactory());
			HostnameVerifier hv = new SimpleHostnameVerifier();
			HttpsURLConnection.setDefaultHostnameVerifier(hv);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}