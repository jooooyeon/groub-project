package kr.or.ddit.community.board.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.bbscommon.BbsAtchVO;
import kr.or.ddit.community.board.mapper.BoardMapper;
import kr.or.ddit.community.board.service.BoardService;
import kr.or.ddit.community.board.vo.BoardVO;
import kr.or.ddit.community.board.vo.CmntVO;
import kr.or.ddit.community.board.vo.PstHdVO;
import kr.or.ddit.util.CommonFile;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BoardServiceImpl implements BoardService {
	
	@Inject
	BoardMapper boardMapper;
	
	//리스트
	@Override
	public List<BoardVO> list(){
		return this.boardMapper.list();
	}

	//상세내역
	@Override
	public BoardVO detail(BoardVO boardVO) {
		return this.boardMapper.detail(boardVO);
	}
	

	//등록
	@Override
	public int register(BoardVO boardVO) {
		int result = this.boardMapper.register(boardVO);
		
		//첨부파일 시작====================================================
		MultipartFile[] multipartFiles = boardVO.getAttachFiles();
		
		//연월일 폴더 생성
		File savePath = new File(CommonFile.uploadFolderBbs, CommonFile.getFolder());
		if(savePath.exists()==false) {
			savePath.mkdirs();
		}
		
		List<BbsAtchVO> bbsAtchVO = new ArrayList<BbsAtchVO>();
		//BBS_ATCH테이블의 기본키 데이터 + 1
		int seq = this.boardMapper.getNextBbsFlNo();
		for(MultipartFile file : multipartFiles) {
			BbsAtchVO vo = new BbsAtchVO();
			
			vo.setBbsFlNo(seq++);
			vo.setFileNm(file.getOriginalFilename());
			UUID uuid = UUID.randomUUID(); 
			vo.setFileUuid(uuid.toString()+"_"+file.getOriginalFilename());
			vo.setFilePath("/" + CommonFile.getFolder().replace("\\", "/") + "/" + uuid.toString()+"_"+file.getOriginalFilename());
			vo.setFileExtn(file.getContentType());
			vo.setFileSize(file.getSize());
			vo.setPstNo(boardVO.getPstNo());
			
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
			boardVO.setBbsAtchVO(bbsAtchVO);
			//BoardVO(pstNo=39, userId=null, coId=null, delrNm=null, mdfrNm=null, pstHd=HE, pstTtl=연습!2
			//, pstCn=<p>33</p>, regDt=null, mdfcnDt=null, inqCnt=0, bbsClsf=null, tempYn=null, delYn=null
			//, delDt=null, attachFiles=[org.springframework.web.multipart.support.StandardMultipartHttpServletRequest$StandardMultipartFile@3c675c3f]
			//, bbsAtchVO=[BbsAtchVO(bbsFlNo=1, fileNm=1111.jpg, fileUuid=81396d07-b5be-4481-aa71-6a44eab4027a_1111.jpg
			//, filePath=/2023/06/27/81396d07-b5be-4481-aa71-6a44eab4027a_1111.jpg, fileExtn=image/jpeg
			//, fileSize=1747209, pstNo=39)])
			log.info("boardVO : " + boardVO);
			
//			int counter = 1;
//			List<BbsAtchVO> list = boardVO.getBbsAtchVO();
//			for(BbsAtchVO vo : list) {
//				vo.setBbsFlNo(counter++);
//			}
			
			result += this.boardMapper.insertAttachFiles(bbsAtchVO);
			
		}
		//첨부파일 끝====================================================

		return result;
	}
	
	//머릿말가져오기
	@Override
	public List<PstHdVO> getHd(PstHdVO hd) {
		return this.boardMapper.getHd(hd);
	}

	//조회수 가져오기
	@Override
	public int inqCnt(int pstNo) {
		return this.boardMapper.inqCnt(pstNo);
	}
	
	
	//수정하기
	@Override
	public int update(BoardVO boardVO) {
		int result = this.boardMapper.update(boardVO);
		
		//첨부파일 시작====================================================
		MultipartFile[] multipartFiles = boardVO.getAttachFiles();
		
		//연월일 폴더 생성
		File savePath = new File(CommonFile.uploadFolderBbs, CommonFile.getFolder());
		if(savePath.exists()==false) {
			savePath.mkdirs();
		}
		
		List<BbsAtchVO> bbsAtchVO = new ArrayList<BbsAtchVO>();
		//BBS_ATCH테이블의 기본키 데이터 + 1
		int seq = this.boardMapper.getNextBbsFlNo();
		for(MultipartFile file : multipartFiles) {
			BbsAtchVO vo = new BbsAtchVO();
			
			vo.setBbsFlNo(seq++);
			vo.setFileNm(file.getOriginalFilename());
			UUID uuid = UUID.randomUUID(); 
			vo.setFileUuid(uuid.toString()+"_"+file.getOriginalFilename());
			vo.setFilePath("/" + CommonFile.getFolder().replace("\\", "/") + "/" + uuid.toString()+"_"+file.getOriginalFilename());
			vo.setFileExtn(file.getContentType());
			vo.setFileSize(file.getSize());
			vo.setPstNo(boardVO.getPstNo());
			
			
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
			boardVO.setBbsAtchVO(bbsAtchVO);
			//BoardVO(pstNo=39, userId=null, coId=null, delrNm=null, mdfrNm=null, pstHd=HE, pstTtl=연습!2
			//, pstCn=<p>33</p>, regDs=null, mdfcnDt=null, inqCnt=0, bbsClsf=null, tempYn=null, delYn=null
			//, delDt=null, attachFiles=[org.springframework.web.multipart.support.StandardMultipartHttpServletRequest$StandardMultipartFile@3c675c3f]
			//, bbsAtchVO=[BbsAtchVO(bbsFlNo=1, fileNm=1111.jpg, fileUuid=81396d07-b5be-4481-aa71-6a44eab4027a_1111.jpg
			//, filePath=/2023/06/27/81396d07-b5be-4481-aa71-6a44eab4027a_1111.jpg, fileExtn=image/jpeg
			//, fileSize=1747209, pstNo=39)])
			log.info("boardVO : " + boardVO);
			
//			int counter = 1;
//			List<BbsAtchVO> list = boardVO.getBbsAtchVO();
//			for(BbsAtchVO vo : list) {
//				vo.setBbsFlNo(counter++);
//			}
			
			result += this.boardMapper.insertAttachFiles(bbsAtchVO);
			
		}
		//첨부파일 끝====================================================
		this.boardMapper.updateFileExistDel(bbsAtchVO.get(0));
		
		return result;
	}

	@Override
	public int deletePost(BoardVO boardVO) {
		return this.boardMapper.deletePost(boardVO);
	}

	// /board/update에서 파일업로드 상태 변경(N)
	@Override
	public int updateFileExist(BbsAtchVO bbsAtchVO) {
		return this.boardMapper.updateFileExist(bbsAtchVO);
	}
	
	// /board/update에서 파일업로드 상태 변경(All Y)
	@Override
	public int updateFileExistCancel(BbsAtchVO bbsAtchVO) {
		return this.boardMapper.updateFileExistCancel(bbsAtchVO);
	}
	
	// /board/update에서 N인것 DEL
	@Override
	public int updateFileExistDel(BbsAtchVO bbsAtchVO) {
		return this.boardMapper.updateFileExistDel(bbsAtchVO);
	}
	
	//댓글 등록하기
	@Override
	public int commentRegister(CmntVO cmntVO) {
		return this.boardMapper.commentRegister(cmntVO);
	}
	
	//댓글 가져오기
	@Override
	public List<CmntVO> commentSelect(CmntVO cmntvo){
		return this.boardMapper.commentSelect(cmntvo);
	}
	
	//대댓글 작성하기
	@Override
	public int commentInCommentRegister(CmntVO cmntVO) {
		return this.boardMapper.commentInCommentRegister(cmntVO);
	}
	
	//댓글 삭제하기
	@Override
	public int deleteComment(CmntVO cmntVO) {
		return this.boardMapper.deleteComment(cmntVO);
	}

	//댓글 수정하기
	@Override
	public int commentModify(CmntVO cmntVO) {
		return this.boardMapper.commentModify(cmntVO);
	}
	
}
