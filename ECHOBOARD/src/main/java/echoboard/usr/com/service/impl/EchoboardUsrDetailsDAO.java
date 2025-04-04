package echoboard.usr.com.service.impl;

import org.egovframe.rte.psl.dataaccess.EgovAbstractMapper;
import org.springframework.stereotype.Repository;

import echoboard.usr.com.EchoboardUsrSessionVO;

@Repository("usrDetailsDAO")
public class EchoboardUsrDetailsDAO extends EgovAbstractMapper {
	public EchoboardUsrSessionVO selectUserBySabun(EchoboardUsrSessionVO vo) {
		return selectOne("usrDetailsDAO.selectUserBySabun", vo);
	}

	public <T> String getJikmuPeriod(T vo) {
		return selectOne("usrDetailsDAO.getJikmuPeriod", vo);
	}
	
	public String getIsDeptHeadYn(String sabun) {
		return selectOne("usrDetailsDAO.getIsDeptHeadYn", sabun);
	}	
}