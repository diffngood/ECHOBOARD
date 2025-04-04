package egovframework.com.cmm;

import org.egovframe.rte.ptl.mvc.tags.ui.pagination.AbstractPaginationRenderer;

import javax.servlet.ServletContext;

import org.springframework.web.context.ServletContextAware;
/**
 * ImagePaginationRenderer.java 클래스
 *
 * @author 서준식
 * @since 2011. 9. 16.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *  수정일              수정자                      수정내용
 *  ----------  -------------    ----------------------
 *  2011.09.16  서준식                      이미지 경로에 ContextPath추가
 *  2021.08.12  신용호                      신규 디자인 적용
 *  
 * </pre>
 */
public class RenewPaginationRenderer extends AbstractPaginationRenderer implements ServletContextAware{

	private ServletContext servletContext;

	public RenewPaginationRenderer() {
		// no-op
	}

	public void initVariables(){
        firstPageLabel    = "<a href=\"?pageIndex={1}\" onclick=\"{0}({1});return false; \" class=\"btn_first\">처음</a>";
        previousPageLabel = "<a href=\"?pageIndex={1}\" onclick=\"{0}({1});return false; \" class=\"btn_prev\">이전</a>";
        currentPageLabel  = "<a href=\"javascript:void(0);\" class=\"current\">{0}</a>";
        otherPageLabel    = "<a href=\"?pageIndex={1}\" onclick=\"{0}({1});return false; \">{2}</a>";
        nextPageLabel     = "<a href=\"?pageIndex={1}\" onclick=\"{0}({1});return false; \" class=\"btn_next\">다음</a>";
        lastPageLabel     = "<a href=\"?pageIndex={1}\" onclick=\"{0}({1});return false; \" class=\"btn_last\">마지막</a>";
	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
		initVariables();
	}

}
