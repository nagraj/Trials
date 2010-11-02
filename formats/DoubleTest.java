package formats;

import java.math.BigDecimal;

public class DoubleTest {

	public static void main(String[] args){
//		String str	=	"123456789012345";
//		Double dbl	=	Double.parseDouble(str);
//		Float flt	=	Float.parseFloat(str);
//		System.out.println("value : "+dbl);
//		System.out.println("value : "+flt);
//		
//		
//		Float f1=new Float("3.0");
//		Float f2=new Float("2.5");
//		System.out.println("compare : "+f1.compareTo(f2));
		
//		Float f = new Float(12345678);
//		BigDecimal bd = new BigDecimal(f);
//		System.out.println("number : "+bd.intValueExact()+" double : "+f);
//		
		Float f1 = new Float(12.12005);
		BigDecimal bd = new BigDecimal(f1);		
		System.out.println("new Float : "+bd.ROUND_FLOOR);
	}
}
