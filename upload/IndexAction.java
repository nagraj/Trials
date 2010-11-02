package upload;


import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;


public class IndexAction extends ActionSupport implements ServletResponseAware  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private HttpServletResponse response;

	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.response = response;
	}
	
	public String execute()  throws Exception {
		
		response.setHeader("Cache-Control","no-cache"); 
	    response.setHeader("Cache-Control","no-store");
	    response.setDateHeader("Expires", 0);
	    response.setHeader ("Pragma","no-cache");
		return SUCCESS;
		
	}

	

}
