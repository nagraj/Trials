package xml;

import java.math.BigInteger;
import java.io.*;


public class FibonacciFile {

  public static void main(String[] args) {
   
      BigInteger low  = BigInteger.ONE;
      BigInteger high = BigInteger.ONE;      
      String xmlFile = "D:/eclipse3.2/workspace/TestProject/src/xml/";
      
      try {        
        OutputStream fout= new FileOutputStream(xmlFile+"fibonacci.xml");
        OutputStream bout= new BufferedOutputStream(fout);
        OutputStreamWriter out 
         = new OutputStreamWriter(bout, "8859_1");
      
        out.write("<?xml version=\"1.0\" ");
        out.write("encoding=\"ISO-8859-1\"?>\r\n");  
        out.write("<Fibonacci_Numbers>\r\n");  
        for (int i = 1; i <= 10; i++) {
          out.write("  <fibonacci index=\"" + i + "\">");
          out.write(low.toString());
          out.write("</fibonacci>\r\n");
          BigInteger temp = high;
          high = high.add(low);
          low = temp;
        }
        out.write("</Fibonacci_Numbers>\r\n"); 
        
        out.flush();  // Don't forget to flush!
        out.close();
      }
      catch (UnsupportedEncodingException e) {
        System.out.println(
         "This VM does not support the Latin-1 character set."
        );
      }
      catch (IOException e) {
        System.out.println(e.getMessage());        
      }

  }

}

