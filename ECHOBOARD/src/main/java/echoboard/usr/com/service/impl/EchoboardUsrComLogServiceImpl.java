package echoboard.usr.com.service.impl;

import javax.annotation.Resource;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.springframework.stereotype.Service;

import echoboard.usr.com.EchoboardUsrAccessVO;
import echoboard.usr.com.service.EchoboardUsrComLogService;

@Service("usrComLogService")
public class EchoboardUsrComLogServiceImpl extends EgovAbstractServiceImpl implements EchoboardUsrComLogService {

	@Resource(name = "usrComLogDAO")
	private EchoboardUsrComLogDAO usrComLogDAO;

	@Override
	public void insertUserAccessLog(EchoboardUsrAccessVO vo) throws Exception {
		usrComLogDAO.insertUserAccessLog(vo);
	}
	
	@Override
	public void insertUserPersonalInfoAccessLog(EchoboardUsrAccessVO vo) throws Exception {
		usrComLogDAO.insertUserPersonalInfoAccessLog(vo);
	}

}
