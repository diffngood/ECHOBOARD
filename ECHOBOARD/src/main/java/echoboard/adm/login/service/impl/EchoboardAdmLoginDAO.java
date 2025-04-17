package echoboard.adm.login.service.impl;

import java.util.List;

import org.egovframe.rte.psl.dataaccess.EgovAbstractMapper;
import org.springframework.stereotype.Repository;

import echoboard.adm.info.service.EchoboardAdmInfoVO;
import echoboard.adm.login.service.EchoboardAdmLoginVO;

import org.egovframe.rte.psl.dataaccess.util.EgovMap;

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
	
	/**
	 * 관리자 메뉴
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<EgovMap> selectAdmMenuList(EchoboardAdmInfoVO vo) throws Exception {
		return (List<EgovMap>) list("admLoginDAO.selectAdmMenuList", vo);
	}
}