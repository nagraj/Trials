package betwixt;

import java.util.List;

public class SR {

	private List messages;
	private String serviceReqId;
	private String summary;
	
	public SR() {
		super();
	}
	public SR(String serviceReqId, String summary, List messages) {
		super();
		this.serviceReqId = serviceReqId;
		this.summary = summary;
		this.messages = messages;
	}
	/**
	 * @return the serviceReqId
	 */
	public String getServiceReqId() {
		return this.serviceReqId;
	}
	/**
	 * @param serviceReqId the serviceReqId to set
	 */
	public void setServiceReqId(String serviceReqId) {
		this.serviceReqId = serviceReqId;
	}
	/**
	 * @return the summary
	 */
	public String getSummary() {
		return this.summary;
	}
	/**
	 * @param summary the summary to set
	 */
	public void setSummary(String summary) {
		this.summary = summary;
	}
	/**
	 * @return the messages
	 */
	public List getMessages() {
		return this.messages;
	}
	/**
	 * @param messages the messages to set
	 */
	public void setMessages(List messages) {
		this.messages = messages;
	}
	
	
	
}
