package system;

import java.util.Properties;

public class SysPropsTest {	 
	public static void main(String args[]){
	   Properties props;
	   props = System.getProperties();
	   props.list(System.out);
	  }
	 }
