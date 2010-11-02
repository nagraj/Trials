
package nag.mailer.image;

public class EmailMetaInfo {
	private String	hostName;
	private String	fromEmail;
	private String	subjectMsg;
	private boolean	isAuthReqd;
	private String	fromEmailPass;
	private String	bodyText;
	private String	replyTo;
	private String hostUserName;
	private String hostPassword;
	private String filePath;
	
	
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	/**
	 * @return Returns the hostPassword.
	 */
	public String getHostPassword() {
		return hostPassword;
	}
	/**
	 * @param hostPassword The hostPassword to set.
	 */
	public void setHostPassword(String hostPassword) {
		this.hostPassword = hostPassword;
	}
	/**
	 * @return Returns the hostUserName.
	 */
	public String getHostUserName() {
		return hostUserName;
	}
	/**
	 * @param hostUserName The hostUserName to set.
	 */
	public void setHostUserName(String hostUserName) {
		this.hostUserName = hostUserName;
	}
	public String getFromEmail() {
		return fromEmail;
	}
	public void setFromEmail(String fromEmail) {
		this.fromEmail = fromEmail;
	}
	public String getFromEmailPass() {
		return fromEmailPass;
	}
	public void setFromEmailPass(String fromEmailPass) {
		this.fromEmailPass = fromEmailPass;
	}
	public String getHostName() {
		return hostName;
	}
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	public boolean isAuthReqd() {
		return isAuthReqd;
	}
	public void setAuthReqd(boolean isAuthReqd) {
		this.isAuthReqd = isAuthReqd;
	}
	public String getSubjectMsg() {
		return subjectMsg;
	}
	public void setSubjectMsg(String subjectMsg) {
		this.subjectMsg = subjectMsg;
	}
	public String getBodyText() {
		return bodyText;
	}
	public void setBodyText(String bodyText) {
		this.bodyText = bodyText;
	}
	public String getReplyTo() {
		return replyTo;
	}
	public void setReplyTo(String replyTo) {
		this.replyTo = replyTo;
	}
	
}
