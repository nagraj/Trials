package example;

/*class Art {
  Art() {
    System.out.println("Art constructor");
  }
}

class Drawing extends Art {
  Drawing() {
    System.out.println("Drawing constructor");
  }
}

public class Cartoon extends Drawing {
  public Cartoon() {
    System.out.println("Cartoon constructor");
  }

  public static void main(String[] args) {
    Cartoon x = new Cartoon();

  }
} ///:~
*/





/*class Rock {
  Rock() { // This is the constructor
    System.out.println("Creating Rock");
  }
}

public class Cartoon {

  public static void main(String[] args) {
    for (int i = 0; i < 10; i++)
      new Rock();
  }
} ///:~
*/



//  Overloading a base-class method name in a derived class does not hide the base-class versions  

class Homer {
  char doh(char c) {
    System.out.println("doh(char)");
    return 'd';
  }

  float doh(float f) {
    System.out.println("doh(float)");
    return 1.0f;
  }
}

class Milhouse {
}

class Bart extends Homer {
  void doh(Milhouse m) {
    System.out.println("doh(Milhouse)");
  }
}

public class Cartoon {
  public static void main(String[] args) {
    Bart b = new Bart();
    b.doh(1);
    b.doh('x');
    b.doh(1.0f);
    b.doh(new Milhouse());
  }
} ///:~
