package date;


import java.util.*;
import java.text.*;
import java.io.*;

public class TZConverter{
  public static void main(String args[]){
	  TZConverter tzc = new TZConverter();
	  System.out.println(tzc.convertTZ("US/Pacific","US/Eastern",12));
	  System.out.println(tzc.convertTZ("US/Central","US/Eastern",23));
	  System.out.println(tzc.convertTZ("US/Eastern","US/Eastern",2));
  }
  
  public int convertTZ(String fromTZ, String toTZ, int userHr){
	  
	  Calendar fromCal = new GregorianCalendar(TimeZone.getTimeZone(fromTZ));
	  Calendar toCal = new GregorianCalendar(TimeZone.getTimeZone(toTZ));
	  fromCal.set(Calendar.HOUR,userHr);
	  fromCal.set(Calendar.AM_PM,Calendar.AM);
	  toCal.setTimeInMillis(fromCal.getTimeInMillis());	  
	  return toCal.get(Calendar.HOUR_OF_DAY);
  }
}
	