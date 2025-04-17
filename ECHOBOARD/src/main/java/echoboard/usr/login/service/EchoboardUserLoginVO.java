package echoboard.usr.login.service;

import egovframework.com.cmm.ComDefaultVO;

public class EchoboardUserLoginVO extends ComDefaultVO{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String loginIdx = "";
	private String loginId = "";
	private String loginPwd = "";
	private String loginName = "";
	private String loginLevel = "";
	private String loginPhone = "";
	private String userStatus = "";
	
	public String getLoginIdx() {
		return loginIdx;
	}
	public void setLoginIdx(String loginIdx) {
		this.loginIdx = loginIdx;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getLoginPwd() {
		return loginPwd;
	}
	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getLoginLevel() {
		return loginLevel;
	}
	public void setLoginLevel(String loginLevel) {
		this.loginLevel = loginLevel;
	}
	public String getLoginPhone() {
		return loginPhone;
	}
	public void setLoginPhone(String loginPhone) {
		this.loginPhone = loginPhone;
	}
	public String getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
}