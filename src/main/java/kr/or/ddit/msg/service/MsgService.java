package kr.or.ddit.msg.service;

import java.util.List;

import kr.or.ddit.msg.vo.MsgVO;

/**
 * @author 김종명
 *
 */
public interface MsgService {

	/**
	 * 쪽지 등록
	 * @param MsgVO msg
	 * @return int
	 */
	public int insert(MsgVO msg);
	/**
	 * 중요 쪽지 설정
	 * @param MsgVO msg
	 * @return int
	 */
	public int importMsg(MsgVO msg);
	/**
	 * 받은 쪽지함
	 * @param MsgVO msg
	 * @return List<MsgVO>
	 */
	public List<MsgVO> listReceiver(MsgVO msg);
	/**
	 * 보낸 쪽지함
	 * @param MsgVO msg
	 * @return List<MsgVO>
	 */
	public List<MsgVO> listSender(MsgVO msg);
	/**
	 * 받은 쪽지 상세보기
	 * @param MsgVO msg
	 * @return List<MsgVO>
	 */
	public MsgVO detailReceiver(MsgVO msg);
	/**
	 * 보낸 쪽지 상세보기
	 * @param MsgVO msg
	 * @return List<MsgVO>
	 */
	public MsgVO detailSender(MsgVO msg);
	/**
	 * 중요 쪽지함
	 * @param MsgVO msg
	 * @return List<MsgVO>
	 */
	public List<MsgVO> msgImport(MsgVO msg);
	/**
	 * 쪽지 삭제
	 * @param MsgVO msg
	 * @return int
	 */
	public int delete(MsgVO msg);
	/**
	 * 휴지통 보내기
	 * @param MsgVO msg
	 * @return int
	 */
	public int trashSet(MsgVO msg);
	/**
	 * 복원하기
	 * @param MsgVO msg
	 * @return int
	 */
	public int restore(MsgVO msg);
	/**
	 * 휴지통 목록
	 * @param MsgVO msg
	 * @return List<MsgVO>
	 */
	List<MsgVO> trash(MsgVO msg);
	
}
