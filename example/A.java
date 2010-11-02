package example;


class A {

	
	int i=10;
	
}

class B extends A
{
//	int i=20;

	
}

class C {

/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		A a1 = new B();
		System.out.println(a1.i);

	}

}