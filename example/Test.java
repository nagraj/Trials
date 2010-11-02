package example;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.io.File;
import java.lang.*;

import org.apache.commons.lang.time.DateUtils;

class dummy{
	
	public void print()
	{
		System.out.println("Coming inside the class");
	}
	
}

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String filePath = "D:/img/test.java";
				
		String[] file = filePath.split("/");
		final String FILE_PATH = "D:/sigma/Tomcat 5/webapps/upload/temp";
		
//		for(int i=0;i<file.length;i++){
		System.out.println("The file name is..." + file[file.length-1]);
//		}
	
		/*try{
		for(int i=1;i<=6;i++){
			
			if(i<=5){
			dummy A = new dummy();
			System.out.println("Instance created" + i);
			}else{
				dummy A = new dummy();
				throw new ExceedInstanceException("Exceed Exception");
			}
		}
		}catch(ExceedInstanceException e){
			e.printStackTrace();
			
		}
		*/
		
		Date d = new Date();
		
		/*DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy,HH:mm:ss");
				
		System.out.println("The date is..." + dateFormat.format(new Date()));*/
		
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss");
		
		String datePath = dateFormat.format(new Date()); 
		
		System.out.println("The date is..." + datePath );
		
		String savePath = FILE_PATH + "/1/"+datePath ;
		
		System.out.println("The status 0 is,,," + savePath);
		
		/*boolean status = new File(savePath).mkdir();
		
		System.out.println("The status 0 is,,," + status);*/
		
		boolean status1 = new File(savePath).mkdirs();
		System.out.println("The status 1 is,,," + status1);
		
		

	}

}
