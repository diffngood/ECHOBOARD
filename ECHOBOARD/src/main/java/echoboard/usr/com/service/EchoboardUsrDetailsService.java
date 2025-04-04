package echoboard.usr.com.service;

import echoboard.usr.com.EchoboardUsrSessionVO;

public interface EchoboardUsrDetailsService {

	/**
	 * 인증된 사용자객체를 VO형식으로 가져온다.
	 * @return Object - 사용자 ValueObject
	 */
	EchoboardUsrSessionVO getAuthenticatedUser();

	EchoboardUsrSessionVO getSessionVo();

	EchoboardUsrSessionVO selectUserBySabun(EchoboardUsrSessionVO vo) throws Exception;

	<T> String getJikmuPeriod(T vo) throws Exception;
	
	// 부서장 체크
	String getIsDeptHeadYn(String sabun);
}