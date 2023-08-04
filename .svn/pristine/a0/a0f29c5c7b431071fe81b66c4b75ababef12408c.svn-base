package kr.or.ddit.notice.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.bbscommon.BbsAtchVO;
import kr.or.ddit.notice.mapper.NoticeMapper;
import kr.or.ddit.notice.service.NoticeService;
import kr.or.ddit.notice.vo.NoticeVO;
import kr.or.ddit.notice.vo.PstHdVO;
import kr.or.ddit.util.CommonFile;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class NoticeServiceImpl implements NoticeService {

	@Inject
	NoticeMapper noticeMapper;

	//목록
	@Override
	public List<NoticeVO> list() {
		return this.noticeMapper.list();
	}

	//상세보기
	@Override
	public NoticeVO detail(NoticeVO noticeVO) {
		return this.noticeMapper.detail(noticeVO);
	}

	//조회수 가져오기
	@Override
	public int inqCnt(int pstNo) {
		return this.noticeMapper.inqCnt(pstNo);
	}
	
	//머릿말가져오기
	@Override
	public List<PstHdVO> getHd(PstHdVO hd) {
		return this.noticeMapper.getHd(hd);
	}
	
	//등록
	@Override
	public int register(NoticeVO noticeVO) {
		int result = this.noticeMapper.register(noticeVO);
		
		//첨부파일 시작====================================================
		MultipartFile[] multipartFiles = noticeVO.getAttachFiles();
		
		//연월일 폴더 생성
		File savePath = new File(CommonFile.uploadFolderBbs, CommonFile.getFolder());
		if(savePath.exists()==false) {
			savePath.mkdirs();
		}
		
		List<BbsAtchVO> bbsAtchVO = new ArrayList<BbsAtchVO>();
		//BBS_ATCH테이블의 기본키 데이터 + 1
		int seq = this.noticeMapper.getNextBbsFlNo();
		for(MultipartFile file : multipartFiles) {
			BbsAtchVO vo = new BbsAtchVO();
			
			vo.setBbsFlNo(seq++);
			vo.setFileNm(file.getOriginalFilename());
			UUID uuid = UUID.randomUUID(); 
			vo.setFileUuid(uuid.toString()+"_"+file.getOriginalFilename());
			vo.setFilePath("/" + CommonFile.getFolder().replace("\\", "/") + "/" + uuid.toString()+"_"+file.getOriginalFilename());
			vo.setFileExtn(file.getContentType());
			vo.setFileSize(file.getSize());
			vo.setPstNo(noticeVO.getPstNo());
			
			bbsAtchVO.add(vo);
			
			String path = CommonFile.uploadFolderBbs + "/" + CommonFile.getFolder().replace("\\", "/") + "/" + uuid.toString() + "_" + file.getOriginalFilename();
			log.info("path : " + path);
			
			File f = new File(path);
			
			try {
				file.transferTo(f);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
			
		}
		log.info("bbsAtchVO.get(0).getFileNm().length()" + bbsAtchVO.get(0).getFileNm().length());
		
		if(bbsAtchVO.get(0).getFileNm().length()>0) {
			noticeVO.setBbsAtchVO(bbsAtchVO);
			
			log.info("noticeVO : " + noticeVO);		
			
			result += this.noticeMapper.insertAttachFiles(bbsAtchVO);
			
		}
		//첨부파일 끝====================================================

		return result;
	}
	
	//수정
	@Override
	public int update(NoticeVO noticeVO) {
		int result = this.noticeMapper.update(noticeVO);
		
		//첨부파일 시작====================================================
		MultipartFile[] multipartFiles = noticeVO.getAttachFiles();
		
		//연월일 폴더 생성
		File savePath = new File(CommonFile.uploadFolderBbs, CommonFile.getFolder());
		if(savePath.exists()==false) {
			savePath.mkdirs();
		}
		
		List<BbsAtchVO> bbsAtchVO = new ArrayList<BbsAtchVO>();
		//BBS_ATCH테이블의 기본키 데이터 + 1
		int seq = this.noticeMapper.getNextBbsFlNo();
		for(MultipartFile file : multipartFiles) {
			BbsAtchVO vo = new BbsAtchVO();
			
			vo.setBbsFlNo(seq++);
			vo.setFileNm(file.getOriginalFilename());
			UUID uuid = UUID.randomUUID(); 
			vo.setFileUuid(uuid.toString()+"_"+file.getOriginalFilename());
			vo.setFilePath("/" + CommonFile.getFolder().replace("\\", "/") + "/" + uuid.toString()+"_"+file.getOriginalFilename());
			vo.setFileExtn(file.getContentType());
			vo.setFileSize(file.getSize());
			vo.setPstNo(noticeVO.getPstNo());
			
			
			bbsAtchVO.add(vo);
			
			String path = CommonFile.uploadFolderBbs + "/" + CommonFile.getFolder().replace("\\", "/") + "/" + uuid.toString() + "_" + file.getOriginalFilename();
			log.info("path : " + path);
			
			File f = new File(path);
			
			try {
				file.transferTo(f);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
			
		}
		log.info("bbsAtchVO.get(0).getFileNm().length()" + bbsAtchVO.get(0).getFileNm().length());
		
		if(bbsAtchVO.get(0).getFileNm().length()>0) {
			noticeVO.setBbsAtchVO(bbsAtchVO);

			log.info("noticeVO : " + noticeVO);
			

			result += this.noticeMapper.insertAttachFiles(bbsAtchVO);
			
		}
		//첨부파일 끝====================================================
		this.noticeMapper.updateFileExistDel(bbsAtchVO.get(0));
		
		return result;
	}
	
	// /board/update에서 파일업로드 상태 변경(N)
	@Override
	public int updateFileExist(BbsAtchVO bbsAtchVO) {
		return this.noticeMapper.updateFileExist(bbsAtchVO);
	}
	
	// /board/update에서 파일업로드 상태 변경(All Y)
	@Override
	public int updateFileExistCancel(BbsAtchVO bbsAtchVO) {
		return this.noticeMapper.updateFileExistCancel(bbsAtchVO);
	}
	
	// /board/update에서 N인것 DEL
	@Override
	public int updateFileExistDel(BbsAtchVO bbsAtchVO) {
		return this.noticeMapper.updateFileExistDel(bbsAtchVO);
	}
	
	//삭제
	public int delete(NoticeVO noticeVO) {
		return this.noticeMapper.delete(noticeVO);
	}

	//메인페이지 리스트
	@Override
	public List<NoticeVO> selectMainPageList() {
		return this.noticeMapper.selectMainPageList();
	}
	

}




