package egovframework.com.cmm.service;

import java.util.List;

import org.egovframe.rte.psl.dataaccess.util.EgovMap;

import egovframework.com.cmm.ComCodeVO;


public interface EgovCmmCodeService {

    /**
     * 공통코드를 조회한다.
     *
     * @param vo
     * @return List(코드)
     * @throws Exception
     */
	
    public List<EgovMap> selectCodeList(ComCodeVO vo) throws Exception;

}
