package date;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;

public class DateTrial_1 {

	public static void main(String args[]){
		Date dat = new Date();
		String format = "EEEE, 'at' h:mm a, z";
		System.out.println(DateFormatUtils.format(dat, format));
		format = "MM d, yyyy";
		format = "yyyy-MM-dd HH:mm:ss";
		System.out.println(DateFormatUtils.format(dat, format));
		
//		GregorianCalendar tommorow = new GregorianCalendar();  
//		tommorow.add(GregorianCalendar.DATE, 1);
//		System.out.println(""+tommorow.getTime().toString()); //confirmed
		
//		Calendar yesterday = new GregorianCalendar(2007, Calendar.FEBRUARY, 27, 10, 10, 10);	    
//	    Calendar today = new GregorianCalendar(2007, Calendar.FEBRUARY, 28, 11, 11, 11);
//	    
//	    long diffMillis = today.getTimeInMillis()-yesterday.getTimeInMillis();
//	    long diffDays = diffMillis/(24*60*60*1000);  
//	    long deltaHours = diffMillis/(60*60*1000) - diffDays*24;
//	    long diffMins = diffMillis/(60*1000) - deltaHours *60 - diffDays*24*60;
//	    long diffSecs = diffMillis/(1000) - diffMins*60 - deltaHours*60*60 - diffDays*24*60*60 ;
//	    System.out.println(diffDays+" days, "+ deltaHours +" hours, "+diffMins+" minutes, "+diffSecs+" seconds");
	    
		
		System.out.println("Date : "+new Date());
	}
}
