package excp;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TestExcp {

	public static void main(String[] args){
		try{
			TestExcp test	=	new TestExcp();
			test.testMethod();
		}catch(Exception e){
			e.printStackTrace();			
		}
		
	}
	
	public void testMethod() throws MyException{
		int a;
		try{
			a=1/0;
		}catch(Exception e){
			
			ByteArrayOutputStream os = new ByteArrayOutputStream();			
			PrintStream ps = new PrintStream(os);
			e.printStackTrace(ps);
			String stackTrace = os.toString();
			String msg = "1/0 erroooooooooooor...\n";
			throw new MyException(msg+stackTrace);
			
			
//			String msg = "1/0 erroooooooooooor...\n";
//			throw new MyException(msg, e.getStackTrace());
		}
	}
}
