package imageresizer;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

import com.sun.image.codec.jpeg.*;
public class ImageSizer {
	String fixedString = "ImageSizer :::"; 
	public static final MediaTracker tracker = new MediaTracker( new Component() {} );
	
	public static Image setSize( Image image, int width, int height ) {
		System.out.println("setSize(img,width,height)");
        return setSize( image, width, height, java.awt.Image.SCALE_DEFAULT );
    }

   public static Image setSize( Image image, int width, int height, int hints ) {
  		System.out.println("setSize(img,width,height,hints)"+height);
	    return image.getScaledInstance( width, height, hints );
   } // setSize

   public static void checkImage( Image image ) {
      System.out.println(" checkImage(img) called.)");
      waitForImage( image );
    /*  int imageWidth = image.getWidth( null );
      if ( imageWidth < 1 ) 
         throw new IllegalArgumentException( "image width " + imageWidth + " is out of range" );
      int imageHeight = image.getHeight( null );
      if ( imageHeight < 1 ) 
         throw new IllegalArgumentException( "image height " + imageHeight + " is out of range" );
		 */
   } // checkImage

   public static void waitForImage( Image image ) {
      System.out.println(" waitForImage(img) called.)");
      try {
         tracker.addImage(image,0);
         tracker.waitForID(0);
         tracker.removeImage(image, 0);
      } catch( InterruptedException e ) { e.printStackTrace(); }
   } // waitForImage

   public static void encodeJPEG(int outputWidth, int outputHeight, OutputStream outputStream, Image outputImage, float outputQuality ) 
      throws java.io.IOException {
      System.out.println(" encodeJPEG() called.)");
     /* int outputWidth  = outputImage.getWidth( null );
      if(outputWidth < 1 ) throw new IllegalArgumentException( "output image width " + outputWidth + " is out of range" );
      int outputHeight = outputImage.getHeight( null );
      if(outputHeight < 1 ) throw new IllegalArgumentException( "output image height " + outputHeight + " is out of range" );
	 */
	  System.out.println("Image Width---->" + outputWidth  );	
	  System.out.println("Image Width---->" + outputHeight );	
      BufferedImage bi = new BufferedImage( outputWidth, outputHeight, BufferedImage.TYPE_INT_RGB );                                                   
      Graphics2D biContext = bi.createGraphics();
      biContext.drawImage(outputImage, 0, 0, null);

      JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder( outputStream );
      JPEGEncodeParam jep = JPEGCodec.getDefaultJPEGEncodeParam( bi );
      jep.setQuality( outputQuality, true );
      encoder.encode( bi, jep );
      outputStream.flush();      
   } // encodeImage

   public static void saveJPEG(String sourceFile,String targetFile,int width,int height,float compressionQuality)throws java.io.IOException {
     /* if (args.length < 5) {
         System.out.println("ImageSizer - changes the size of an image." );
         System.out.println("use: java ImageSizer inputFile outputFile outputWidth outputHeight outputQuality" );
         return;
      }*/
      String inputFileName = sourceFile;
      String outputFileName = targetFile;
      int outputWidth = width;
      if ( outputWidth < 1 ) 
         throw new IllegalArgumentException("output width \"" + outputWidth +"\" out of range" );
	  int outputHeight = height;
	  float outputQuality = compressionQuality;
      if (( outputQuality < 0.0F ) || ( outputQuality > 1.0F ))
         throw new IllegalArgumentException( "output quality \"" + outputQuality +"\" out of range" );

      // Get input image
      Image inputImage = Toolkit.getDefaultToolkit().getImage(inputFileName);
	  
      checkImage( inputImage );
      // Create output image.
      Image outputImage = ImageSizer.setSize( inputImage, outputWidth, outputHeight );
      checkImage( outputImage );
	  System.out.println("Output Image String --->"+outputImage.toString());

      // Encode JPEG file.
      FileOutputStream fos = new FileOutputStream( outputFileName );
      encodeJPEG( outputWidth, outputHeight, fos, outputImage, outputQuality );
      fos.close();
      System.exit( 0 );
   } // main
} // class ImageSizer