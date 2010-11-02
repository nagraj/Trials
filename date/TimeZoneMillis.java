package date;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class TimeZoneMillis{
  public static void main(String[] args){
	  Calendar rightNow = Calendar.getInstance() ;
	  TimeZone timezone1 = TimeZone.getTimeZone("America/Los_Angeles");	  
	  Calendar rightNowlondon = Calendar.getInstance(timezone1) ;
	  System.out.println(rightNowlondon.getTimeInMillis());
	  rightNow.set(rightNowlondon.get(Calendar.YEAR), rightNowlondon.get(Calendar.MONTH),
			  rightNowlondon.get(Calendar.DATE), rightNowlondon.get(Calendar.HOUR_OF_DAY), 
			  rightNowlondon.get(Calendar.MINUTE), rightNowlondon.get(Calendar.SECOND));
	  System.out.println(rightNow.getTime());
	  
	  Date d = new Date(1231888530);
	  System.out.println(d);
  }
  
} 