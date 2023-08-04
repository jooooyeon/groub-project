package kr.or.ddit.util;

import java.util.List;

//페이지 관련 정보 + 게시글 데이터
public class ArticlePage<T> {
	//전체 글 수
	private int total;
	//현재 페이지 번호
	private int currentPage;
	//전체 페이지 수
	private int totalPages;
	//시작 페이지 번호
	private int startPage;
	//종료 페이지 번호
	private int endPage;
	//데이터 리스트
	private List<T> content;
	//한화면에 보여질 행의 수
	private int size;
	
	//생성자(Constructor) : 페이징 정보를 저장
	public ArticlePage(int total, int currentPage, int size,List<T> content) {
		//매개변수에 저장된 파라미터의 데이터들을 멤버변수에 할당
		//size : 한 화면에 보여질 목록의 행 수
		this.total = total;
		this.currentPage = currentPage;
		this.content = content;
		this.size = size;
		
		
		//select한 전체 글 수가 0이면?
		if(total==0) {//행이 없음
			totalPages = 0;
			startPage = 0;
			endPage = 0;
		}else {//글이 있다면..
			//전체 3페이지  = 	30행 	/ 10개
			//전체 페이지 수 = 전체 글 수 / 한 화면에 보여질 목록의 행 수 
			totalPages = total / size;
			// 나누었을 때 몫이 딱 떨어 지지 않는 다면, 나머지가 있다면 페이지 1증가
			//	2(int)	= 24행(int) 	/10개(int)
			if(total % size > 0) {
				totalPages++;
			}
			
			//시작페이지 구하는 공식
			//시작페이지 = 현재페이지  / 페이징크기 * 페이징 크기 + 1 (시현? 페페일)
			startPage = currentPage /5*5+1;
			//현재페이지 % 페이징 크기 => 0일때 보정
			if(currentPage %5 ==0) {
				//블록 크기만큼 빼줌
				startPage -=5;
			}
			//종료페이지 구하는 공식
			//종료페이지번호 = 시작 페이지 번호 + (블록 페이징 크기 -1)
			endPage = startPage + (5 -1);
			//종료페이지 번호 > 전체 페이지 수보다 클 때 보정
			if(endPage>totalPages) {
				endPage = totalPages;
			}
		}
	}//end ArticlePage생성자
	
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public List<T> getContent() {
		return content;
	}
	public void setContent(List<T> content) {
		this.content = content;
	}
	
	public int getSize() {
		return size;
	}


	public void setSize(int size) {
		this.size = size;
	}


	//결과가 없니?
	public boolean hasNoArticles() {
		return total==0;
		//트루가 리턴(데이터가 없으면) / 데이터가 있으면 폴스 리턴
	}
	
	//결과가 있니?
	public boolean hasArticles() {
		return total > 0;
	}
	
		
	
	
	
}
