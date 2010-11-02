package xml;

import java.io.*;
import javax.xml.parsers.*;
import org.xml.sax.*;
import org.w3c.dom.*;
import org.w3c.dom.traversal.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import org.apache.xpath.*;


/**
 * This class demonstrates how to use Java to parse an XML file and get
 * any element's content or attribute's value WITHOUT "walking the tree".
 * It uses XPath to achieve this goal.  Also shown is a trivial usage of
 * an XML transform to print the parsed XML file to console.
 *
 * Some of the program snippets are by http://xml.apache.org.
 *
 */
public class XPathXMLParser {

  public static void main(String[] args) {

   

    try {

      /****************************************************************
       * How to use turn an XML file into a document object in Java
       ****************************************************************/

     
      DocumentBuilderFactory docBuilderFactory =
                    DocumentBuilderFactory.newInstance();
      DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
      // Parse the XML file and build the Document object in RAM
      Document doc = docBuilder.parse(new File("src/test.xml"));

      // Normalize text representation.
      // Collapses adjacent text nodes into one node.
      doc.getDocumentElement().normalize();
      /****************************************************************/


      /****************************************************************
       * How to use xpath to extract info from document object in Java
       ****************************************************************/
      String xpath = "/names/name/auctioneerName";
      String xpath1 = "/names/name/waitTimeForFirstCall";
      String xpath2 = "/names/name/waitTimeForSecondCall";
      String xpath3 = "/names/name/waitTimeForFinalCall";
      String xpath4 = "/names/name/waitTimeForCloseCall";
      String xpath5 = "/names/name/waitTimeForAuctionCloseWhenNoBids";
      String xpath6 = "/names/name/waitTimeForCallingReserveNotMet";
      String xpath7 = "/names/name/waitTimeForCloseCallAfterReserveNotMet";
      System.out.println("\nQuerying DOM using xpath string:" + xpath);
      
      
     }
    catch (SAXParseException err) {
      String msg =
        "** SAXParseException"
          + ", line "
          + err.getLineNumber()
          + ", uri "
          + err.getSystemId()
          + "\n"
          + "   "
          + err.getMessage();
      System.out.println(msg);
      // print stack trace
      Exception x = err.getException();
      ((x == null) ? err : x).printStackTrace();
    }
    catch (SAXException e) {
      String msg = "SAXException";
      System.out.println(msg);
      Exception x = e.getException();
      ((x == null) ? e : x).printStackTrace();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    catch (Throwable t) {
      t.printStackTrace();
      String msg = "Some other exception while getting XML";
      System.out.println(msg);
    }
  }
}