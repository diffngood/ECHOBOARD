package echoboard.usr.com.service.impl;

import javax.annotation.Resource;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import echoboard.adm.login.service.EchoboardAdmLoginVO;
import echoboard.usr.com.service.EchoboardUsrDetailsService;
import echoboard.usr.login.service.EchoboardUserLoginVO;

@Service("usrDetailsService")
public class EchoboardUsrDetailsServiceImpl extends EgovAbstractServiceImpl implements EchoboardUsrDetailsService {

	@Resource(name = "usrDetailsDAO")
	private EchoboardUsrDetailsDAO usrDetailsDAO;

	@Override
	public EchoboardUserLoginVO getAuthenticatedUser() {
		if (RequestContextHolder.getRequestAttributes() == null) {
				return null;
			}
	
		return (EchoboardUserLoginVO) RequestContextHolder.getRequestAttributes().getAttribute("userLoginSession", RequestAttributes.SCOPE_SESSION);
	}
	
	@Override
	public EchoboardAdmLoginVO getAdminAuthenticatedUser() {
		if (RequestContextHolder.getRequestAttributes() == null) {
				return null;
			}
	
		return (EchoboardAdmLoginVO) RequestContextHolder.getRequestAttributes().getAttribute("adminLoginSession", RequestAttributes.SCOPE_SESSION);
	}

	// getAuthenticatedUser 와 같은 기능을 하는 메소드
	// 좀 더 명시적인 이름으로 변경하면서 기존 메소드가 사용된 코드에서 충돌을 임시로 막기위해 사용
	@Override
	public EchoboardUserLoginVO getSessionVo() {
		if (RequestContextHolder.getRequestAttributes() == null) {
				return null;
			}
		return (EchoboardUserLoginVO) RequestContextHolder.getRequestAttributes().getAttribute("sessionVo", RequestAttributes.SCOPE_SESSION);
	}
	
    @Override
    public String getIsDeptHeadYn(String sabun) {
        return usrDetailsDAO.getIsDeptHeadYn(sabun);
    }	
}
