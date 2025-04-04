package echoboard.usr.com;

import egovframework.com.cmm.ComDefaultVO;

@SuppressWarnings("serial")
public class EchoboardUsrAccessVO extends ComDefaultVO {
	
	private String logSeq ="";
	private String menuUrl ="";
	private String refererUrl ="";
	private String accessMethod ="";
	private String userAgent ="";
	private String logType ="";
	private String note ="";
	
	public String getLogSeq() {
		return logSeq;
	}
	public void setLogSeq(String logSeq) {
		this.logSeq = logSeq;
	}
	public String getMenuUrl() {
		return menuUrl;
	}
	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}
	public String getRefererUrl() {
		return refererUrl;
	}
	public void setRefererUrl(String refererUrl) {
		this.refererUrl = refererUrl;
	}
	public String getAccessMethod() {
		return accessMethod;
	}
	public void setAccessMethod(String accessMethod) {
		this.accessMethod = accessMethod;
	}
	public String getUserAgent() {
		return userAgent;
	}
	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}
	public String getLogType() {
		return logType;
	}
	public void setLogType(String logType) {
		this.logType = logType;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
}
