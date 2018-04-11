package com.hqblicai.http;

public class RpcHttpException extends RuntimeException {

	private static final long serialVersionUID = -3645964918392825087L;

	private String exceptionMsgJson;

	public RpcHttpException() {
		super();
	}

	public RpcHttpException(String message) {
		super(message);
	}

	public String getExceptionMsgJson() {
		return exceptionMsgJson;
	}

	public void setExceptionMsgJson(String exceptionMsgJson) {
		this.exceptionMsgJson = exceptionMsgJson;
	}

}
