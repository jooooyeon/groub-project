package kr.or.ddit.common.service.impl;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.common.mapper.CommonMapper;
import kr.or.ddit.common.service.CommonService;

@Service
public class CommonServiceImpl implements CommonService {

	@Inject
	CommonMapper commonMapper;

	@Override
	public List<Map<String, String>> selectMngCdList(String grCd) {
		return commonMapper.selectMngCdList(grCd);
	}

	@Override
	public List<Map<String, String>> selectDeptNoList(String coId) {
		return commonMapper.selectDeptNoList(coId);
	}

	@Override
	public List<Map<String, String>> selectCstCdList(String grCd, String coId) {
		return commonMapper.selectCstCdList(grCd, coId);
	};

}
