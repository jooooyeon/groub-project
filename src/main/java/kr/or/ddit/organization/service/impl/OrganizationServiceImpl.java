package kr.or.ddit.organization.service.impl;

import java.util.List;
import java.util.List;
import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.organization.mapper.OrganizationMapper;
import kr.or.ddit.organization.service.OrganizationService;
import kr.or.ddit.organization.vo.OrganizationVO;

@Service
public class OrganizationServiceImpl implements OrganizationService {
	
	@Inject
	OrganizationMapper organizationMapper;
	
	@Override
	public List<OrganizationVO> list(String coId){
		return this.organizationMapper.list(coId);
	}
	
	
	

}
