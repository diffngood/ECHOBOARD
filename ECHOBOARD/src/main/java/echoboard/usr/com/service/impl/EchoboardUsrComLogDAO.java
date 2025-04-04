package echoboard.usr.com.service.impl;

import org.egovframe.rte.psl.dataaccess.EgovAbstractMapper;
import org.springframework.stereotype.Repository;

import echoboard.usr.com.EchoboardUsrAccessVO;

@Repository("usrComLogDAO")
public class EchoboardUsrComLogDAO extends EgovAbstractMapper {
	
	public void insertUserAccessLog(EchoboardUsrAccessVO vo) {
		insert("usrComLogDAO.insertUserAccessLog", vo);
	}

	public void insertUserPersonalInfoAccessLog(EchoboardUsrAccessVO vo) {
		insert("usrComLogDAO.insertUserPersonalInfoAccessLog", vo);
	}
}