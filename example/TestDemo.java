package example;

import java.util.Locale;

import org.hibernate.Hibernate;


public class TestDemo extends Thread {

	/**
	 * @param args  Runnable
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer a = new Integer("10");
		Integer b = new Integer("10");
		Integer c = a+b;
		
		System.out.println(c);
		
//		if(a.equalsIgnoreCase(b)){
		if(a==b){
			System.out.println("Equal");
		}else{
			System.out.println(" Not Equal");
		}
		System.out.println(Hibernate.LOCALE.getName());

	}
	
/*	public static void main(String [] argh) {
		 String [] args;
		 int x;
		 x = argh.length;
		 for (int y = 0; y < x; y++) {
		 System.out.print(" " + argh[y]);
		 }
		 }*/
		

}
