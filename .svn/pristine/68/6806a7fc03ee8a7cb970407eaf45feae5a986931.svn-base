package kr.or.ddit.notice.service;

import java.util.List;

import kr.or.ddit.bbscommon.BbsAtchVO;
import kr.or.ddit.notice.vo.NoticeVO;
import kr.or.ddit.notice.vo.PstHdVO;

public interface NoticeService {
	
	//목록
	public List<NoticeVO> list();
	
	//상세보기
	public NoticeVO detail(NoticeVO noticeVO);
	
	//조회수 카운트
	public int inqCnt(int pstNo);
	
	//머릿말 가져오기
	public List<PstHdVO> getHd(PstHdVO hd);
	
	//등록
	public int register(NoticeVO noticeVO);
	
	//수정
	public int update(NoticeVO noticeVO);
	
	// /notice/update에서 파일업로드 상태 변경(N)
	public int updateFileExist(BbsAtchVO bbsAtchVO);

	// /notice/update에서 파일업로드 상태 변경(All Y)
	public int updateFileExistCancel(BbsAtchVO bbsAtchVO);
	
	// /notice/update에서 N인것 delete
	public int updateFileExistDel(BbsAtchVO bbsAtchVO);
	
	//삭제
	public int delete(NoticeVO noticeVO);
	
	//메인페이지 리스트
	public List<NoticeVO> selectMainPageList();


}
