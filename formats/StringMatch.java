package formats;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringMatch {

	public static void main(String[] args){
		String str	=	"<a href=\'javascript:doValidate()\';";
		String matchWith	=	"<a";		
		Pattern pat	=	Pattern.compile(matchWith);
		Matcher matcher	=	pat.matcher(str);
		if(str.matches(matchWith)){
			System.out.println("Found : "+str);
		}else if(matcher.matches()){
			System.out.println("Pat Found : "+str);
		}else{
			System.out.println("Not Found : "+str);
		}
		
		String str1 = "2007";
		System.out.println(""+str1.substring(2));
	}
}
