/**
 * UploadAction
 *
 * $Author: Peru $
 * $Date: 2007/01/30 12:06:11 $
 * $Id: UploadAction.java,v 1.2 2007/01/30 12:06:11 Peru Exp $
 * $Revision: 1.2 $
 *
 * Copyright (c) 2006 SigmaInfo All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * SigmaInfo. Use is subject to license terms.
 *
 */
package upload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.RequestContext;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.struts2.Action;
import org.apache.struts2.interceptor.ServletRequestAware;

/**
 * @author Saravana Perumal.S
 */
public class UploadAction implements Action, ServletRequestAware {

	private HttpServletRequest	request;

	protected File file;

	//protected String						contentType;
	
	private String contentType;

	protected String filename;

	public void setUpload(File file) {
		this.file = file;
	}

	public void setUploadContentType(String contentType) {
		this.contentType = contentType;
	}

	public void setUploadFileName(String filename) {
		this.filename = filename;
	}

	/**
	 * @return the contentType
	 */
	public String getContentType() {
		return contentType;
	}

	/**
	 * @return the file
	 */
	public File getFile() {
		return file;
	}

	/**
	 * @return the filename
	 */
	public String getFilename() {
		return filename;
	}

	private String getCanonicalName(String filename) {
		int forwardSlash = filename.lastIndexOf("/");
		int backwardSlash = filename.lastIndexOf("\\");
		if (forwardSlash != -1 && forwardSlash > backwardSlash) {
			filename = filename.substring(forwardSlash + 1, filename.length());
		} else if (backwardSlash != -1 && backwardSlash >= forwardSlash) {
			filename = filename.substring(backwardSlash + 1, filename.length());
		}
		return filename;
	}

	private RequestContext createRequestContext(final HttpServletRequest req) {
		return new RequestContext() {

			public String getCharacterEncoding() {
				return req.getCharacterEncoding();
			}

			public String getContentType() {
				return req.getContentType();
			}

			public int getContentLength() {
				return req.getContentLength();
			}

			public InputStream getInputStream() throws IOException {
				return req.getInputStream();
			}
		};
	}

	public void handleUploads(HttpServletRequest servletRequest, String saveDir,
			int maxSize) throws IOException {
		DiskFileItemFactory fac = new DiskFileItemFactory();
		ReadProperties rp = new ReadProperties();
		fac.setSizeThreshold(0);
		if (saveDir != null) {
			fac.setRepository(new File(saveDir));
		}
		// Parse the request
		try {
			ServletFileUpload upload = new ServletFileUpload(fac);
			List items = upload.parseRequest(createRequestContext(servletRequest));
			FileItem item = (FileItem) items.get(0);
			System.out.println("Found item " + item.getFieldName());
			if (item.isFormField()) {
				System.out.println("Item is a normal form field");
			} else {
				System.out.println("Item is a file upload");
				DiskFileItem diskFileItem = (DiskFileItem) item;
				filename = rp.getValue("FILE_UPLOAD") + getCanonicalName(diskFileItem.getName());
				
				System.out.println("The file name is..." + filename);
//				retrieve the file data
				InputStream stream = item.getInputStream();
				file = diskFileItem.getStoreLocation();
				
				OutputStream bos = new FileOutputStream(filename);
				int bytesRead = 0;
				byte[] buffer = new byte[8192];
				while ((bytesRead = stream.read(buffer, 0, 8192)) != -1) {
					bos.write(buffer, 0, bytesRead);
				}
				bos.close();        
				stream.close();  
				
				
				
			}
		} catch (FileUploadException e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.struts2.Action#execute()
	 */
	public String execute() {
		if (filename == null) {
			try {
				handleUploads(request, "D://images//temp//", 2097152);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "success";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.struts2.interceptor.ServletRequestAware#setServletRequest(javax.servlet.http.HttpServletRequest)
	 */
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	/**
	 * @param contentType the contentType to set
	 */
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
}
