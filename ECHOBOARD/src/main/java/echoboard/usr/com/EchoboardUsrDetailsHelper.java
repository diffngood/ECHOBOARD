package echoboard.usr.com;

import echoboard.usr.com.service.EchoboardUsrDetailsService;

/**
 * EgovUsrDetails Helper 클래스
 *
 * @author sjyoon
 * @since 2009.06.01
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일      수정자           수정내용
 *  -------    -------------    ----------------------
 *   2009.03.10  sjyoon         최초 생성
 *   2011.07.01	 서준식          interface 생성후 상세 로직의 분리
 * </pre>
 */

public class EchoboardUsrDetailsHelper {
	static echoboard.usr.com.service.EchoboardUsrDetailsService EchoboardUsrDetailsService;

	public EchoboardUsrDetailsService getEchoboardUsrDetailsService() {
		return EchoboardUsrDetailsService;
	}

	public void setEchoboardUsrDetailsService(EchoboardUsrDetailsService echoboardUsrDetailsService) {
		EchoboardUsrDetailsHelper.EchoboardUsrDetailsService = echoboardUsrDetailsService;
	}

	public static EchoboardUsrSessionVO getAuthenticatedUser() {
		return EchoboardUsrDetailsService.getAuthenticatedUser();
	}

	public static EchoboardUsrSessionVO getSessionVo() {
		return EchoboardUsrDetailsService.getSessionVo();
	}
}
