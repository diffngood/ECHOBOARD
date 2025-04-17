package echoboard.usr.com.service.impl;

import org.egovframe.rte.psl.dataaccess.EgovAbstractMapper;
import org.springframework.stereotype.Repository;

@Repository("usrDetailsDAO")
public class EchoboardUsrDetailsDAO extends EgovAbstractMapper {
	
	public String getIsDeptHeadYn(String sabun) {
		return selectOne("usrDetailsDAO.getIsDeptHeadYn", sabun);
	}	
}