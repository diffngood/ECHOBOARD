package echoboard.adm.login.service.impl;

import org.egovframe.rte.psl.dataaccess.EgovAbstractMapper;
import org.springframework.stereotype.Repository;

import echoboard.adm.login.service.EchoboardAdmLoginVO;

@Repository("admLoginDAO")
public class EchoboardAdmLoginDAO extends EgovAbstractMapper {
	
	public EchoboardAdmLoginVO actionLoginAdmin(EchoboardAdmLoginVO vo) throws Exception {
    	return (EchoboardAdmLoginVO)selectOne("admLoginDAO.actionLoginAdmin", vo);
    }
	
	public void updateLastLoginDate(EchoboardAdmLoginVO vo) throws Exception {
    	update("admLoginDAO.updateLastLoginDate", vo);
    }
	
	public void updateLoginFailCnt(EchoboardAdmLoginVO vo) throws Exception {
    	update("admLoginDAO.updateLoginFailCnt", vo);
    }
	
	public String selectReturnUrl(EchoboardAdmLoginVO vo) throws Exception {		
		return (String) selectOne("admLoginDAO.selectReturnUrl", vo);
	    
    }
}