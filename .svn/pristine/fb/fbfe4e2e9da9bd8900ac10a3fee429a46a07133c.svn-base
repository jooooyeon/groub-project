package kr.or.ddit.admin.code.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.or.ddit.admin.code.vo.CstCdVO;
import kr.or.ddit.admin.code.vo.GrCdVO;
import kr.or.ddit.admin.code.vo.MngCdVO;

public interface CodeMapper {

	public List<GrCdVO> groupCodeList();

	public List<MngCdVO> manageCodeList();

	public List<MngCdVO> manageCodeName();

	public List<CstCdVO> customeCodeList(String coId);

	public List<CstCdVO> customeCodeName(String coId);

	public String maxCstCd(@Param("grCd") String grCd, @Param("coId") String coId);

	public int createCsdCd(CstCdVO cstCdVO);

	public int codeAct(String cstCd);
}
