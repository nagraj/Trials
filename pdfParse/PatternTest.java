package pdfParse;


import java.util.ArrayList;

import java.util.List;



public class PatternTest {

	
	  public static void main(String[] args) {
			String[] recordDetails =new String[]{"PRICE","XYZ","UPC","CDE","ABC","ABC","ABC"
			,"ABC","ABC","ABC","ABC","ABC","ABC","ABC","ABC","ABC","ABC","ABC"
			,"ABC","ABC","PRICE","ABC","XYZ","ABC","UPC","ABC","CDE","ABC","ABC"
			,"PRICE","ABC","ABC","XYZ","PRICE","UPC","ABC","CDE","ABC","ABC","ABC","ABC","ABC","ABC","ABC","ABC","ABC","ABC","ABC"
			,"ABC","PRICE","XYZ","ABC","ABC","UPC","ABC"};
			PatternTest test =new PatternTest();
			String[]  pattern =new String[]{"XYZ","PRICE","UPC","CDE"};
			List records =test.getRowDetails(recordDetails,pattern );
			for(int i=0; i< records.size();i++){
				ArrayList record = (ArrayList)records.get(i);
					System.out.println("Record# "+i+ " and Details are ==>"+record);
				
			}
			
		
		}
	  public  List getRowDetails(String[] details,String[] colPattern ){
		  
		  int noOfPatterns = colPattern.length;
		  int j=0;
		  List records = new ArrayList();
		  // tempArray will retain all value for each record. once tempArray is having all value then it will write all details in arraylist and 
		  // reinitialize it again for next record.
		  String[] tempArray=new String[colPattern.length];
		  for(int i=0; i< details.length;i++){
			  int k=(j-1);
			  k=  k<0 ? 0 : k; 
			  if(tempArray[k] !=null){
				  //check all previous pattern with current pattern to check whether it is matching or not. if matching, start search again and
				  // reinitialize tempArray.
				  for(int m=(j+1);m<colPattern.length;m++){
						 if(colPattern[m].equalsIgnoreCase(details[i])){  	 		
							 j=0;
							 tempArray=new String[colPattern.length];
						 }
				  }
                  // check all next pattern with current pattern to check whether it is matching or not. if matching, start search again and
				  // reinitialize tempArray.
				  for(int m=0;m<=k;m++){
						 if(colPattern[m].equalsIgnoreCase(details[i])){  	 		
							 j=0;
							 tempArray=new String[colPattern.length];
						 }
				 
				  }
				  // add next matching pattern in tempArray for future use.
				  if(tempArray[k] == details[i]){
					  tempArray[k] = details[i];
				  }
			  }
			  // If pattern is matching add record in tempArray and increment j variable..
			  if(colPattern[j].equalsIgnoreCase(details[i])){
				  tempArray[j]=details[i];
				  j++;
				  // If j variable and noOfPatterns are matching then generate record and put it inside list object and reinitialize j as well as t
				  // tempArray for next record.
				  if(j == noOfPatterns){
					  records.add( generateRecord(colPattern));
					 j=0;
					 tempArray=new String[colPattern.length];
				  }
			  }
			  
		  }
		  return records;
	  }
	  // Generate record and put it in list.
	  public List generateRecord(String[] colPatterns){
		  List record = new ArrayList();
		  for(int i =0;i<colPatterns.length;i++)
			  record.add(colPatterns[i]);
		  return record;
	  }
	 
}
