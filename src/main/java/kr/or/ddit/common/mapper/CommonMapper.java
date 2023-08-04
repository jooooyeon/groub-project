package kr.or.ddit.common.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;


public interface CommonMapper {
	public List<Map<String, String>> selectMngCdList(String grCd);

	public List<Map<String, String>> selectDeptNoList(String coId);

	public List<Map<String, String>> selectCstCdList(@Param("grCd") String grCd, @Param("coId") String coId);
}
