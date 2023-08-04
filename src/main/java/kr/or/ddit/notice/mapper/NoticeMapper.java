package kr.or.ddit.notice.mapper;

import java.util.List;

import kr.or.ddit.bbscommon.BbsAtchVO;
import kr.or.ddit.notice.vo.NoticeVO;
import kr.or.ddit.notice.vo.PstHdVO;

public interface NoticeMapper {
	
	//목록
	public List<NoticeVO> list();
	
	//상세
	public NoticeVO detail(NoticeVO noticeVO);
	
	//조회수 카운트
	public int inqCnt(int pstNo);
	
	//등록
	public int register(NoticeVO noticeVO);
	
	//첨부파일 등록
	public int insertAttachFiles(List<BbsAtchVO> bbsAtchVO);

	//BBS_ATCH테이블의 기본키 데이터 + 1
	public int getNextBbsFlNo();
	
	//머릿말 호출
	public List<PstHdVO> getHd(PstHdVO hd);
	
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

	//메인화면 공지사항
	public List<NoticeVO> selectMainPageList();

}
