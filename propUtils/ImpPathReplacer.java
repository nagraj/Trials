package propUtils;

public class ImpPathReplacer {	
	
	public static void main(String[] args){		
		boolean fullpath	=	false;
		/*String htmltext	=	"<html><head><IMG SRC=\"oldestpath/something.jpg\"/>\n"+
							"<IMG SRC=\"old/NONE1.jpg\"/></head></html>";*/	
		String htmltext	=	"s<br />\n" +
		"<IMG alt=\"\" SRC=\"file:///uday//temp//14539930.jpg\" />";
		
		//NOTE : the 2 images are not having the same paths. So all the images would be changed
		String newPath	=	"file:///u//user1//newestpath/subpath";		
		System.out.println(new ImpPathReplacer().replaceImg(htmltext, newPath, fullpath));		
	}
	
	public String replaceImg(String htmlBody, String newPath, boolean fullpath){		
		StringBuffer tempLine = new StringBuffer(htmlBody);
		int imgIdx = tempLine.indexOf("<IMG");
		System.out.println("Coming here");
		while(imgIdx != -1) {
			System.out.println("Coming here 2");
			int srcIdx = tempLine.indexOf("SRC",imgIdx);
			int quoteIdx = tempLine.indexOf("\"",srcIdx+5);
			int tempSlashIdx=0,slashIdx=0,idx=0;
			while(tempSlashIdx<quoteIdx){				
				//tempSlashIdx = (tempLine.indexOf("/",srcIdx+5) != -1) ? tempLine.indexOf("/",srcIdx+5) : tempLine.indexOf("\\",srcIdx+5);
				idx+=5;
				tempSlashIdx	=	tempLine.indexOf("//",idx);				
				if(tempSlashIdx!=-1){
					slashIdx	=	tempSlashIdx;
					System.out.println(idx+","+slashIdx);
				}else{			
					System.out.println(idx+","+slashIdx);
					break;
				}
			}
			int endIdx  = (!fullpath) ? slashIdx : quoteIdx;
			tempLine.replace(srcIdx+5,endIdx,newPath);
			imgIdx = tempLine.indexOf("<IMG",endIdx);				
		}	
		return tempLine.toString();
	}	

	
}
