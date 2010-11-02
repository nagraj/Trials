package date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

public class TimeZoneTrial {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(new Date());
		DateFormat dateFormat = new SimpleDateFormat("E,dd MMM yyyy, h:mm:ss a ");
		dateFormat.setTimeZone(TimeZone.getTimeZone("Europe/Zurich"));
		String dispTime = dateFormat.format(gc.getTime());		
		dispTime+=gc.getTimeZone().getDisplayName(true,TimeZone.SHORT);
//		System.out.println(dispTime);
		
		System.out.println(gc.getTimeZone().getDisplayName(Locale.US));
		System.out.println("=====================================================");
		
		Calendar PSTCal = Calendar.getInstance(TimeZone.getTimeZone("US/California"));
//		Calendar GMTCal = Calendar.getInstance(TimeZone.getTimeZone("Europe/London"));

	      System.out.println("PST calendar info: " + PSTCal);
	      System.out.println("PST date-time is: " + PSTCal.getTime());
	      System.out.println("PST date-time-2 is: " + PSTCal.getTime());
//	      System.out.println("GMT date-time-2 is: " + GMTCal.getTime());
	      
	     
	      Calendar tmpCal = Calendar.getInstance();
	      tmpCal.set( PSTCal.get(Calendar.YEAR),
	                  PSTCal.get(Calendar.MONTH),
	                  PSTCal.get(Calendar.DATE),
	                  PSTCal.get(Calendar.HOUR),
	                  PSTCal.get(Calendar.MINUTE),
	                  PSTCal.get(Calendar.SECOND));
	      System.out.println("");
	      System.out.println("PST calculated date-time is: " + tmpCal.getTime());
	      System.out.println("");
	      System.out.println("Temp calendar info: " + tmpCal);
	      
	      System.out.println("======================================================");
	      
	      GregorianCalendar calendar = new GregorianCalendar();
	         System.out.println("Calendar.toString() = " + calendar);
	       
	        calendar.setTimeZone(TimeZone.getTimeZone("GMT+5:30"));
//	        calendar.set(Calendar.HOUR_OF_DAY, 10);
	        System.out.println("Calendar hour (-12) = " + calendar.get(Calendar.HOUR_OF_DAY));
	        System.out.println("Calendar hour millis = " + calendar.getTime());
	        
	        calendar.setTimeZone(TimeZone.getTimeZone("GMT-0:30"));
	        System.out.println("Calendar hour (-11) = " + calendar.get(Calendar.HOUR_OF_DAY));
	        System.out.println("Calendar hour millis = " + calendar.getTime());
	        
	        Date now = calendar.getTime();
	        
	        SimpleDateFormat local = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss z");
	        System.out.println("Local time (Here) = " + local.format(now));
	        
	        local.setTimeZone(TimeZone.getTimeZone("GMT"));        
	        System.out.println("Local time (GMT)  = " + local.format(now));
	        
	        local.setTimeZone(TimeZone.getTimeZone("EST"));
	        System.out.println("Local time (EST)  = " + local.format(now));
	        
	        local.setTimeZone(TimeZone.getTimeZone("PST"));
	        System.out.println("Local time (PST)  = " + local.format(now));
	        


	}

}
