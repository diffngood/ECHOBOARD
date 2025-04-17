package echoboard.usr.com.service;

import echoboard.adm.login.service.EchoboardAdmLoginVO;
import echoboard.usr.login.service.EchoboardUserLoginVO;

public interface EchoboardUsrDetailsService {

	/**
	 * 인증된 사용자객체를 VO형식으로 가져온다.
	 * @return Object - 사용자 ValueObject
	 */
	EchoboardUserLoginVO getAuthenticatedUser();

	EchoboardUserLoginVO getSessionVo();
	
	EchoboardAdmLoginVO getAdminAuthenticatedUser();
	
	// 부서장 체크
	String getIsDeptHeadYn(String sabun);
}