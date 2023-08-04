package kr.or.ddit.community.anonyboard.service;


import java.util.List;

import kr.or.ddit.bbscommon.BbsAtchVO;
import kr.or.ddit.community.anonyboard.vo.AnonyBoardVO;
import kr.or.ddit.community.anonyboard.vo.AnonyCmntVO;
import kr.or.ddit.community.anonyboard.vo.AnonyPstHdVO;

public interface AnonyBoardService {
	
	//리스트
	public List<AnonyBoardVO> list();

	//상세보기
	public AnonyBoardVO detail(AnonyBoardVO anonyBoardVO);

	//등록하기
	public int register(AnonyBoardVO anonyBoardVO);

	//머릿말 가져오기
	public List<AnonyPstHdVO> getHd(AnonyPstHdVO hd);
	
	//조회수 카운트
	public int inqCnt(int pstNo);
	
	//글 수정
	public int update(AnonyBoardVO anonyBoardVO);
	
	public int deletePost(AnonyBoardVO anonyBoardVO);

	// /board/update에서 파일업로드 상태 변경(N)
	public int updateFileExist(BbsAtchVO bbsAtchVO);

	// /board/update에서 파일업로드 상태 변경(All Y)
	public int updateFileExistCancel(BbsAtchVO bbsAtchVO);
	
	// /board/update에서 N인것 DEL
	public int updateFileExistDel(BbsAtchVO bbsAtchVO);
	
	//맨 상위 댓글 작성
	public int commentRegister(AnonyCmntVO anonyCmntVO);

	//댓글 가져오기
	public List<AnonyCmntVO> commentSelect(AnonyCmntVO anonyCmntVO);

	//대댓글 작성하기
	public int commentInCommentRegister(AnonyCmntVO anonyCmntVO);

	//댓글 삭제하기
	public int deleteComment(AnonyCmntVO anonyCmntVO);
	
	//댓글 수정하기
	public int commentModify(AnonyCmntVO anonyCmntVO);
	
	
}
