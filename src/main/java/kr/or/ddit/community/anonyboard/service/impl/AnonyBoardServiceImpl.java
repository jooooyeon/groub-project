package kr.or.ddit.community.anonyboard.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.bbscommon.BbsAtchVO;
import kr.or.ddit.community.anonyboard.mapper.AnonyBoardMapper;
import kr.or.ddit.community.anonyboard.service.AnonyBoardService;
import kr.or.ddit.community.anonyboard.vo.AnonyBoardVO;
import kr.or.ddit.community.anonyboard.vo.AnonyCmntVO;
import kr.or.ddit.community.anonyboard.vo.AnonyPstHdVO;
import kr.or.ddit.util.CommonFile;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AnonyBoardServiceImpl implements AnonyBoardService {
	
	@Inject
	AnonyBoardMapper anonyBoardMapper;
	
	//리스트
	@Override
	public List<AnonyBoardVO> list(){
		return this.anonyBoardMapper.list();
	}

	//상세내역
	@Override
	public AnonyBoardVO detail(AnonyBoardVO anonyBoardVO) {
		return this.anonyBoardMapper.detail(anonyBoardVO);
	}
	

	//등록
	@Override
	public int register(AnonyBoardVO anonyBoardVO) {
		int result = this.anonyBoardMapper.register(anonyBoardVO);
		
		//첨부파일 시작====================================================
		MultipartFile[] multipartFiles = anonyBoardVO.getAttachFiles();
		
		//연월일 폴더 생성
		File savePath = new File(CommonFile.uploadFolderBbs, CommonFile.getFolder());
		if(savePath.exists()==false) {
			savePath.mkdirs();
		}
		
		List<BbsAtchVO> bbsAtchVO = new ArrayList<BbsAtchVO>();
		//BBS_ATCH테이블의 기본키 데이터 + 1
		int seq = this.anonyBoardMapper.getNextBbsFlNo();
		for(MultipartFile file : multipartFiles) {
			BbsAtchVO vo = new BbsAtchVO();
			
			vo.setBbsFlNo(seq++);
			vo.setFileNm(file.getOriginalFilename());
			UUID uuid = UUID.randomUUID(); 
			vo.setFileUuid(uuid.toString()+"_"+file.getOriginalFilename());
			vo.setFilePath("/" + CommonFile.getFolder().replace("\\", "/") + "/" + uuid.toString()+"_"+file.getOriginalFilename());
			vo.setFileExtn(file.getContentType());
			vo.setFileSize(file.getSize());
			vo.setPstNo(anonyBoardVO.getPstNo());
			
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
			anonyBoardVO.setBbsAtchVO(bbsAtchVO);
			log.info("anonyBoardVO : " + anonyBoardVO);
			
//			}
			
			result += this.anonyBoardMapper.insertAttachFiles(bbsAtchVO);
			
		}
		//첨부파일 끝====================================================

		return result;
	}
	
	//머릿말가져오기
	@Override
	public List<AnonyPstHdVO> getHd(AnonyPstHdVO hd) {
		return this.anonyBoardMapper.getHd(hd);
	}

	//조회수 가져오기
	@Override
	public int inqCnt(int pstNo) {
		return this.anonyBoardMapper.inqCnt(pstNo);
	}
	
	
	//수정하기
	@Override
	public int update(AnonyBoardVO anonyBoardVO) {
		int result = this.anonyBoardMapper.update(anonyBoardVO);
		
		//첨부파일 시작====================================================
		MultipartFile[] multipartFiles = anonyBoardVO.getAttachFiles();
		
		//연월일 폴더 생성
		File savePath = new File(CommonFile.uploadFolderBbs, CommonFile.getFolder());
		if(savePath.exists()==false) {
			savePath.mkdirs();
		}
		
		List<BbsAtchVO> bbsAtchVO = new ArrayList<BbsAtchVO>();
		//BBS_ATCH테이블의 기본키 데이터 + 1
		int seq = this.anonyBoardMapper.getNextBbsFlNo();
		for(MultipartFile file : multipartFiles) {
			BbsAtchVO vo = new BbsAtchVO();
			
			vo.setBbsFlNo(seq++);
			vo.setFileNm(file.getOriginalFilename());
			UUID uuid = UUID.randomUUID(); 
			vo.setFileUuid(uuid.toString()+"_"+file.getOriginalFilename());
			vo.setFilePath("/" + CommonFile.getFolder().replace("\\", "/") + "/" + uuid.toString()+"_"+file.getOriginalFilename());
			vo.setFileExtn(file.getContentType());
			vo.setFileSize(file.getSize());
			vo.setPstNo(anonyBoardVO.getPstNo());
			
			
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
			anonyBoardVO.setBbsAtchVO(bbsAtchVO);
			log.info("anonyBoardVO : " + anonyBoardVO);
			
			result += this.anonyBoardMapper.insertAttachFiles(bbsAtchVO);
			
		}
		//첨부파일 끝====================================================
		this.anonyBoardMapper.updateFileExistDel(bbsAtchVO.get(0));
		
		return result;
	}

	@Override
	public int deletePost(AnonyBoardVO anonyBoardVO) {
		return this.anonyBoardMapper.deletePost(anonyBoardVO);
	}

	// /board/update에서 파일업로드 상태 변경(N)
	@Override
	public int updateFileExist(BbsAtchVO bbsAtchVO) {
		return this.anonyBoardMapper.updateFileExist(bbsAtchVO);
	}
	
	// /board/update에서 파일업로드 상태 변경(All Y)
	@Override
	public int updateFileExistCancel(BbsAtchVO bbsAtchVO) {
		return this.anonyBoardMapper.updateFileExistCancel(bbsAtchVO);
	}
	
	// /board/update에서 N인것 DEL
	@Override
	public int updateFileExistDel(BbsAtchVO bbsAtchVO) {
		return this.anonyBoardMapper.updateFileExistDel(bbsAtchVO);
	}
	
	//댓글 등록하기
	@Override
	public int commentRegister(AnonyCmntVO anonyCmntVO) {
		return this.anonyBoardMapper.commentRegister(anonyCmntVO);
	}
	
	//댓글 가져오기
	@Override
	public List<AnonyCmntVO> commentSelect(AnonyCmntVO anonyCmntVO){
		return this.anonyBoardMapper.commentSelect(anonyCmntVO);
	}
	
	//대댓글 작성하기
	@Override
	public int commentInCommentRegister(AnonyCmntVO anonyCmntVO) {
		return this.anonyBoardMapper.commentInCommentRegister(anonyCmntVO);
	}
	
	//댓글 삭제하기
	@Override
	public int deleteComment(AnonyCmntVO anonyCmntVO) {
		return this.anonyBoardMapper.deleteComment(anonyCmntVO);
	}

	//댓글 수정하기
	@Override
	public int commentModify(AnonyCmntVO anonyCmntVO) {
		return this.anonyBoardMapper.commentModify(anonyCmntVO);
	}
	
}
