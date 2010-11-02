package betwixt;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.betwixt.io.BeanWriter;

public class BetwixtTest {

    /** 
     * Create an example bean and then convert it to xml.
     */
    public static final void main(String [] args) throws Exception {
        
        // Start by preparing the writer
        // We'll write to a string 
        StringWriter outputWriter = new StringWriter(); 
        
        // Betwixt just writes out the bean as a fragment
        // So if we want well-formed xml, we need to add the prolog
        outputWriter.write("<?xml version='1.0' ?>\n");
        
        // Create a BeanWriter which writes to our prepared stream
        BeanWriter beanWriter = new BeanWriter(outputWriter);
        
        // Configure betwixt
        // For more details see java docs or later in the main documentation
        beanWriter.getXMLIntrospector().getConfiguration().setAttributesForPrimitives(false);
        beanWriter.getBindingConfiguration().setMapIDs(false);
        beanWriter.enablePrettyPrint();

        // If the base element is not passed in, Betwixt will guess 
        // But let's write example bean as base element 'person'
        ArrayList<String> addr = new ArrayList<String>();
        addr.add("ABC");
        addr.add("XYZ");
        beanWriter.write("root", new PersonBean("John Smith", 21, addr, new Date()));
        
        // Write to System.out
        // (We could have used the empty constructor for BeanWriter 
        // but this way is more instructive)
        System.out.println(outputWriter.toString());
        
        // Betwixt writes fragments not documents so does not automatically close 
        // writers or streams.
        // This example will do no more writing so close the writer now.
        outputWriter.close();
    }
}
