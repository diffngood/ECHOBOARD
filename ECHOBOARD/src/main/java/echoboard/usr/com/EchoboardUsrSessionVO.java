package echoboard.usr.com;

import egovframework.com.cmm.ComDefaultVO;

@SuppressWarnings("serial")
public class EchoboardUsrSessionVO extends ComDefaultVO {
	private String sabun			= "";
	private String nameHan			= "";
	private String jikgubNm			= "";
	private String jikgunNm			= "";
	private String jikmuNm			= "";
	private String offiNm			= "";
	private String jikmuCd			= "";
	private String jikgubCd			= "";
	private String orgCd			= "";

	// 근속기간
	private String jikmuPeriod		= "";
	private String isDeptHead		= "";

	// 직무시작일
	private String begda			= "";


	public String getSabun() {
		return sabun;
	}

	public void setSabun(String sabun) {
		this.sabun = sabun;
	}

	public String getNameHan() {
		return nameHan;
	}

	public void setNameHan(String nameHan) {
		this.nameHan = nameHan;
	}

	public String getJikgubNm() {
		return jikgubNm;
	}

	public void setJikgubNm(String jikgubNm) {
		this.jikgubNm = jikgubNm;
	}

	public String getJikgunNm() {
		return jikgunNm;
	}

	public void setJikgunNm(String jikgunNm) {
		this.jikgunNm = jikgunNm;
	}

	public String getJikmuNm() {
		return jikmuNm;
	}

	public void setJikmuNm(String jikmuNm) {
		this.jikmuNm = jikmuNm;
	}

	public String getOffiNm() {
		return offiNm;
	}

	public void setOffiNm(String offiNm) {
		this.offiNm = offiNm;
	}

	public String getJikmuCd() {
		return jikmuCd;
	}

	public void setJikmuCd(String jikmuCd) {
		this.jikmuCd = jikmuCd;
	}

	public String getJikgubCd() {
		return jikgubCd;
	}

	public void setJikgubCd(String jikgubCd) {
		this.jikgubCd = jikgubCd;
	}

	public String getOrgCd() {
		return orgCd;
	}

	public void setOrgCd(String orgCd) {
		this.orgCd = orgCd;
	}

	public String getJikmuPeriod() {
		return jikmuPeriod;
	}

	public void setJikmuPeriod(String jikmuPeriod) {
		this.jikmuPeriod = jikmuPeriod;
	}

	public String getIsDeptHead() {
		return isDeptHead;
	}

	public void setIsDeptHead(String isDeptHead) {
		this.isDeptHead = isDeptHead;
	}

	public String getBegda() {
		return begda;
	}

	public void setBegda(String begda) {
		this.begda = begda;
	}
}
