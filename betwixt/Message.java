package betwixt;

import java.util.List;

public class Message {

	private String from;
	private String to;
	private List attachments;
	public Message() {
		super();
	}
	public Message(String from, String to, List attachments) {
		super();
		this.from = from;
		this.to = to;
		this.attachments = attachments;
	}
	/**
	 * @return the from
	 */
	public String getFrom() {
		return this.from;
	}
	/**
	 * @param from the from to set
	 */
	public void setFrom(String from) {
		this.from = from;
	}
	/**
	 * @return the to
	 */
	public String getTo() {
		return this.to;
	}
	/**
	 * @param to the to to set
	 */
	public void setTo(String to) {
		this.to = to;
	}
	/**
	 * @return the attachments
	 */
	public List getAttachments() {
		return this.attachments;
	}
	/**
	 * @param attachments the attachments to set
	 */
	public void setAttachments(List attachments) {
		this.attachments = attachments;
	}
	
	
	
	
}
