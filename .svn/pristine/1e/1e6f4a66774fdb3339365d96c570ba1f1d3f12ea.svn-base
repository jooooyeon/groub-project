package kr.or.ddit.community.board.service;


import java.util.List;

import kr.or.ddit.bbscommon.BbsAtchVO;
import kr.or.ddit.community.board.vo.BoardVO;
import kr.or.ddit.community.board.vo.CmntVO;
import kr.or.ddit.community.board.vo.PstHdVO;

public interface BoardService {
	
	//리스트
	public List<BoardVO> list();

	//상세보기
	public BoardVO detail(BoardVO boardVO);

	//등록하기
	public int register(BoardVO boardVO);

	//머릿말 가져오기
	public List<PstHdVO> getHd(PstHdVO hd);
	
	//조회수 카운트
	public int inqCnt(int pstNo);
	
	//글 수정
	public int update(BoardVO boardVO);
	
	public int deletePost(BoardVO boardVO);

	// /board/update에서 파일업로드 상태 변경(N)
	public int updateFileExist(BbsAtchVO bbsAtchVO);

	// /board/update에서 파일업로드 상태 변경(All Y)
	public int updateFileExistCancel(BbsAtchVO bbsAtchVO);
	
	// /board/update에서 N인것 DEL
	public int updateFileExistDel(BbsAtchVO bbsAtchVO);
	
	//맨 상위 댓글 작성
	public int commentRegister(CmntVO cmntVO);

	//댓글 가져오기
	public List<CmntVO> commentSelect(CmntVO cmntvo);

	//대댓글 작성하기
	public int commentInCommentRegister(CmntVO cmntVO);

	//댓글 삭제하기
	public int deleteComment(CmntVO cmntVO);
	
	//댓글 수정하기
	public int commentModify(CmntVO cmntVO);
	
	
}
