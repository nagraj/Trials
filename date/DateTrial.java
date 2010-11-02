package date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateTrial {

	public static void main(String args[]){

		GregorianCalendar tommorow = new GregorianCalendar();
		tommorow.setTime(new Date());
		tommorow.add(GregorianCalendar.HOUR,1);
		System.out.println(""+tommorow.getTime().toString()); //confirmed
		
		Date aucStartTime = new Date();
			
		System.out.println("The status is.................." + tommorow.getTime());
		System.out.println("The status is.................." + new Date());
		Long status = timeDiff(tommorow.getTime());
		System.out.println("status : "+status);
		
		//--------------------------------
		
		try{
			String start = "MAY 25, 2001";
			SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy");
			Date d = sdf.parse(start);
			GregorianCalendar gc = new GregorianCalendar();
			gc.setTime(d);
			gc.roll(Calendar.DAY_OF_YEAR, 15);
			Date end = gc.getTime();
			System.out.println(end);
		}catch(Exception e){
			e.printStackTrace();
		}
	
	}
	
	public static Long timeDiff(Date aucStartTime){
		
		Long timeCalculate = Long.MIN_VALUE;
		
		GregorianCalendar aucStartCalendar = new GregorianCalendar();
		aucStartCalendar.setTime(aucStartTime);

		Calendar auctionTime = new GregorianCalendar(aucStartCalendar.get(Calendar.YEAR),
												   aucStartCalendar.get(Calendar.MONTH),
												   aucStartCalendar.get(Calendar.DAY_OF_MONTH),
												   aucStartCalendar.get(Calendar.HOUR_OF_DAY),
												   aucStartCalendar.get(Calendar.MINUTE),
												   aucStartCalendar.get(Calendar.SECOND));
		
		Calendar currentTimeCalendar = new GregorianCalendar();
	
		Calendar currentTime = new GregorianCalendar(currentTimeCalendar.get(Calendar.YEAR),
				   							   currentTimeCalendar.get(Calendar.MONTH),
				   							   currentTimeCalendar.get(Calendar.DAY_OF_MONTH),
				   							   currentTimeCalendar.get(Calendar.HOUR_OF_DAY),
				   							   currentTimeCalendar.get(Calendar.MINUTE),
				   							   currentTimeCalendar.get(Calendar.SECOND));

		long diffMillis = auctionTime.getTimeInMillis()-currentTime.getTimeInMillis();
		long diffDays = diffMillis/(24*60*60*1000);  
		long deltaHours = diffMillis/(60*60*1000) - diffDays*24;
		long diffMins = diffMillis/(60*1000) - deltaHours *60 - diffDays*24*60;
		long diffSecs = diffMillis/(1000) - diffMins*60 - deltaHours*60*60 - diffDays*24*60*60 ;

		if(diffDays >= 1){
			timeCalculate = diffDays*24*60*60;
		}else if(deltaHours >=1){
			timeCalculate = deltaHours*60*60;
		}else if(diffMins >=1){
			timeCalculate = diffMins*60;
		}else if(diffSecs >=1){
			timeCalculate = diffSecs;
		}else{
			timeCalculate = 0L;
		}
		
		return timeCalculate;
	}
	
}
