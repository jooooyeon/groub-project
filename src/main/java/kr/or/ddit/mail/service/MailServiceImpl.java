package kr.or.ddit.mail.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.mail.mapper.MailMapper;
import kr.or.ddit.mail.vo.MailAtchVO;
import kr.or.ddit.mail.vo.MailVO;
import kr.or.ddit.util.CommonFile;
import lombok.extern.slf4j.Slf4j;

/**
 * 메일 controller
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

@Slf4j
@Service
public class MailServiceImpl {
	/**
	 * MailMapper
	 */
	@Autowired
	private MailMapper mailMapper;

	/**
	 * 외부로 메일 보내기
	 */
	@Autowired
	private JavaMailSender javaMailSender;

	/**
	 * 휴지통 목록
	 * @param MailVO m
	 * @return List<MailVO>
	 */
	public List<MailVO> trashList(MailVO m) {
		List<MailVO> temp = new ArrayList<>();
		m.setEmlStts("MM003");
		List<MailVO> mailVOList = this.mailMapper.listRcptn(m);
		for(int i=0;i<mailVOList.size();i++) {
			MailVO mVO = mailVOList.get(i);
			DsptchDtFormat(mVO);
			mailVOList.set(i, mVO);
		}
		temp.addAll(mailVOList);
		
		mailVOList = this.mailMapper.listDsptch(m);
		for(int i=0;i<mailVOList.size();i++) {
			m = mailVOList.get(i);
			
			//발신자 메일이 사용자라면?
			
			DsptchDtFormat(m);
			temp.add(m);
		}
		return temp;
	};

	/**
	 * 중요 메일 설정(수신만 가능)
	 * @param MailVO m
	 * @return int
	 */
	public int importSet(MailVO m) {
		if (m.getEmlStts().equals("MM001") || m.getEmlStts().equals("MM002"))
			m.setEmlStts("MM005");
		else if (m.getEmlStts().equals("MM005"))
			m.setEmlStts("MM002");

		return this.mailMapper.rcptnSet(m);
	}

	/**
	 * 받은 메일함
	 * @param MailVO m
	 * @return List<MailVO>
	 */
	public List<MailVO> listReceiver(MailVO m) {
		log.info("mailVO>> " + m);
		List<MailVO> temp = new ArrayList<MailVO>();
		List<MailVO> mailVOList = this.mailMapper.listRcptn(m);
		
		for (MailVO mVO : mailVOList) {
			DsptchDtFormat(mVO);
			if (!(mVO.getEmlStts().equals("MM003") || mVO.getEmlStts().equals("MM004")))
				temp.add(mVO);
		}
		log.info("temp>> " + temp);
		return temp;
	}

	/**
	 * 보낸 메일함
	 * @param m
	 * @return List<MailVO>
	 */
	public List<MailVO> listSender(MailVO m) {
		List<MailVO> mailVOList = this.mailMapper.listDsptch(m);
		List<MailVO> temp = new ArrayList();

		try {
			for (int i = 0; i < mailVOList.size(); i++) {
				MailVO mVO = mailVOList.get(i);
				DsptchDtFormat(mVO);
				
				//발신자 메일이 사용자라면?
				
				if(!(mVO.getEmlStts().equals("MM003")||mVO.getEmlStts().equals("MM004"))) {
					temp.add(mVO);
				}
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
			return null;
		}
		log.info("temp>> " + temp);
		return temp;
	}

	/**
	 * 외부 메일 보내기 기능
	 * 
	 * @param mail
	 */
	public void sendMail(MailVO mail) {
		log.info("mail>> " + mail);
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(mail.getRcptnEml());
		message.setSubject(mail.getEmlTtl());
		message.setText(mail.getTxt());

		this.javaMailSender.send(message);
		log.info("sendMail>> " + mail);
	}

	/**
	 * 메일 등록 처리
	 * 
	 * @param mail
	 * @return int insert된 결과값 rlt
	 */
	@Transactional
	public int insert(MailVO mail) {
		if (mail.getDsptchCd().equals("rcptn"))
			mail.setDsptchCd("EM001");
		else if (mail.getDsptchCd().equals("cc"))
			mail.setDsptchCd("EM002");
		else if (mail.getDsptchCd().equals("hc"))
			mail.setDsptchCd("EM003");

		int rlt = this.mailMapper.insertDsptch(mail);
		rlt += this.mailMapper.insertRcptn(mail);

		// 메일 번호 불러오기
		int emlNo = mail.getEmlNo();
		MultipartFile[] files = mail.getFiles();
		List<MailAtchVO> mailAtchVOList = new ArrayList<MailAtchVO>();

		if (files != null) {
			for (MultipartFile mf : files) {
				MailAtchVO mAtch = new MailAtchVO();
				// 번호 설정
				mAtch.setEmlNo(emlNo);
				// 업로드 파일명
				String uploadFileName = "";

				String path = CommonFile.uploadFolderMail;
				File uploadPath = new File(path, CommonFile.getFolder());
				if (uploadPath.exists() == false) {
					uploadPath.mkdirs();
				}
				// 파일명
				String fileNm = mf.getOriginalFilename();
				mAtch.setFileNm(fileNm);
				// 중복방지 uuid
				UUID uuid = UUID.randomUUID();
				mAtch.setFileUuid(uuid + "");
				uploadFileName = uuid.toString() + "_" + fileNm;

				// 설계. 복사될 폴더와 파일명
				File saveFile = new File(uploadPath, uploadFileName);

				// 복사 실행
				try {
					mf.transferTo(saveFile);
					// 파일 확장자
					String fileExtn = mf.getContentType();
					mAtch.setFileExtn(fileExtn);
					// 파일 path
					mAtch.setFilePath("/" + CommonFile.getFolder().replace("\\", "/") + "/" + uploadFileName);
					mAtch.setFileSize("" + mf.getSize());
					mailAtchVOList.add(mAtch);

					log.info("mailAtchVO>> " + mAtch);
				} catch (IllegalStateException | IOException e) {
					log.error(e.getMessage());
					throw new RuntimeException(e);
				}
			}
			mail.setMailAtchList(mailAtchVOList);
			rlt += this.mailMapper.insertAtch(mail);
			log.info("mail>> " + mail);
		}

		return rlt;
	}

	/**
	 * 받는 사람 세부사항 수신자 상세보기 할때, 미열람 -> 열람처리, 발신자도 수신자의 열람여부를 알 수 있음
	 * 
	 * @param MailVO m
	 * @return MailVO
	 */
	@Transactional
	public MailVO receiverDetail(MailVO m) {
		if(m.getEmlStts().equals("MM001")) {
			m.setEmlStts("MM002");
			this.mailMapper.rcptnSet(m);
			this.mailMapper.dsptchSet(m);
		}
		m = this.mailMapper.rcptnDetail(m);
		
		//수신자가 사용자라면?
		
		log.info("m>> "+m);

		List<MailAtchVO> atchList = null;
		if (this.mailMapper.isExistAtch(m)) {
			atchList = this.mailMapper.listAtch(m);
			m.setMailAtchList(atchList);
		}

		DsptchDtFormat(m);
		log.info("detail>> " + m);
		
		return m;
	}

	/**
	 * 메일 휴지통/삭제 시키는 기능
	 * 
	 * @param MailVO m
	 * @return int
	 */
	public int deleteSet(MailVO m) {
		if (m.getEmlStts().equals("MM003")) m.setEmlStts("MM004");
		else m.setEmlStts("MM003");
		log.info("delete>> " + m);
		
		int rlt = 0;
		if(m.getSort().equals("rcptn")) {
			rlt = this.mailMapper.rcptnSet(m);
		} else {
			rlt = this.mailMapper.dsptchSet(m);
		}
		
		return rlt;
	}

	/**
	 * 휴지통에서 메일 복원하는 기능
	 * 
	 * @param MailVO m
	 * @return int
	 */
	public int restore(MailVO m) {
		m.setEmlStts("MM002");

		log.info("복원하기>> "+m);
		int rlt = 0;
		if(m.getSort().equals("rcptn")) rlt = this.mailMapper.rcptnSet(m);
		else if(m.getSort().equals("dsptch")) rlt = this.mailMapper.dsptchSet(m);

		return rlt;
	}

	/**
	 * 보낸 메일 상세보기
	 * 
	 * @param MailVO m
	 * @return MailVO
	 */
	public MailVO sendDetail(MailVO m) {
		m = this.mailMapper.dsptchDetail(m);
		log.info("m>> "+m);
		log.info("this.mailMapper.isExistSender(m)>> "+this.mailMapper.isExistDsptch(m));
		
		//발신자가 사용자라면?
		log.info("m>> "+m);
		
		List<MailAtchVO> atchList = null;
		if (this.mailMapper.isExistAtch(m)) {
			atchList = this.mailMapper.listAtch(m);
			log.info("atchList>> "+atchList);
			m.setMailAtchList(atchList);
		}
		DsptchDtFormat(m);
		
		return m;
	}
	
	/**
	 * 휴지통으로 보내기 혹은 삭제하기
	 * 
	 * @param MailVO m
	 * @return int
	 */
	public int sendTrashSet(MailVO m) {
		if(m.getEmlStts().equals("MM003")) m.setEmlStts("MM004");
		else m.setEmlStts("MM003");
		int rlt = this.mailMapper.dsptchSet(m);
		return rlt;
	}

	/**
	 * 시간 format
	 * 
	 * @param MailVO MailVO m
	 */
	private void DsptchDtFormat(MailVO m) {
		String date = m.getDsptchDt();
		date = date.substring(0, 16);
		m.setDsptchDt(date);
	}

}