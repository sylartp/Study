package com.huidao.service;

public class IdOrPwdException extends Exception{
	
	
	public IdOrPwdException (){
		
	}
	public IdOrPwdException(String msg){
		super(msg);
	}
	
	public IdOrPwdException(Throwable cause){
		super(cause);
	}
	public IdOrPwdException(String msg,Throwable cause){
		super(msg,cause);
	}
}
