package br.com.testespringboot.exception;

public class ExceptionGeneric extends RuntimeException{
	private String msg;
	
	public ExceptionGeneric(String msg){
		super(msg);
		this.msg = msg;
	}
	public String getMessage(){
		return msg;
	}
}
