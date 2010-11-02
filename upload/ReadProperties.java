package upload;

import java.io.*;
import java.util.*;

public class  ReadProperties
{
	// private final String PROPERTY_FILE_FULL_PATH = "D:/sigma/tomcat/jakarta/webapps/lead/properties/leadprops.properties";
	
	/* If a constructor without a file name is used, this file will be used for 
	 * reading the properties 
	 */
	private final String PROPERTY_FILE_NAME = "leadprops.properties";

	ResourceBundle resourceBundle = null;
	String fixedString = "ReadProperties:";

	public ReadProperties()
	{
		fixedString = "ReadProperties:ReadProperties::";
		try
		{
			InputStream inputStream = this.getClass().getResourceAsStream(PROPERTY_FILE_NAME);
			if(inputStream == null)
			{
					System.out.println("NOT ABLE TO FIND THE PROPERTIES FILE");
			}
			else
			{
				System.out.println("FOUND THE PROPERTIES FILE");
			}
			this.resourceBundle= new PropertyResourceBundle (inputStream);
			// logger = new Log();
		}
		catch (Exception e)
		{
			// logger.log("ERR", 0, fixedString + "Excpetion occurred in getting the properties files" + e);
			e.printStackTrace();
			System.out.println(fixedString + "Excpetion occurred in getting the properties files" + e);
		}

	}
	
	/* This method would specify which file to read from 
	 * Added for dbsync.
	 */
	public ReadProperties(String fileName)
	{
		try
		{
			// InputStream inputStream = this.getClass().getResourceAsStream(fileName);
			InputStream inputStream = this.getClass().getResourceAsStream(fileName);
			if(inputStream == null)
			{
					System.out.println("NOT ABLE TO FIND THE PROPERTIES FILE");
			}
			else
			{
				
			}
			this.resourceBundle= new PropertyResourceBundle (inputStream);
			// logger = new Log();
		}
		catch (Exception e)
		{
			// logger.log("ERR", 0, fixedString + "Excpetion occurred in getting the properties files" + e);
			e.printStackTrace();
			System.out.println(fixedString + "Excpetion occurred in getting the properties files" + e);
		}

	}


	public String getValue(String propName)
	{
		fixedString= "ReadProperties:getValue::";
		String propValue = null;
		Enumeration enumerate  = resourceBundle.getKeys();

		while (enumerate.hasMoreElements())
		{
			String keyName = (String) enumerate.nextElement();
			//System.out.println("keyName--->"+keyName);
			if (keyName.equals(propName))
			{
				propValue = resourceBundle.getString(keyName);
              	// logger.log("PRO", 0, fixedString + "Key Name = " + keyName + "\t key value= " + propValue);
				break;
			}
			else
			{
				propValue = "NO MATCH FOUND";
			}
		}
		return propValue;
	}

	public static void main(String[] args) throws Exception
	{
		ReadProperties r = new ReadProperties();
		System.out.println("Value of the TOOL_NAME is:" + r.getValue("TOOL_NAME"));
		System.out.println("Value of the QUERY is:" + r.getValue("selectQuery"));
	}
}
