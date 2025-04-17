package echoboard.adm.info.service;

import egovframework.com.cmm.ComDefaultVO;

@SuppressWarnings("serial")
public class EchoboardAdmInfoVO extends ComDefaultVO {
	
	/** 관리자고유번호 */
	private String admIdx = "";
	
	/** 이름 */
	private String admName = "";
	
	/** 아이디 */
	private String admId = "";
	
	/** 비밀번호 */
	private String admPw = "";
	
	/** 소속그룹번호 */
	private String grpIdx = "";
	
	/** 소속그룹명 */
	private String grpName = "";
	
	/** 전화번호 */
	private String admTel = "";
	
	/** 휴대전화번호 */
	private String admHp = "";
	
	/** 이메일 */
	private String admEmail = "";

	/** 사용여부 */
	private String useYn = "";

	/** 회사명 */
	private String companyName = "";

	/** 소속/직책 */
	private String companyPosition = "";

	/** 마이페이지, 관리자 수정 분류 */
	private String currentPage = "";

	/** 권한 관리 메뉴 code */
	private String menuCd = "";

	/** 권한 관리 메뉴 name */
	private String menuName = "";
	
	/** 게시판설정 고유번호 */
	private String bcfIdx = "";
	
	private String parentMenuIdx = "";

	public String getAdmIdx() {
		return admIdx;
	}

	public void setAdmIdx(String admIdx) {
		this.admIdx = admIdx;
	}

	public String getAdmName() {
		return admName;
	}

	public void setAdmName(String admName) {
		this.admName = admName;
	}

	public String getAdmId() {
		return admId;
	}

	public void setAdmId(String admId) {
		this.admId = admId;
	}

	public String getAdmPw() {
		return admPw;
	}

	public void setAdmPw(String admPw) {
		this.admPw = admPw;
	}

	public String getGrpIdx() {
		return grpIdx;
	}

	public void setGrpIdx(String grpIdx) {
		this.grpIdx = grpIdx;
	}

	public String getGrpName() {
		return grpName;
	}

	public void setGrpName(String grpName) {
		this.grpName = grpName;
	}

	public String getAdmTel() {
		return admTel;
	}

	public void setAdmTel(String admTel) {
		this.admTel = admTel;
	}

	public String getAdmHp() {
		return admHp;
	}

	public void setAdmHp(String admHp) {
		this.admHp = admHp;
	}

	public String getAdmEmail() {
		return admEmail;
	}

	public void setAdmEmail(String admEmail) {
		this.admEmail = admEmail;
	}

	public String getUseYn() {
		return useYn;
	}

	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyPosition() {
		return companyPosition;
	}

	public void setCompanyPosition(String companyPosition) {
		this.companyPosition = companyPosition;
	}

	public String getMenuCd() {
		return menuCd;
	}

	public void setMenuCd(String menuCd) {
		this.menuCd = menuCd;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}

	public String getBcfIdx() {
		return bcfIdx;
	}

	public void setBcfIdx(String bcfIdx) {
		this.bcfIdx = bcfIdx;
	}

	public String getParentMenuIdx() {
		return parentMenuIdx;
	}

	public void setParentMenuIdx(String parentMenuIdx) {
		this.parentMenuIdx = parentMenuIdx;
	}
}