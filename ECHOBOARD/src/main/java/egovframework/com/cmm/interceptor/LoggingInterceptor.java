package egovframework.com.cmm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


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
 *  </pre>
 */

public class LoggingInterceptor extends HandlerInterceptorAdapter {
	
	private String logType;

	public void setLogType(String logType) {
		this.logType = logType;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		switch (logType) {
		case "userLog":
			insertUserLog(request);
			break;
		case "admLog":
			insertAdmLog(request);
			break;
		default:
			break;
		}
	}
	
	public void insertUserLog(HttpServletRequest request) throws Exception {
		// 메뉴관리 작업 후 로그 개발
	}
	
	public void insertAdmLog(HttpServletRequest request) throws Exception {
		// 메뉴관리 작업 후 로그 개발
	}
	
}