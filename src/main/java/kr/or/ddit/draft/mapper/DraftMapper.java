package kr.or.ddit.draft.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.or.ddit.draft.vo.DraftOpnVO;
import kr.or.ddit.draft.vo.DraftUserVO;
import kr.or.ddit.draft.vo.DraftVO;

public interface DraftMapper {
	/**
	 * 사용자 한명의 기안을 올리기 위한 정보를 조회하는 메소드
	 * @param userId 조회할 유저의 아이디
	 * @return 유저 정보 + 휴가 정보
	 */
	DraftUserVO selectDraftUsesrInfo(String userId) throws Exception;
	
	/**
	 * 기안 테이블에 기안 정보를 등록
	 * @param draftVO  기안 정보
	 * @return 등록에 성공한 행 수
	 */
	int draftInsert(DraftVO draftVO) throws Exception;
	
	/**
	 * 기안 의견 테이블에 기안 정보와 의견을 등록
	 * @param draftVO
	 * @return 등록에 성공한 행 수
	 */
	int draftOpnInsert(DraftVO draftVO) throws Exception;
	
	/**
	 * 휴가문서 기안 시 휴가 테이블에 해당 휴가 사용 이력 등록
	 * @param draftVO 연결된 기안번호와 휴가사용 이력
	 * @return 등록에 성공한 행 수
	 */
	int draftVacInsert(DraftVO draftVO) throws Exception;
	
	/**
	 * 기안 시 첨부파일 테이블에 첨부파일 등록
	 * @param draftVO 연결된 기안번호와 첨부파일 내용
	 * @return 등록에 성공한 행 수
	 */
	int draftAtchInsert(DraftVO draftVO) throws Exception;
	
	/**
	 * 기안 시 결재선 테이블에 결재선 등록
	 * @param draftVO 결재자, 수신자, 회람자 등의 결재선 정보
	 * @return 등록에 성공한 행 수
	 */
	int draftAtrzInsert(DraftVO draftVO) throws Exception;
	
	/**
	 * 임시/ 완료/ 진행중 등 나의 기안상태에 따른 기안문서 리스트 조회
	 * @param userId 나 자신
	 * @param drSttsCd 기안 상태코드
	 * @return
	 */
	List<DraftVO> draftMySelectList(@Param("userId")String userId, @Param("drSttsCd")String drSttsCd);
	
	/**
	 * 기안문서 상세 조회
	 * @param drNo 기안 문서 번호
	 * @return 기안문서
	 */
	DraftVO draftSelect(@Param("drNo")int drNo);
	
	int draftLogicalDel(DraftVO draftVO);
	
	List<DraftVO> mydraftAtrzList(String userId);
	
	
	
	/**
	 * 결재자의 승인 또는 반려와 같은 상태를 업데이트
	 * @param draftVO 결재자ID, 기안번호, 변경할 결재자 상태
	 * @return 1 업데이트 성공, 0 업데이트 실패
	 */
	int updateAtrzStts(DraftVO draftVO) throws Exception;
	
	int updateDraftStts(DraftVO draftVO) throws Exception;

}
