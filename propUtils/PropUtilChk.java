package propUtils;

import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ListResourceBundle;
import java.util.Properties;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class PropUtilChk {

	public static void main(String[] args){
		/*File file	=	new File("test.properties");
		FileReader fr	=	new FileReader(file);
		PropertyResourceBundle prb	=	new PropertyResourceBundle(new InputStreamReader(file);
		*/
		try{
			ResourceBundle	resourceBundle	=	null;
			InputStream inputStream = PropUtilChk.class.getResourceAsStream("test.properties");			
			
			/*resourceBundle= new PropertyResourceBundle (inputStream);
			System.out.println(resourceBundle.getString("word"));
			*/
			Properties prop	=	new Properties();
			prop.load(inputStream);
			System.out.println(prop.getProperty("word"));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
