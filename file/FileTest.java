package file;

import java.io.File;
import java.io.IOException;

public class FileTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
	        File file = new File("../../../../a.txt");
	    
	        // Create file if it does not exist
	        boolean success = file.createNewFile();
	        if (success) {
	            System.out.println(" File did not exist and was created");
	        } else {
	            System.out.println("File already exists");
	        }
	    } catch (IOException e) {
	    }
	}

}
