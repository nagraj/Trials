package betwixt;

public class Attachment {

	private String fileAttached;
	private String attachmentDescr;
	
	public Attachment() {
		super();
	}

	public Attachment(String fileAttached, String attachmentDescr) {
		super();
		this.fileAttached = fileAttached;
		this.attachmentDescr = attachmentDescr;
	}

	/**
	 * @return the fileAttached
	 */
	public String getFileAttached() {
		return this.fileAttached;
	}

	/**
	 * @param fileAttached the fileAttached to set
	 */
	public void setFileAttached(String fileAttached) {
		this.fileAttached = fileAttached;
	}

	/**
	 * @return the attachmentDescr
	 */
	public String getAttachmentDescr() {
		return this.attachmentDescr;
	}

	/**
	 * @param attachmentDescr the attachmentDescr to set
	 */
	public void setAttachmentDescr(String attachmentDescr) {
		this.attachmentDescr = attachmentDescr;
	}
	
	
}
