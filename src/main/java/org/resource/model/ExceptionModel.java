package org.resource.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExceptionModel {
	
	//属性
	private Exception exception;
	private String message;
	private Date throwedTime;
	
	//构造方法
	public ExceptionModel() {
		super();
	}
	public ExceptionModel(Exception exception, String message, Date throwedTime) {
		super();
		this.exception = exception;
		this.message = message;
		this.throwedTime = throwedTime;
	}
	
	//get和set方法
	public Exception getException() {
		return exception;
	}
	public void setException(Exception exception) {
		this.exception = exception;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getThrowedTime() {
		return throwedTime;
	}
	public void setThrowedTime(Date throwedTime) {
		this.throwedTime = throwedTime;
	}
	@Override
	public String toString() {
		return String.format("异常：%s,原因：%s,抛出时间：%s",exception.getClass().getName(),
				message,throwedTime.toString());
	}
}
