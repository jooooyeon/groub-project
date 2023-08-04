package kr.or.ddit.draft.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.draft.mapper.DraftMapper;
import kr.or.ddit.draft.service.DraftService;
import kr.or.ddit.draft.vo.DraftAttachVO;
import kr.or.ddit.draft.vo.DraftOpnVO;
import kr.or.ddit.draft.vo.DraftUserVO;
import kr.or.ddit.draft.vo.DraftVO;
import kr.or.ddit.mail.vo.MailAtchVO;
import kr.or.ddit.util.CommonFile;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DarftServiceImpl implements DraftService {
	
	@Inject
	DraftMapper draftMapper;
	
	/**
	 * 사용자 한명의 기안을 올리기 위한 정보를 조회하는 메소드
	 * @param userId 조회할 유저의 아이디
	 * @return 유저 정보 + 휴가 정보
	 */
	@Override
	public DraftUserVO selectDraftUsesrInfo(String userId) throws Exception {
		return draftMapper.selectDraftUsesrInfo(userId);
	}
	
	/**
	 * 기안시 연계된 테이블에 기안내용 인서트
	 */
	@Override
	public int draftInsert(DraftVO draftVO) throws Exception {
		int result = 0;
		// 임시 기안 문서일 경우 update 진행
		if(draftVO.getDrSttsCdTemp() != null && draftVO.getDrSttsCdTemp().equals("DF001")) {
			result += draftMapper.draftLogicalDel(draftVO);
		}
		
		//기안 테이블 인서트
		result += draftMapper.draftInsert(draftVO);
		
		// 결재선 인서트
		if(draftVO.getDraftAtrzVOList() != null) {
		result += draftMapper.draftAtrzInsert(draftVO);
		}
		//기안 의견 테이블 인서트
		if(draftVO.getDraftOpnVOList() != null) {
			result += draftMapper.draftOpnInsert(draftVO);
		}
		
		// 기안 - 휴가 인서트
//		if(draftVO.getDraftVacVO() != null) {
//			result += draftMapper.draftVacInsert(draftVO);
//		}
		
		// 기안 - 첨부파일 인서트
		MultipartFile[] files = draftVO.getAttachFiles();
		List<DraftAttachVO> DraftAttachVOList = new ArrayList<DraftAttachVO>();
		if (!files[0].isEmpty()) {
			for (MultipartFile mf : files) {
				DraftAttachVO DraftAttachVO = new DraftAttachVO();
				
				// 업로드 파일명
				String uploadFileName = "";

				String path = CommonFile.uploadFolderDraft;
				File uploadPath = new File(path, CommonFile.getFolder());
				if (uploadPath.exists() == false) {
					uploadPath.mkdirs();
				}
				
				// 파일명
				String fileNm = mf.getOriginalFilename();
				DraftAttachVO.setFileNm(fileNm);
				
				// 중복방지 uuid
				UUID uuid = UUID.randomUUID();
				DraftAttachVO.setFileUuid(uuid + "");
				uploadFileName = uuid.toString() + "_" + fileNm;

				// 설계. 저장될 폴더와 파일명
				File saveFile = new File(uploadPath, uploadFileName);

				// 저장 실행
				String fileExtn = mf.getContentType();
				
				DraftAttachVO.setFileExtn(fileExtn);
				// 파일 path
				DraftAttachVO.setFilePath("/" + CommonFile.getFolder().replace("\\", "/") + "/" + uploadFileName);
				
				DraftAttachVO.setFileSize(mf.getSize());
				
				DraftAttachVOList.add(DraftAttachVO);
				
				draftVO.setDraftAttachVOList(DraftAttachVOList);
				
				try {
					mf.transferTo(saveFile);
					// 파일 확장자

				} catch (IllegalStateException | IOException e) {
					log.error(e.getMessage());
					throw new RuntimeException(e);
				}
			}
			result += draftMapper.draftAtchInsert(draftVO);
		}
		
		return result;
	}
	
	/**
	 * 임시/ 완료/ 진행중 등 기안상태에 따른 기안문서 리스트 조회
	 * @param userId 기안 작성자
	 * @param drSttsCd 기안 상태코드
	 * @return
	 */
	@Override
	public List<DraftVO> draftMySelectList(String userId, String drSttsCd){
		return draftMapper.draftMySelectList(userId, drSttsCd);
	}
	
	/**
	 * 기안문서 상세 조회
	 * @param userId 기안 작성자
	 * @return 기안문서
	 */
	@Override
	public DraftVO draftSelect(int drNo){
		return draftMapper.draftSelect(drNo);
	}
	
	
	@Override
	public List<DraftVO> mydraftAtrzList(String userId){
		return draftMapper.mydraftAtrzList(userId);
	}
	
	@Override
	public int draftAtrzUpdate(DraftVO draftVO) throws Exception {
		int result = 0;
		// 내 결재 상태 변경
		result += draftMapper.updateAtrzStts(draftVO);
		
		// 추가 의견이 있을 경우 의견 업데이트
		if(draftVO.getDraftOpnVOList() != null) {
			result += draftMapper.draftOpnInsert(draftVO);
		}
		// 내가 등록할 결재 상태 번호
		String atrzSttsCd = draftVO.getDraftAtrzVOList().get(0).getAtrzSttsCd();
		//최종 결재 순번 번호
		int maxAtrzSn = draftVO.getDraftAtrzVOList().get(0).getMaxAtrzSn();
		// 내 결재 순번
		int atrzSn = draftVO.getDraftAtrzVOList().get(0).getAtrzSn();
		
		// 반려일 경우
		if(atrzSttsCd.equals("DS002")) {
			//기안문서의의 상태를 반려로 변환
			result += draftMapper.updateDraftStts(draftVO);
		}
		
		// 최종 결재일 경우
		if (maxAtrzSn == atrzSn && atrzSttsCd.equals("DS001")) {
			// 휴가 정보 인서트
			result += draftMapper.updateDraftStts(draftVO);
			result += draftMapper.draftVacInsert(draftVO);
		}
		return result;
	}


}
