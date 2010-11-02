package date;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

//import net.sigmainfo.util.config.ConfigConstants;
//import net.sigmainfo.util.config.SISConfigManager;

public class DateHelper {

	public static void main(String[] args) {		
		
//		Calendar  c = Calendar.getInstance();
//		c.setTime(new Date());
//		int i = c.get(c.SECOND);		
//		c.add(c.SECOND, -i);
//		c.add(c.MINUTE,SISConfigManager.getInstance().getValue(
//				ConfigConstants.MAIL_CONTENT_LISTING_APPROVED))
//		//return c.getTime();
		
		Date date = new Date();
		int noOfDays = 10;
		
		Calendar c = new GregorianCalendar();
		c.setTime(date);
		c.add(c.DATE, noOfDays);
		System.out.println(date);
		System.out.println(c.getTime());
				
		
		
	}
}
