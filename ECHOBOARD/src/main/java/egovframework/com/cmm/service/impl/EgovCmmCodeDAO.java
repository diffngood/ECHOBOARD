package egovframework.com.cmm.service.impl;

import java.util.List;

import egovframework.com.cmm.ComCodeVO;

import org.egovframe.rte.psl.dataaccess.EgovAbstractMapper;
import org.egovframe.rte.psl.dataaccess.util.EgovMap;
import org.springframework.stereotype.Repository;

@Repository("cmmCodeDAO")
public class EgovCmmCodeDAO extends EgovAbstractMapper {

    /**
     * 주어진 조건에 따른 공통코드를 불러온다.
     *
     * @param vo
     * @return
     * @throws Exception
     */
    public List<EgovMap> selectCodeList(ComCodeVO vo) throws Exception {
    	return selectList("cmmCodeDAO.selectCodeList", vo);
    }
    
}
