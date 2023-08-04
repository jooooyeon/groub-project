package kr.or.ddit.mail.mapper;

import java.util.List;

import kr.or.ddit.mail.vo.MailAtchVO;
import kr.or.ddit.mail.vo.MailVO;
import kr.or.ddit.msg.vo.MsgVO;

/**
 * 메일 mapper
 * 
 * @author 김종명
 * @since 2023.07.10
 * @version 1.0
 * @see
 *
 * << 개정이력(Modification Information) >>
 *
 *   수정일     수정자           수정내용
 *  -------    --------    ---------------------------
 *  2023.07.10  김종명        최초 생성
 *  2023.07.11  김종명        새 메일 보내기
 *  2023.07.12  김종명        메일함
 *  2023.07.13  김종명        중요 메일, 휴지통 설정
 */ 

public interface MailMapper {
	
	/**
	 * 보낸 전체 메일 갯수
	 * @param MailVO m
	 * @return int
	 */
	public int getTotalSender(MailVO m);
	/**
	 * 받은 메일 전체 갯수 불러옴
	 * 
	 * @return int
	 */
	public int getTotalReceiver(MailVO m);
	/**
	 * 발신자 저장
	 * 
	 * @param MailVO m
	 * @return int 결과값
	 */
	public int insertDsptch(MailVO m);

	/**
	 * 수신자 저장
	 * 
	 * @param MailVO m
	 * @return int 결과값
	 */
	public int insertRcptn(MailVO m);

	/**
	 * 첨부파일 저장
	 * 
	 * @param MailVO m
	 * @return int 결과값
	 */
	public int insertAtch(MailVO m);

	/**
	 * 발신자 사용자 여부 확인
	 * @param MailVO m
	 * @return boolean
	 */
	public boolean isExistDsptch(MailVO m);
	
	/**
	 * 수신자 사용자 여부 확인
	 * @param MailVO m
	 * @return boolean
	 */
	public boolean isExistRcptn(MailVO m);
	
	/**
	 * 받은 메일함/중요 메일함
	 * @param MailVO m
	 * @return List<MailVO>
	 */
	public List<MailVO> listRcptn(MailVO m);
	/**
	 * 보낸 메일함
	 * @param MailVO m
	 * @return List<MailVO>
	 */
	public List<MailVO> listDsptch(MailVO m);
	
	/**
	 * 휴지통
	 * @param MailVO m
	 * @return List<MailVO>
	 */
	public List<MailVO> listTrash(MailVO m);
	
	/**
	 * 메일 첨부 파일 불러오기
	 * @param MailAtchVO m
	 * @return List<MailAtchVO>
	 */
	public List<MailAtchVO> listAtch(MailVO m);
	
	/**
	 * 첨부파일 존재 여부
	 * @param MailAtchVO m
	 * @return boolean
	 */
	public boolean isExistAtch(MailVO m);
	
	/**
	 * 발신자 메일 업데이트
	 * @param MailVO m
	 * @return int
	 */
	public int dsptchSet(MailVO m);
	
	/**
	 * 수신자 메일 업데이트
	 * @param MailVO m
	 * @return int
	 */
	public int rcptnSet(MailVO m);
	
	/**
	 * 발신 메일 상세보기
	 * @param MailVO m
	 * @return MailVO
	 */
	public MailVO dsptchDetail(MailVO m);
	
	/**
	 * 수신 메일 상세보기
	 * @param MailVO m
	 * @return MailVO
	 */
	public MailVO rcptnDetail(MailVO m);
	
}
