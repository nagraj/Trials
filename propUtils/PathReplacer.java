package propUtils;

public class PathReplacer {	
	
	public static void main(String[] args){		
		boolean fullpath	=	false;
		/*String htmltext	=	"<html><head><IMG SRC=\"oldestpath/something.jpg\"/>\n"+
							"<IMG SRC=\"old/NONE1.jpg\"/></head></html>";*/	
		String htmltext	=	"sdhfjsdhfjks<br />\n" +
		"sdfkjsdfjs<IMG alt=\"\" SRC=\"file:///D://My%20Documents//My%20Pictures//14539930.jpg\" />";	
		//NOTE : the 2 images are not having the same paths. So all the images would be changed
		String newPath	=	"newestpath/subpath";		
		System.out.println(new PathReplacer().replaceImg(htmltext, newPath, fullpath));		
	}
	
	public String replaceImg(String htmlBody, String newPath, boolean fullpath){		
		StringBuffer tempLine = new StringBuffer(htmlBody);
		int imgIdx = tempLine.indexOf("<IMG");
		while(imgIdx != -1) {
			int srcIdx = tempLine.indexOf("SRC",imgIdx);
			int quoteIdx = tempLine.indexOf("\"",srcIdx+5);
			int slashIdx = (tempLine.indexOf("/",srcIdx+5) != -1) ? tempLine.indexOf("/",srcIdx+5) : tempLine.indexOf("\\",srcIdx+5);
			int endIdx  = (!fullpath) ? slashIdx : quoteIdx;
			tempLine.replace(srcIdx+5,endIdx,newPath);
			imgIdx = tempLine.indexOf("<IMG",endIdx);				
		}	
		return tempLine.toString();
	}	

	
}
