package kr.or.ddit.servey.vo;

import java.util.List;

import lombok.Data;

/**
 * @author 이주연
 *
 */
@Data
public class ServeyOptionVO {
	
	private int optnNo; //문항의 선택지 번호(기본키)
	private int qitemNo; //설문의 문항번호 (외래키)
	private int srvyNo; //설문 관리번호 (외래키)
	private String optnCt; //선택지 내용
	private int selectUser; //선택한 사용자의 수
}
