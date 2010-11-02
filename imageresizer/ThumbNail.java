package imageresizer;

import java.io.File;
import java.io.FileInputStream;

/**
 * Thumbnail.java (requires Java 1.2+)
 * Load an image, scale it down and save it as a JPEG file.
 * @author Marco Schmidt
 */
public class ThumbNail {
  public static void main(String[] args) throws Exception {
	  
	  String sourceFile = "D:/nag.jpeg";
	  String targetFile = "D:/good.jpeg";
	  
//	  String compressFile = "D:/img/compress.jpg";
	  int width = 400;
	  int height = 400;
	  int imgRatio = 50;
//	  float compressionQuality = 1.0f;
	  
	  
	  
//	  String zipfile = "D:/img/ImageResizer.zip";
	  
	  
	/*  File infile = new File(sourceFile);
		  
	  File outfile = new File(compressFile);
	  
	  boolean create = outfile.createNewFile();
	  
	  
	  ImageResizer imageResizer = new ImageResizer();
	  
	  imageResizer.compressJpegFile(infile, outfile, compressionQuality);
	*/  
//	  ImageSizer.saveJPEG(sourceFile, targetFile, width, height, compressionQuality);
	  
	  
//	  ImageResizer.imageResizer(sourceFile,targetFile,width,height,imgRatio);   
	  
	  ImageResizer imageResizer = new ImageResizer();
	  String zipfile = imageResizer.saveJPEG(sourceFile,targetFile,width,height,imgRatio);
//	  ImageResizer.imageZipped(targetFile);	
	  
	  boolean unzip = imageResizer.imageUnzipped(zipfile);
	  
	  System.out.println("The unzip status........" + unzip);
	  	   
	   
  }
}
