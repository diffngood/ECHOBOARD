package echoboard.adm.login.service;

import egovframework.com.cmm.ComDefaultVO;

@SuppressWarnings("serial")
public class EchoboardAdmLoginVO extends ComDefaultVO{

	private String loginId = "";
	private String loginPass = "";
	private String idSaveChK = "0";
	private String admIdx = "";
	private String admLevel = "";	
	private String admId = "";	
	private String admName = "";	
	private String admPw = "";	
	private String menuUrl = "";
	private String menuCd = "";
	private String grpIdx	= "";
	private String returnUrl = "";
	private String companyName	="";
	private String loginFail	="";
	private String loginFailDt	="";
	
	
	public String getLoginId() {
		return loginId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getLoginPass() {
		return loginPass;
	}
	public void setLoginPass(String loginPass) {
		this.loginPass = loginPass;
	}
	public String getIdSaveChK() {
		return idSaveChK;
	}
	public void setIdSaveChK(String idSaveChK) {
		this.idSaveChK = idSaveChK;
	}
	public String getAdmIdx() {
		return admIdx;
	}
	public void setAdmIdx(String admIdx) {
		this.admIdx = admIdx;
	}
	public String getAdmLevel() {
		return admLevel;
	}
	public void setAdmLevel(String admLevel) {
		this.admLevel = admLevel;
	}
	public String getAdmId() {
		return admId;
	}
	public void setAdmId(String admId) {
		this.admId = admId;
	}
	public String getAdmName() {
		return admName;
	}
	public void setAdmName(String admName) {
		this.admName = admName;
	}
	public String getAdmPw() {
		return admPw;
	}
	public void setAdmPw(String admPw) {
		this.admPw = admPw;
	}
	public String getMenuUrl() {
		return menuUrl;
	}
	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}
	public String getMenuCd() {
		return menuCd;
	}
	public void setMenuCd(String menuCd) {
		this.menuCd = menuCd;
	}
	public String getGrpIdx() {
		return grpIdx;
	}
	public void setGrpIdx(String grpIdx) {
		this.grpIdx = grpIdx;
	}
	public String getReturnUrl() {
		return returnUrl;
	}
	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}
	public String getLoginFail() {
		return loginFail;
	}
	public void setLoginFail(String loginFail) {
		this.loginFail = loginFail;
	}
	public String getLoginFailDt() {
		return loginFailDt;
	}
	public void setLoginFailDt(String loginFailDt) {
		this.loginFailDt = loginFailDt;
	}

}
