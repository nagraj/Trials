package encode;

import java.net.URLDecoder;
import java.net.URLEncoder;

public class TrialEncoding {

	private static final String encoding_8_bit = "UTF-8";
	private static final String encoding_16_bit = "UTF-16";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String url = "http://localhost:8080/blackwells";
		String encodedUrl ="", decodedUrl ="";
		try{
			encodedUrl = URLEncoder.encode(url, encoding_16_bit);
			decodedUrl = URLDecoder.decode(encodedUrl, encoding_16_bit);
			System.out.println("encoded : "+encodedUrl+"\ndecoded : "+ decodedUrl);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
