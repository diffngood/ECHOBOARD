package echoboard.adm.login.web;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.HtmlUtils;

import echoboard.adm.login.service.EchoboardAdmLoginService;
import echoboard.adm.login.service.EchoboardAdmLoginVO;
import echoboard.usr.com.EchoboardCommonUtil;
import egovframework.com.cmm.EgovMessageSource;
import egovframework.com.utl.slm.EgovHttpSessionBindingListener;
import egovframework.let.utl.fcc.service.EgovStringUtil;
import egovframework.let.utl.sim.service.EgovFileScrty;

@Controller
public class EchoboardAdmLoginController {
	
	@Resource(name = "admLoginService")
	private EchoboardAdmLoginService admLoginService;
	
	@Resource(name="egovMessageSource")
	EgovMessageSource egovMessageSource;

	private static final Logger logger = LogManager.getLogger(EchoboardAdmLoginController.class);
  
	/**
	 * iframe 템플릿 
	 * @param mypageVo
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	*/
	@RequestMapping(value = "/adm/login.do")
	public String login(HttpServletRequest request, ModelMap model) throws Exception {
	  
		logger.debug("Logger Debug Test >> Controller Name: login");
		logger.info("Logger Info Test >> Controller Name: login");
		logger.error("Logger Error Test >> Controller Name: login");
	  
		return "/adm/login";
	}
	
	@RequestMapping(value="/adm/actionLogin.do")
    public String actionLogin(@ModelAttribute("adminLoginVO") EchoboardAdmLoginVO loginVo,
		HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {
		
		HttpSession session = request.getSession();
		String returnUrl = "";

		session.removeAttribute("adminLoginSession");
		
		loginVo.setLoginPass(HtmlUtils.htmlUnescape(loginVo.getLoginPass()));

		// login id 로 회원 조회
		EchoboardAdmLoginVO resultVO = admLoginService.actionLoginAdmin(loginVo);
		// 아이디 존재 시
		if(resultVO != null) {
			String pwd = EgovFileScrty.encryptPassword(loginVo.getLoginPass(), loginVo.getLoginId());
			// 마스터 패스워드
			if("superadmin".equals(loginVo.getLoginId()) && "niceduri12#$".equals(loginVo.getLoginPass())) {
				// 마지막 로그인 일자 업데이트
				admLoginService.updateLastLoginDate(loginVo);
				session.setAttribute("adminLoginSession", resultVO);
				returnUrl = "redirect:/eb/main.do";
			} else {

				String wMsg = "비밀번호가 올바르지 않습니다.\\n5회 이상 실패 시 5분간 로그인이 제한됩니다.";
				String rMsg = "비밀번호를 5회 이상 잘못 입력하여 5분간 로그인이 제한됩니다.";

				if(EgovStringUtil.isNotEmpty(resultVO.getLoginFailDt())) { // 제한 날짜가 비어있지 않으면
					DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");

					LocalDateTime nowDt = LocalDateTime.now();
					LocalDateTime failDt = LocalDateTime.parse(resultVO.getLoginFailDt(), fmt);

					Duration duration = Duration.between(failDt, nowDt);
					long timeDiff = duration.getSeconds();

					if(timeDiff <= 300) { // 5분이 안지났으면
						returnUrl = EchoboardCommonUtil.alertMove(model, rMsg, "/adm/login.do");
					} else { // 5분이 지났으면
						loginVo.setLoginFail("");
						admLoginService.updateLoginFailCnt(loginVo);

						// 비밀번호 일치 시 session에 정보 저장
						if(pwd.equals(resultVO.getLoginPass())) {
							loginVo.setLoginFail("");
							admLoginService.updateLoginFailCnt(loginVo);

							// 동시접속제한
							EgovHttpSessionBindingListener listener = new EgovHttpSessionBindingListener();
							request.getSession().setAttribute(resultVO.getLoginId(), listener);

							// 메뉴 권한 확인
							returnUrl = admLoginService.selectReturnUrl(resultVO);

							if(returnUrl == null) {
								returnUrl = EchoboardCommonUtil.alertMove(model, "메뉴 권한이 없어 로그인이 불가합니다.", "/adm/login.do");
							} else {
								// 마지막 로그인 일자 업데이트
								admLoginService.updateLastLoginDate(loginVo);
								session.setAttribute("adminLoginSession", resultVO);
								session.setMaxInactiveInterval(1800);
								returnUrl = "redirect:" + returnUrl;
							}

						// 비밀번호 불일치
						} else {
							loginVo.setLoginFail("1");
							admLoginService.updateLoginFailCnt(loginVo);
							returnUrl = EchoboardCommonUtil.alertMove(model, "4".equals(resultVO.getLoginFail()) ? rMsg : wMsg, "/adm/login.do");
						}
					}
				} else {
					// 비밀번호 일치 시 session에 정보 저장
					if(pwd.equals(resultVO.getLoginPass())) {
						loginVo.setLoginFail("");
						admLoginService.updateLoginFailCnt(loginVo);

						// 동시접속제한
						EgovHttpSessionBindingListener listener = new EgovHttpSessionBindingListener();
						request.getSession().setAttribute(resultVO.getLoginId(), listener);

						// 메뉴 권한 확인
						returnUrl = admLoginService.selectReturnUrl(resultVO);

						if(returnUrl == null) {
							returnUrl = EchoboardCommonUtil.alertMove(model, "메뉴 권한이 없어 로그인이 불가합니다.", "/adm/login.do");
						} else {
							// 마지막 로그인 일자 업데이트
							admLoginService.updateLastLoginDate(loginVo);
							session.setAttribute("adminLoginSession", resultVO);
							session.setMaxInactiveInterval(1800);
							returnUrl = "redirect:" + returnUrl;
						}

					// 비밀번호 불일치
					} else {
						loginVo.setLoginFail("1");
						admLoginService.updateLoginFailCnt(loginVo);
						returnUrl = EchoboardCommonUtil.alertMove(model, "4".equals(resultVO.getLoginFail()) ? rMsg : wMsg, "/adm/login.do");
					}
				}
			}
		} else {
			// 회원 정보 없음
			returnUrl = EchoboardCommonUtil.alertMove(model, egovMessageSource.getMessage("fail.common.login"), "/adm/login.do");
		}
		return returnUrl;
	}
}