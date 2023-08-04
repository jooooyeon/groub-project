package kr.or.ddit.msg.mapper;

import java.util.List;

import kr.or.ddit.msg.vo.MsgVO;
import kr.or.ddit.user.vo.UserVO;

/**
 * 쪽지 MsgMapper
 * 
 * @author 김종명
 * @since 2023.07.03
 * @version 1.0
 * @see
 *
 * << 개정이력(Modification Information) >>
 *
 *   수정일     수정자           수정내용
 *  -------    --------    ---------------------------
 *  2023.07.03  김종명          최초 생성
 *  2023.07.04  김종명          새 쪽지 보내기
 *  2023.07.05  김종명          쪽지함
 *  2023.07.06  김종명          중요 쪽지, 휴지통
 *	2023.07.21	김종명          전체 알람
 *	2023.07.21	김종명          기업별 전체 사용자 리스트 불러오기
 */
public interface MsgMapper {
	
	/**
	 * 기업 아이디 반환
	 * @param MsgVO m
	 * @return MsgVO
	 */
	public MsgVO selectCoId(MsgVO m);
	/**
	 * 기업 내 모든 사용자
	 * @param msg 
	 * @return List<UserVO>
	 */
	public List<UserVO> coUserList(MsgVO msg);
	/**
	 * 모든 알람 읽음처리
	 * @param List<MsgVO> msg
	 * @return int
	 */
	public int readAllUpdate(MsgVO m);
	/**
	 * 보낸 사람 쪽지 저장
	 * @param MsgVO msg
	 * @return int
	 */
	public int insertSender(MsgVO msg);
	/**
	 * 받는 사람 쪽지 저장
	 * @param MsgVO msg
	 * @return int
	 */
	public int insertReceiver(MsgVO msg);
	
	/**
	 * 보낸 쪽지
	 * @param MsgVO msg
	 * @return List<MsgVO>
	 */
	public List<MsgVO> listSender(MsgVO msg);
	/**
	 * 받는 쪽지
	 * @param MsgVO msg
	 * @return List<MsgVO>
	 */
	public List<MsgVO> listReceiver(MsgVO msg);
	/**
	 * 보낸 쪽지 상세보기
	 * @param MsgVO msg
	 * @return MsgVO
	 */
	public MsgVO detailSender(MsgVO msg);
	/**
	 * 받는 쪽지 상세보기
	 * @param MsgVO msg
	 * @return MsgVO
	 */
	public MsgVO detailReceiver(MsgVO msg);
	
	/**
	 * 받는 쪽지 업데이트
	 * @param MsgVO msg
	 * @return int
	 */
	public int updateReceiver(MsgVO msg);
	/**
	 * 보낸 쪽지 업데이트
	 * @param MsgVO msg
	 * @return int
	 */
	public int updateSender(MsgVO msg);
}
