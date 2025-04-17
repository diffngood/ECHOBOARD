package echoboard.adm.login.service;

import java.util.List;

import org.egovframe.rte.psl.dataaccess.util.EgovMap;

import echoboard.adm.info.service.EchoboardAdmInfoVO;

public interface EchoboardAdmLoginService {
	
	/**
	 * 관리자  로그인을 처리한다
	 * @param vo LoginVO
	 * @return LoginVO
	 * @exception Exception
	 */
	public EchoboardAdmLoginVO actionLoginAdmin(EchoboardAdmLoginVO vo) throws Exception;
	
	/**
	 * 마지막 로그인 일자 업데이트
	 * @param vo
	 * @throws Exception
	 */
	void updateLastLoginDate(EchoboardAdmLoginVO vo) throws Exception;
	
	/**
	 * 로그인 실패 카운트
	 * @param vo
	 * @throws Exception
	 */
	void updateLoginFailCnt(EchoboardAdmLoginVO vo) throws Exception;
	
	/**
	 * 관리자 메뉴
	 * @param vo
	 * @throws Exception
	 */
	List<EgovMap> selectAdmMenuList(EchoboardAdmInfoVO vo) throws Exception;
}