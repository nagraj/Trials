package excp;

public class MyException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public MyException(String myMsg){
		super(myMsg);
	}
	public MyException(Throwable t){
		super(t);
	}
	public MyException(String msg, Throwable t){
		super(msg,t);
	}
	public MyException(String msg, StackTraceElement[] stackTrace){
		super(msg);	
		setStackTrace(stackTrace);
		
	}
}
