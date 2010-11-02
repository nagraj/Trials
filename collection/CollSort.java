package collection;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Collections;





public class CollSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList l1 = new ArrayList();
		
		Calendar c = new GregorianCalendar();
		c.setTime(new Date());
		c.add(Calendar.DAY_OF_MONTH, 1);
		l1.add(c.getTime());
		System.out.println(""+c.getTime());
		l1.add(new Date());
		System.out.println(""+new Date());
	
		ArrayList<T> l3 = Collections.sort(l1, new Comparator<Date>(){
			public int compare(Date d1, Date d2) {
				return d2.compareTo(d1);		
			});	
	}
	
	

}
