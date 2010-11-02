package imageresizer;
/** 
 * @author Nagraj Rao
 * 
 */
public class AspectRatioProvider {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(getImageDimensions(101,100,48,50));
		
		
	}
	
	public static String getImageDimensions(int imgW, int imgH, int stdW, int stdH){
		
		int resultW=0;
		int resultH=0;
		float temp ;
		float f = imgW/imgH;
		
		if(imgW>=stdW || imgH>=stdH){
			float ratioW = (float)imgW/stdW;
			float ratioH = (float)imgH/stdH;
			if(ratioW>ratioH){
				resultW = new Float((float)imgW/ratioW).intValue();
				resultH = new Float((float)imgH/ratioW).intValue();
				System.out.println("Width diff");
				System.out.println(resultW);
				System.out.println(resultH);
			}else{
				resultW = new Float((float)imgW/ratioH).intValue();
				resultH = new Float((float)imgH/ratioH).intValue();
				System.out.println("Height diff"+ratioH);
				System.out.println(resultW);
				System.out.println(resultH);
			}			
		}else{
			System.out.println("Both are lesser");
			resultW = imgW;
			resultH = imgH;
		}		
		
		return resultW + " X " + resultH;
	}

}
