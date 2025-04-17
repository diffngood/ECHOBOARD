package egovframework.com.cmm.interceptor;

import java.net.URLEncoder;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.egovframe.rte.psl.dataaccess.util.EgovMap;
import org.springframework.web.servlet.mvc.WebContentInterceptor;

import echoboard.adm.info.service.EchoboardAdmInfoVO;
import echoboard.adm.login.service.EchoboardAdmLoginService;
import echoboard.adm.login.service.EchoboardAdmLoginVO;
import echoboard.usr.com.EchoboardUsrDetailsHelper;
import echoboard.usr.login.service.EchoboardUserLoginVO;

/**
 * 인증여부 체크 인터셉터
 * @author 공통서비스 개발팀 서준식
 * @since 2011.07.01
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일      수정자          수정내용
 *  -------    --------    ---------------------------
 *  2011.07.01  서준식          최초 생성
 *  2011.09.07  서준식          인증이 필요없는 URL을 패스하는 로직 추가
 *  2014.06.11  이기하          인증이 필요없는 URL을 패스하는 로직 삭제(xml로 대체)
 *  </pre>
 */

public class AuthenticInterceptor extends WebContentInterceptor {
	
	private String siteType;
	private String siteLang;

	public void setSiteType(String siteType) {
		this.siteType = siteType;
	}
	
	public void setSiteLang(String siteLang) {
		this.siteLang = siteLang;
	}
	
	@Resource(name="admLoginService")
	EchoboardAdmLoginService admLoginService;

	/**
	 * 세션에 계정정보(LoginVO)가 있는지 여부로 인증 여부를 체크한다.
	 * 계정정보(LoginVO)가 없다면, 로그인 페이지로 이동한다.
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException {

		/*
		 * LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
		 * 
		 * if (loginVO.getId() != null) { return true; } else { ModelAndView
		 * modelAndView = new ModelAndView("redirect:/uat/uia/egovLoginUsr.do"); throw
		 * new ModelAndViewDefiningException(modelAndView); }
		 */
		if("adm".equals(siteType)) {
			try {
				checkAdminAuth(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if("user".equals(siteType)) {
			try {
				checkUserAuth(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			return false;
		}

		return true;
	}
	
	// 관리자 권한 체크
	private boolean checkAdminAuth(HttpServletRequest request, HttpServletResponse response) throws Exception{
		// 요청 URI
		String requestURI = request.getRequestURI();
		//context root path 가져오기
		String requestContextPath = request.getContextPath();
		//request mapping URL 데이터 골라내기
		String mapURL = requestURI.substring(requestContextPath.length());
		
		EchoboardAdmLoginVO sessionVO = (EchoboardAdmLoginVO) EchoboardUsrDetailsHelper.getAdminAuthenticatedUser();
		if(sessionVO != null) {
			EchoboardAdmInfoVO adminVO = new EchoboardAdmInfoVO();
			adminVO.setAdmIdx(sessionVO.getAdmIdx());
			adminVO.setParentMenuIdx("0");
			
			List<EgovMap> menuList = admLoginService.selectAdmMenuList(adminVO);
			
			for(int i=0; i<menuList.size(); i++) {
				adminVO.setParentMenuIdx(menuList.get(i).get("menuIdx")+"");
				List<EgovMap> menuDepth2 = admLoginService.selectAdmMenuList(adminVO);
				
				for(int j=0; j<menuDepth2.size(); j++) {
					adminVO.setParentMenuIdx(menuDepth2.get(j).get("menuIdx")+"");
					List<EgovMap> menuDepth3 = admLoginService.selectAdmMenuList(adminVO);
					menuDepth2.get(j).put("menuDepth3", menuDepth3);
				}
				
				menuList.get(i).put("menuDepth2", menuDepth2);
			}
			request.setAttribute("leftMenuList", menuList);
			
			return true;
			
		} else {
	        String redirectUrl = requestContextPath + "/adm/login.do?returnUrl=" 
	                + URLEncoder.encode(requestURI + (request.getQueryString() != null ? "?" + request.getQueryString() : ""), "UTF-8");
	        response.sendRedirect(redirectUrl);
	        return false;
		}
	}
	
	// 사용자 권한 체크
	private boolean checkUserAuth(HttpServletRequest request, HttpServletResponse response) throws Exception{
		// 요청 URI
		String requestURI = request.getRequestURI();
		//context root path 가져오기
		String requestContextPath = request.getContextPath();
		//request mapping URL 데이터 골라내기
		String mapURL = requestURI.substring(requestContextPath.length());
		
		EchoboardUserLoginVO sessionVO = (EchoboardUserLoginVO) EchoboardUsrDetailsHelper.getAuthenticatedUser();
		
		if(sessionVO != null) {
			return true;
		} else {
			// 로그인 세션이 없으면 로그인 페이지로 리다이렉트
	        String redirectUrl = requestContextPath + "/eb/login.do?returnUrl=" 
	                + URLEncoder.encode(requestURI + (request.getQueryString() != null ? "?" + request.getQueryString() : ""), "UTF-8");
	        response.sendRedirect(redirectUrl);
	        return false;
		}
	}

}
