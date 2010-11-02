package JSON;

import java.util.ArrayList;
import net.sf.json.*;

public class JSONTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList al = new ArrayList();
		al.add(new SimpleObject("Nagraj",26));
		al.add(new SimpleObject("Karthick",25));
		al.add(new SimpleObject("Ganesh",24));
		
		JSONArray jsonArr = new JSONArray();
		jsonArr.addAll(al);
		
		System.out.println(jsonArr);

	}

}
