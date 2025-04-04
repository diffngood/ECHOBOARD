package echoboard.usr.com.service;

import echoboard.usr.com.EchoboardUsrAccessVO;

public interface EchoboardUsrComLogService {

	void insertUserAccessLog(EchoboardUsrAccessVO vo) throws Exception;
	
	void insertUserPersonalInfoAccessLog(EchoboardUsrAccessVO vo) throws Exception;

}