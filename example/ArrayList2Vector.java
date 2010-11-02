package example;

import java.util.ArrayList;
import java.util.Vector;
 
public class ArrayList2Vector {
  public static void main(String[] args) {
    ArrayList a = new ArrayList();
    a.add("alpha");
    a.add("beta");
    a.add("gamma");
    Vector v = new Vector(a);  //ArrayList2Vector
    System.out.println(v);
    
    Vector v1 = new Vector();
    v1.addElement("1");
    v1.addElement("2");
    
    Vector v2 = new Vector();
    v2.addElement("saravanan");
    v2.addElement("2");
    
    
    Vector v3 = new Vector();
    
    v3.add(v1);
    v3.add(v2);
    
    System.out.println(((Vector)v3.elementAt(1)).elementAt(0));
        
    
  }
}

