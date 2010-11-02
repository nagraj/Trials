package betwixt;

import java.beans.IntrospectionException;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.betwixt.XMLUtils;
import org.apache.commons.betwixt.io.BeanWriter;
import org.xml.sax.SAXException;

public class XMLBuilder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Start by preparing the writer
        // We'll write to a string 
        StringWriter outputWriter = new StringWriter(); 
        
        // Betwixt just writes out the bean as a fragment
        // So if we want well-formed xml, we need to add the prolog
        outputWriter.write("\n\n<?xml version='1.0' ?>\n\n");
        
        // Create a BeanWriter which writes to our prepared stream
        BeanWriter beanWriter = new BeanWriter(outputWriter);
        
        // Configure betwixt
        // For more details see java docs or later in the main documentation
        beanWriter.getXMLIntrospector().getConfiguration().setAttributesForPrimitives(false);
        beanWriter.getBindingConfiguration().setMapIDs(false);
        beanWriter.enablePrettyPrint();

//------------ Building up a dumb bean for sampling the transformation        
        
        //creating list of 2 attachments
        ArrayList<Attachment> attachments1 = new ArrayList<Attachment>();
        attachments1.add(new Attachment("/file1","first file attached"));
        attachments1.add(new Attachment("/file2","second file attached"));
        
        ArrayList<Attachment> attachments2 = new ArrayList<Attachment>();
        attachments2.add(new Attachment("/file3","third file attached"));
        attachments2.add(new Attachment("/file4","fourth file attached"));
        
        //creating messages and adding them to the list of messages
        ArrayList<Message> messages = new ArrayList<Message>();
        messages.add(new Message("nagraj","karthick",attachments1));
        messages.add(new Message("pranav","mohan",attachments2));
        
        SR sr = new SR("9320003", "Test SR", messages);
        
        
// -------------XML transformation done here-------
        // Base root specified as 'SR', can be changed according to the needs
        try {
			beanWriter.write("sr", sr);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IntrospectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        // Write to System.out
        // (We could have used the empty constructor for BeanWriter 
        // but this way is more instructive)
        System.out.println(outputWriter.toString());
        
        // Betwixt writes fragments not documents so does not automatically close 
        // writers or streams.
        // This example will do no more writing so close the writer now.
        try {
			outputWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
