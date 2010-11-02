package upload;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.*;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Locale;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.plugins.jpeg.JPEGImageWriteParam;
import javax.imageio.stream.ImageOutputStream;

import com.sun.image.codec.jpeg.ImageFormatException;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;


public class ImageResizer {
	
	/**
	 * 
	 */
	public ImageResizer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void imageResizer(String sourceFile,String targetFile,int width,int height,int imgRatio) throws InterruptedException, ImageFormatException, IOException{
		
	Image image = Toolkit.getDefaultToolkit().getImage(sourceFile);
    MediaTracker mediaTracker = new MediaTracker(new Container());
    mediaTracker.addImage(image, 0);
    mediaTracker.waitForID(0);
    // determine thumbnail size from WIDTH and HEIGHT
    int thumbWidth = width;
    int thumbHeight = height;
    double thumbRatio = (double)thumbWidth / (double)thumbHeight;
    int imageWidth = image.getWidth(null);
    int imageHeight = image.getHeight(null);
    double imageRatio = (double)imageWidth / (double)imageHeight;
   /* if (thumbRatio < imageRatio) {
      thumbHeight = (int)(thumbWidth / imageRatio);
    } else {
      thumbWidth = (int)(thumbHeight * imageRatio);
    }*/
    // draw original image to thumbnail image object and
    // scale it to the new size on-the-fly
    BufferedImage thumbImage = new BufferedImage(thumbWidth, 
      thumbHeight, BufferedImage.TYPE_INT_RGB);
    Graphics2D graphics2D = thumbImage.createGraphics();
    graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
      RenderingHints.VALUE_INTERPOLATION_BILINEAR);
    graphics2D.drawImage(image, 0, 0, thumbWidth, thumbHeight, null);
    // save thumbnail image to OUTFILE
    BufferedOutputStream out = new BufferedOutputStream(new
      FileOutputStream(targetFile));
    JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
    JPEGEncodeParam param = encoder.
      getDefaultJPEGEncodeParam(thumbImage);
    int quality = imgRatio;
    quality = Math.max(0, Math.min(quality, 100));
    param.setQuality((float)quality / 100.0f, false);
    encoder.setJPEGEncodeParam(param);
    encoder.encode(thumbImage);
    out.close(); 
    System.out.println("Done.");
    System.exit(0);	
	}
	
	public static String saveJPEG(String sourceFile,String targetFile,int width,int height,int imgRatio){
		boolean saved = false;
		String success = "";
		try {
		Image photo=javax.imageio.ImageIO.read(new File(sourceFile)); 
		BufferedImage bi = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		Graphics2D g2 = bi.createGraphics();	
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
			      RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.drawImage(photo, 0,0,width,height,null);
		FileOutputStream out = null;	
		out = new FileOutputStream(targetFile);
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
		JPEGEncodeParam param = encoder.getDefaultJPEGEncodeParam(bi);
		int quality = imgRatio;
		quality = Math.max(0, Math.min(quality, 100));
		param.setQuality((float)quality / 100.0f, false); 
		encoder.setJPEGEncodeParam(param);
		encoder.encode(bi);
		out.close();
    //	success = this.imageZipped(targetFile);
			
		System.out.println("Done.");
//		System.exit(0);	
		saved = true;
		} catch (Exception ex) {
		System.out.println("Error salvando JPEG : " + ex.getMessage());
		}
		return success;
		}
	
	
	 // Reads the jpeg image in infile, compresses the image,
    // and writes it back out to outfile.
    // compressionQuality ranges between 0 and 1,
    // 0-lowest, 1-highest.
    public void compressJpegFile(File infile, File outfile, float compressionQuality) {
        try {
            // Retrieve jpg image to be compressed
            RenderedImage rendImage = ImageIO.read(infile);
    
            // Find a jpeg writer
            ImageWriter writer = null;
            Iterator iter = ImageIO.getImageWritersByFormatName("jpg");
            if (iter.hasNext()) {
                writer = (ImageWriter)iter.next();
            }
    
            // Prepare output file
            ImageOutputStream ios = ImageIO.createImageOutputStream(outfile);
            writer.setOutput(ios);
    
            // Set the compression quality
            ImageWriteParam iwparam = new MyImageWriteParam();
            iwparam.setCompressionMode(ImageWriteParam.MODE_EXPLICIT) ;
            iwparam.setCompressionQuality(compressionQuality);
    
            // Write the image
            writer.write(null, new IIOImage(rendImage, null, null), iwparam);
    
            // Cleanup
            ios.flush();
            writer.dispose();
            ios.close();
        } catch (IOException e) {
        }
    }
    
    // This class overrides the setCompressionQuality() method to workaround
    // a problem in compressing JPEG images using the javax.imageio package.
    public class MyImageWriteParam extends JPEGImageWriteParam {
        public MyImageWriteParam() {
            super(Locale.getDefault());
        }
    
        // This method accepts quality levels between 0 (lowest) and 1 (highest) and simply converts
        // it to a range between 0 and 256; this is not a correct conversion algorithm.
        // However, a proper alternative is a lot more complicated.
        // This should do until the bug is fixed.
        public void setCompressionQuality(float quality) {
            if (quality < 0.0F || quality > 1.0F) {
                throw new IllegalArgumentException("Quality out-of-bounds!");
            }
            this.compressionQuality = 256 - (quality * 256);
        }
    }
    
    public String imageZipped(String fileName){
//    	 These are the files to include in the ZIP file
//        String[] filenames = new String[]{"filename1", "filename2"};
    	boolean saved = false;
    	System.out.println("Making the Zip file.......");
//    	String filename = fileName;
    	
    	String zipfile=fileName.replaceAll("jpeg","zip");
    	
    	System.out.println("The zipped Location is......" + zipfile);
    	
    	String[] filePath = fileName.split("/");
    	
    	System.out.println("The Exact File Name is......" + filePath[filePath.length-1]);
    	
        // Create a buffer for reading the files
        byte[] buf = new byte[1024];
        
        try {
            // Create the ZIP file
//          String outFilename = "outfile.zip";
        	String outFilename = zipfile;
            ZipOutputStream out = new ZipOutputStream(new FileOutputStream(outFilename));
        
            // Compress the files
//            for (int i=0; i<filenames.length; i++) {
                FileInputStream in = new FileInputStream(fileName);
        
                // Add ZIP entry to output stream.
                out.putNextEntry(new ZipEntry(filePath[filePath.length-1]));
        
                // Transfer bytes from the file to the ZIP file
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
        
                // Complete the entry
                out.closeEntry();
                in.close();
//            }
        
            // Complete the ZIP file
            out.close();
            saved = true;
        } catch (IOException e) {
        }
        
        return zipfile;
    }
    
    
    public static final void copyInputStream(InputStream in, OutputStream out)
    throws IOException
    {
      byte[] buffer = new byte[1024];
      int len;

      while((len = in.read(buffer)) >= 0)
        out.write(buffer, 0, len);

      in.close();
      out.close();
    }

    public boolean imageUnzipped(String zipfile) {
      Enumeration entries;
      ZipFile zipFile;
      boolean success = false;
      System.out.println("Coming inside");

      try {
        zipFile = new ZipFile(zipfile);

        entries = zipFile.entries();

        while(entries.hasMoreElements()) {
          ZipEntry entry = (ZipEntry)entries.nextElement();
          
          String target ="D:/img/unzipped/" + entry.getName();
          
          File file = new File(target);

          if(entry.isDirectory()) {
            // Assume directories are stored parents first then children.
            System.err.println("Extracting directory: " + entry.getName());
            // This is not robust, just for demonstration purposes.
           (new File(entry.getName())).mkdir();
            continue;
          }
          
          
          System.err.println("Extracting file: " + entry.getName());
          copyInputStream(zipFile.getInputStream(entry),
             new BufferedOutputStream(new FileOutputStream(target)));
        }
        success=true;
        zipFile.close();
      } catch (IOException ioe) {
        System.err.println("Unhandled exception:");
        ioe.printStackTrace();
      }
      return success;
      
    }
    
    public static void main(String args[]){
    	ImageResizer imgResize = new ImageResizer();
    	
    	String img = imgResize.saveJPEG("D:/image/temp/image1.jpeg", "D:/image/perm/kar.jpeg", 75, 75, 100);
    	System.out.println("The img status " + img);
     	
    }
    

	
}
