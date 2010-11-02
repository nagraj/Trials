package date;

import java.text.DateFormat;
import java.util.Date;

public class CheckFormats {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//http://download-llnw.oracle.com/javase/1.5.0/docs/api/java/text/DateFormat.html
		//String myString = DateFormat.getDateInstance(DateFormat.DATE_FIELD).format(new Date());
		String myString = DateFormat.getDateInstance(1).format(new Date());
		
		
		System.out.println(myString); 
	}

}
