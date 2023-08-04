package kr.or.ddit.admin.code.service;

import java.util.List;


import kr.or.ddit.admin.code.vo.CstCdVO;
import kr.or.ddit.admin.code.vo.GrCdVO;
import kr.or.ddit.admin.code.vo.MngCdVO;

public interface CodeService {
	/**
	 * 공통코드 목록
	 */
	public List<GrCdVO> groupCodeList();

	/**
	 * 공통상세코드 목록
	 */
	public List<MngCdVO> manageCodeList();

	/**
	 * 공통코드 목록 명칭
	 */
	public List<MngCdVO> manageCodeName();

	/**
	 * 사용자코드 목록
	 */
	public List<CstCdVO> customeCodeList(String coId);

	/**
	 * 사용자코드 명칭
	 */
	public List<CstCdVO> customeCodeName(String coId);

	public String maxCstCd(String grCd, String coId);

	/**
	 * 사용자 상세 코드 추가
	 */
	public int createCsdCd(CstCdVO cstCdVO);

	public int codeAct(String cstCd);

}
