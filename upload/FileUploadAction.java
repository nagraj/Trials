
package upload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.webwork.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ValidationAware;

public class FileUploadAction extends ActionSupport implements ServletRequestAware,ServletResponseAware {
	private static final long serialVersionUID = -9208910183310010569L;
	private File file;
	private String contentType;
	private String fileName;
	private String cancel;
	String fileNumber = "";
	String status;
	private HttpServletRequest request;
	private HttpServletResponse response;
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request=request;
	}
	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.response = response;
	}
	
		
	public String execute()  throws Exception {
		String page="error";
		String uploadDir = "";
		String fileName = "";
		String file = "";
		ReadProperties rp = new ReadProperties();
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);   
		List  items = upload.parseRequest(request);
		int num = 0;
		System.out.println("items length======>"+items.size());
		if(!(items.size()==0)){
			Iterator iter = items.iterator();
			FileItem item=null;
			while (iter.hasNext()) {
				num = num +1;
				item=(FileItem)iter.next();
				if(item.getFieldName().equalsIgnoreCase("submit")){
					System.out.println("fileNumber : "+item.getString());	
					fileNumber=item.getString();
								
					
				}else{
					
					if(!item.getName().equalsIgnoreCase("")){
									
						fileNumber="1";
						// the directory to upload to
	//					uploadDir =ServletActionContext.getServletContext().getRealPath("\\resources") +
	//					"\\" + "temdir" + "\\";
						uploadDir = rp.getValue("FILE_UPLOAD");
												
	//					uploadDir ="D:\\image\\perm\\";
						// write the file to the file specified
						File dirPath = new File(uploadDir);
						if (!dirPath.exists()) {
							dirPath.mkdirs();
						}
						//retrieve the file data
						InputStream stream = item.getInputStream();
	
						//write the file to the file specified
						//fileName ="D:/image/"+ "image"+fileNumber+".jpeg";
						fileName =rp.getValue("FILE_TEMP")+ "image"+num+".jpeg";
						OutputStream bos = new FileOutputStream(fileName);
						int bytesRead = 0;
						byte[] buffer = new byte[8192];
						while ((bytesRead = stream.read(buffer, 0, 8192)) != -1) {
							bos.write(buffer, 0, bytesRead);
						}
						bos.close();        
						stream.close();  
						System.out.println("fileName============>"+fileName);
	//					ImageResizer imageResizer=new ImageResizer();
	//					System.out.println("Coming here............"+ imageResizer);
						String resized=ImageResizer.saveJPEG(fileName, uploadDir+"image"+num+".jpeg", 75,75,50);
						uploadDir+="image"+num+".jpeg";
						
						file = "image"+num+".jpeg";
						// place the data into the request for retrieval on next page
						//    request.setAttribute("location", dirPath.getAbsolutePath()
						//         + Constants.FILE_SEP + fileFileName);
	
						/*String link =
							request.getContextPath() + "/resources" + "/" +
							"temdir" + "/"+"image"+fileNumber+".jpeg";*/
						
					}
				}
			}
			
//			ContextProviderRegistry.getInstance().getContext().setAttribute("link", uploadDir, Scope.SESSION);
			request.getSession(true).setAttribute("link", file );
						
			
//			response.setHeader("Cache-Control","no-cache"); 
//		    //response.setHeader("Cache-Control","no-store");
//		    response.setDateHeader("Expires", 0);
//		    response.setHeader ("Pragma","no-cache");
						
			page="success";
		}
		System.out.println("The return String is...." + page);
		return page;
    }

	
	
	public String uploadImage() throws Exception {
		String page="error";
		String uploadDir = "";
		String fileName = "";
		System.out.println("innnnnnnnnnnnnnnnn");
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);   
		List  items = upload.parseRequest(request);
		System.out.println("items length==================>"+items.size());
		if(!(items.size()==0)){
			System.out.println("items is====================>"+items);		
			Iterator iter = items.iterator();
			FileItem item=null;
			while (iter.hasNext()) {
				item=(FileItem)iter.next();
				if(item.getFieldName().equals("fileNumber")){
					System.out.println("fileNumber : "+item.getString());	
					fileNumber=item.getString();
					
					if(item.getFieldName().equals("file1")){
						System.out.println("The file Name is ...." + item.getString());
					}
					
					
				}else{	

					// the directory to upload to
//					uploadDir =ServletActionContext.getServletContext().getRealPath("\\resources") +
//					"\\" + "temdir" + "\\";
					uploadDir = "D:\\sigma\\Tomcat 5\\webapps\\fileupload\\images\\";
//					uploadDir ="D:\\image\\perm\\";
					// write the file to the file specified
					File dirPath = new File(uploadDir);
					if (!dirPath.exists()) {
						dirPath.mkdirs();
					}
					//retrieve the file data
					InputStream stream = item.getInputStream();

					//write the file to the file specified
					//fileName ="D:/image/"+ "image"+fileNumber+".jpeg";
					fileName ="D:\\image\\temp\\"+ "image"+fileNumber+".jpeg";
					OutputStream bos = new FileOutputStream(fileName);
					int bytesRead = 0;
					byte[] buffer = new byte[8192];
					while ((bytesRead = stream.read(buffer, 0, 8192)) != -1) {
						bos.write(buffer, 0, bytesRead);
					}
					bos.close();        
					stream.close();  
					System.out.println("fileName============>"+fileName);
				}
			}
			ImageResizer imageResizer=new ImageResizer();
			String resized=imageResizer.saveJPEG(fileName, uploadDir+"image"+fileNumber+".jpeg", 75,75,50);
			uploadDir+="image"+fileNumber+".jpeg";
			
			String file = "image"+fileNumber+".jpeg";
			// place the data into the request for retrieval on next page
			//    request.setAttribute("location", dirPath.getAbsolutePath()
			//         + Constants.FILE_SEP + fileFileName);

			/*String link =
				request.getContextPath() + "/resources" + "/" +
				"temdir" + "/"+"image"+fileNumber+".jpeg";*/
			System.out.println("Upload path is==============>"+file);
//			ContextProviderRegistry.getInstance().getContext().setAttribute("link", uploadDir, Scope.SESSION);
			request.getSession(true).setAttribute("link", file );
			page="success";


		}
		return page;
	}
	public String start() {
		return INPUT;
	}

	public String getUploadContentType() {
		return contentType;
	}

	public void setUploadContentType(String contentType) {
		this.contentType = contentType;
	}

	public File getUpload() {
		return file;
	}

	public void setUpload(File file) {
		this.file = file;
	}

	public String getUploadFileName() {
		return fileName;
	}

	public void setUploadFileName(String fileName) {
		this.fileName = fileName;
	}
	





}

