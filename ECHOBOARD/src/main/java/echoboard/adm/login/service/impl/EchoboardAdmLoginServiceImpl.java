package echoboard.adm.login.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.springframework.stereotype.Service;

import echoboard.adm.info.service.EchoboardAdmInfoVO;
import echoboard.adm.login.service.EchoboardAdmLoginService;
import echoboard.adm.login.service.EchoboardAdmLoginVO;

import org.egovframe.rte.psl.dataaccess.util.EgovMap;

@Service("admLoginService")
public class EchoboardAdmLoginServiceImpl extends EgovAbstractServiceImpl implements EchoboardAdmLoginService {
	@Resource(name = "admLoginDAO")
	private EchoboardAdmLoginDAO admLoginDAO;
	
	@Override
	public EchoboardAdmLoginVO actionLoginAdmin(EchoboardAdmLoginVO vo) throws Exception {		
		return  admLoginDAO.actionLoginAdmin(vo);
	}
	
	@Override
	public void updateLastLoginDate(EchoboardAdmLoginVO vo) throws Exception {		
		admLoginDAO.updateLastLoginDate(vo);
	}
	
	@Override
	public void updateLoginFailCnt(EchoboardAdmLoginVO vo) throws Exception {		
		admLoginDAO.updateLoginFailCnt(vo);
	}
	
	@Override
	public List<EgovMap> selectAdmMenuList(EchoboardAdmInfoVO vo) throws Exception {
		return admLoginDAO.selectAdmMenuList(vo);
	}
}