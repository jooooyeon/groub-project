package kr.or.ddit.admin.code.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.admin.code.mapper.CodeMapper;
import kr.or.ddit.admin.code.service.CodeService;
import kr.or.ddit.admin.code.vo.CstCdVO;
import kr.or.ddit.admin.code.vo.GrCdVO;
import kr.or.ddit.admin.code.vo.MngCdVO;

@Service
public class CodeServiceImpl implements CodeService{

	@Autowired
	CodeMapper codeMapper;


	@Override
	public List<GrCdVO> groupCodeList() {
		return codeMapper.groupCodeList();
	}

	@Override
	public List<MngCdVO> manageCodeList() {
		return codeMapper.manageCodeList();
	}

	@Override
	public List<MngCdVO> manageCodeName() {
		return codeMapper.manageCodeName();
	}

	@Override
	public List<CstCdVO> customeCodeList(String coId) {
		return codeMapper.customeCodeList(coId);
	}

	@Override
	public List<CstCdVO> customeCodeName(String coId) {
		return codeMapper.customeCodeName(coId);
	}

	@Override
	public String maxCstCd(String grCd, String coId) {
		return codeMapper.maxCstCd(grCd, coId);
	}

	@Override
	public int createCsdCd(CstCdVO cstCdVO) {
		return codeMapper.createCsdCd(cstCdVO);
	}

	@Override
	public int codeAct(String cstCd) {
		return codeMapper.codeAct(cstCd);
	}



}
