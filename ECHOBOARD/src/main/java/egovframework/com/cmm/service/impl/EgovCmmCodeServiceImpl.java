package egovframework.com.cmm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.egovframe.rte.psl.dataaccess.util.EgovMap;
import org.springframework.stereotype.Service;

import egovframework.com.cmm.ComCodeVO;
import egovframework.com.cmm.service.EgovCmmCodeService;

@Service("cmmCodeService")
public class EgovCmmCodeServiceImpl extends EgovAbstractServiceImpl implements EgovCmmCodeService {

    @Resource(name = "cmmCodeDAO")
    private EgovCmmCodeDAO cmmCodeDAO;

    /**
     * 공통코드를 조회한다.
     *
     * @param vo
     * @return
     * @throws Exception
     */
    @Override
	public List<EgovMap> selectCodeList(ComCodeVO vo) throws Exception {
    	return cmmCodeDAO.selectCodeList(vo);
    }
    
   
}
