package kr.or.ddit.msg.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.msg.mapper.MsgMapper;
import kr.or.ddit.msg.vo.MsgVO;
import kr.or.ddit.user.vo.UserVO;
import lombok.extern.slf4j.Slf4j;

/**
 * 실시간 알람/메신저 controller
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
 *  2023.07.03  김종명        최초 생성
 *	2023.07.04	김종명        쪽지 알람
 *	2023.07.11  김종명        메일 알람
 *  2023.07.23  김종명        공지사항 알람, 메신저 알람
 */
@Slf4j
@Service
public class MsgServiceImpl {
	
	/**
	 * 쪽지 mapper
	 */
	@Autowired
	private MsgMapper msgMapper;
	
	/**
	 * 기업 아이디 반환
	 * @param MsgVO msg
	 * @return MsgVO
	 */
	public MsgVO selectCoId(MsgVO msg) {
		return this.msgMapper.selectCoId(msg);
	}
	/**
	 * 기업 내 모든 사용자 리스트
	 * @param msg 
	 * @return List<UserVO>
	 */
	public List<UserVO> coUserList(MsgVO msg){
		return this.msgMapper.coUserList(msg);
	}
	
	/**
	 * 공지사항 전체 알람 등록하기
	 * @return int
	 */
	@Transactional
	public int insertAlarmNotice(MsgVO m) {
		m.setStatCd("MM006");
		
		int rlt = this.msgMapper.insertSender(m);
		rlt += this.msgMapper.insertReceiver(m);
		
		return rlt;
	}
	/**
	 * 모든 알람 메세지 읽음 처리
	 * @return int
	 */
	public int readAllUpdate(MsgVO m) {
		m.setStatCd("MM006");
		return this.msgMapper.readAllUpdate(m);
	}
	
	/**
	 * 알람 메세지 불러오기
	 * @param MsgVO m
	 * @return List<MsgVO>
	 */
	public List<MsgVO> listAlarm(MsgVO m){
		List<MsgVO> mList = this.msgMapper.listReceiver(m);
		List<MsgVO> mTemp = new ArrayList<MsgVO>();
		
		for(MsgVO mVO:mList) if(mVO.getStatCd().equals("MM006")||mVO.getStatCd().equals("MM007")) mTemp.add(mVO);
		
		return mTemp;
	}

	/**
	 * 쪽지 등록하기
	 * @param MsgVO msg
	 * @return int
	 */
	@Transactional
	public int insert(MsgVO msg) {
		log.info("msg>> "+msg);
		
		int result = 0;
		if(msg.getStatCd()==null) msg.setStatCd("MM001");
		
		int r1 = this.msgMapper.insertSender(msg);
		result += r1;
		
		int r2 = this.msgMapper.insertReceiver(msg);
		result += r2;
		
		return result;
	}

	/**
	 * 중요 쪽지 설정
	 * @param MsgVO msg
	 * @return int
	 */
	public int importMsg(MsgVO msg) {
		if(msg.getStatCd().equals("MM001")||msg.getStatCd().equals("MM002")) msg.setStatCd("MM005");
		else if(msg.getStatCd().equals("MM005")) msg.setStatCd("MM002");
		return this.msgMapper.updateReceiver(msg);
	}

	/**
	 * 받은 쪽지함
	 * @param MsgVO msg
	 * @return List<MsgVO>
	 */
	public List<MsgVO> listReceiver(MsgVO msg) {
		List<MsgVO> listTemp = this.msgMapper.listReceiver(msg);
		List<MsgVO> list = new ArrayList<MsgVO>();
		for(int i=0;i<listTemp.size();i++) {
			msg = listTemp.get(i);
			DsptchDtFormat(msg);
			if(msg.getStatCd().equals("MM001")||msg.getStatCd().equals("MM002")||msg.getStatCd().equals("MM005")) list.add(listTemp.get(i));
		}
		return list;
	}
	
	/**
	 * 보낸 쪽지함
	 * @param MsgVO msg
	 * @return List<MsgVO>
	 */
	public List<MsgVO> listSender(MsgVO msg) {
		List<MsgVO> listTemp = this.msgMapper.listSender(msg);
		List<MsgVO> list = new ArrayList<MsgVO>();
		for(int i=0;i<listTemp.size();i++) {
			msg = listTemp.get(i);
			DsptchDtFormat(msg);
			if(msg.getStatCd().equals("MM003")||msg.getStatCd().equals("MM004")||msg.getStatCd().equals("MM006")||msg.getStatCd().equals("MM007")) {
			}else {
				list.add(msg);
			}
		}
		return list;
	}

	/**
	 * 받은 쪽지 상세보기
	 * @param MsgVO msg
	 * @return MsgVO
	 */
	@Transactional
	public MsgVO detailReceiver(MsgVO msg) {
		//글을 읽을 때만 변경되게 설정
		if(msg.getStatCd().equals("MM001")) {
			msg.setStatCd("MM002");
			int result = this.msgMapper.updateReceiver(msg);
			result += this.msgMapper.updateSender(msg);
		}
		msg = this.msgMapper.detailReceiver(msg);
		DsptchDtFormat(msg);
		
		return msg;
	}

	/**
	 * 보낸 메일 상세보기
	 * @param MsgVO msg
	 * @return MsgVO
	 */
	public MsgVO detailSender(MsgVO msg) {
		msg = this.msgMapper.detailReceiver(msg);
		DsptchDtFormat(msg);
		return msg;
	}
	
	/**
	 * 중요 쪽지함
	 * @param MsgVO msg
	 * @return List<MsgVO>
	 */
	public List<MsgVO> msgImport(MsgVO msg) {
		return this.msgMapper.listReceiver(msg);
	}
	
	/**
	 * 휴지통 보내기
	 * @param MsgVO msg
	 * @return int
	 */
	public int trashSet(MsgVO msg) {
		msg.setStatCd("MM003");
		log.info("msg>> "+msg);
		return this.msgMapper.updateReceiver(msg);
	}
	
	/**
	 * 휴지통에 있는 메일 삭제
	 * @param MsgVO msg
	 * @return int
	 */
	public int delete(MsgVO msg) {
		msg.setStatCd("MM004");
		return this.msgMapper.updateReceiver(msg);
	}

	/**
	 * 휴지통에 있는 쪽지 복원하기
	 * @param MsgVO msg
	 * @return int
	 */
	public int restore(MsgVO msg) {
		msg.setStatCd("MM002");
		log.info("msg>> "+msg);
		return this.msgMapper.updateReceiver(msg);
	}
	
	/**
	 * 휴지통 목록
	 * @param MsgVO msg
	 * @return List<MsgVO>
	 */
	public List<MsgVO> trash(MsgVO msg) {
		msg.setStatCd("MM003");
		List<MsgVO> list= this.msgMapper.listReceiver(msg);
		for(int i=0;i<list.size();i++) {
			msg = list.get(i);
			DsptchDtFormat(msg);
		}
		return list;
	}
	
	/** 
	 * String type으로 받아온 날짜 format
	 * @param MsgVO msg
	 */
	private void DsptchDtFormat(MsgVO msg) {
		String date = msg.getDsptchDt();
		date = date.substring(0,16);
		msg.setDsptchDt(date);
	}
}
