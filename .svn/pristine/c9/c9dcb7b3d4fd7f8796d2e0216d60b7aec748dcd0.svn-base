package kr.or.ddit.draft.service;

import java.util.List;

import kr.or.ddit.draft.vo.DraftUserVO;
import kr.or.ddit.draft.vo.DraftVO;

public interface DraftService {

	/**
	 * 사용자 한명의 기안을 올리기 위한 정보를 조회하는 메소드
	 * @param userId 조회할 유저의 아이디
	 * @return 유저 정보 + 휴가 정보
	 */
	DraftUserVO selectDraftUsesrInfo(String userId) throws Exception;

	/**
	 * 기안을 등록하기 위한 메소드  기안서/ 결재선/ 의견/ 첨부파일 등의 정보를 저장함
	 * @param draftVO 저장할 기안 문서의 정보
	 * @return 저장된 행의 수
	 * @throws Exception 트랜젝션을 위한 Exception
	 */
	int draftInsert(DraftVO draftVO) throws Exception;

	/**
	 * 임시/ 완료/ 진행중 등 기안상태에 따른 기안문서 리스트 조회
	 * @param userId 사용자
	 * @param drSttsCd 기안 상태코드
	 * @return
	 */
	List<DraftVO> draftMySelectList(String userId, String drSttsCd);
	
	/**
	 * 기안문서 상세 조회
	 * @param userId 기안 작성자
	 * @return 기안문서
	 */
	DraftVO draftSelect(int drNo);

	List<DraftVO> mydraftAtrzList(String userId);

	int draftAtrzUpdate(DraftVO draftVO) throws Exception;
	

}
