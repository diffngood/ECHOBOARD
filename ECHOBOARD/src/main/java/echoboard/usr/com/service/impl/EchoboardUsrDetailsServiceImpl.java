package echoboard.usr.com.service.impl;

import javax.annotation.Resource;
import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import echoboard.usr.com.EchoboardUsrSessionVO;
import echoboard.usr.com.service.EchoboardUsrDetailsService;

@Service("usrDetailsService")
public class EchoboardUsrDetailsServiceImpl extends EgovAbstractServiceImpl implements EchoboardUsrDetailsService {

	@Resource(name = "usrDetailsDAO")
	private EchoboardUsrDetailsDAO usrDetailsDAO;

	@Override
	public EchoboardUsrSessionVO getAuthenticatedUser() {
		if (RequestContextHolder.getRequestAttributes() == null) {
				return null;
			}
	
		return (EchoboardUsrSessionVO) RequestContextHolder.getRequestAttributes().getAttribute("sessionVo", RequestAttributes.SCOPE_SESSION);
	}

	// getAuthenticatedUser 와 같은 기능을 하는 메소드
	// 좀 더 명시적인 이름으로 변경하면서 기존 메소드가 사용된 코드에서 충돌을 임시로 막기위해 사용
	@Override
	public EchoboardUsrSessionVO getSessionVo() {
		if (RequestContextHolder.getRequestAttributes() == null) {
				return null;
			}
		return (EchoboardUsrSessionVO) RequestContextHolder.getRequestAttributes().getAttribute("sessionVo", RequestAttributes.SCOPE_SESSION);
	}

	@Override
	public EchoboardUsrSessionVO selectUserBySabun(EchoboardUsrSessionVO vo) throws Exception {
		return usrDetailsDAO.selectUserBySabun(vo);
	}

	@Override
	public <T> String getJikmuPeriod(T vo) throws Exception {
		return usrDetailsDAO.getJikmuPeriod(vo);
	}
	
    @Override
    public String getIsDeptHeadYn(String sabun) {
        return usrDetailsDAO.getIsDeptHeadYn(sabun);
    }	
}
