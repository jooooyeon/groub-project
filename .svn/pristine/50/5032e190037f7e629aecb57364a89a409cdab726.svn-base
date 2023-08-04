package kr.or.ddit.mail.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.mail.service.MailServiceImpl;
import kr.or.ddit.mail.vo.MailVO;
import kr.or.ddit.msg.service.MsgServiceImpl;
import kr.or.ddit.msg.vo.MsgVO;
import kr.or.ddit.security.CustomUser;
import kr.or.ddit.user.vo.UserVO;
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
@RequestMapping("/mail")
@Controller
@Secured({ "ROLE_USER", "ROLE_ADMIN" })
public class MailController {
	@Autowired
	MsgServiceImpl msgService;

	@Autowired
	private MailServiceImpl mailServiceImpl;

	/**
	 * 새 메일 경로
	 * 
	 * @return String "mail/compose";
	 */
	@GetMapping("/compose")
	public String compose(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		CustomUser user = (CustomUser) auth.getPrincipal();
		String dsptchEml = user.getUserVO().getUserEml();
		String dsptchId = user.getUserVO().getUserId();
		
		model.addAttribute("dsptchEml",dsptchEml);
		model.addAttribute("dsptchId",dsptchId);
		
		return "mail/compose";
	}

	/**
	 * 메일함 경로 설정
	 * 
	 * @return String "mail/inbox";
	 */
	@GetMapping("/inbox")
	public String inbox(Model model) {
		UserVO user = authencation();
		String rcptnEml = user.getUserEml();
		String dsptchEml = user.getUserEml();
		
		model.addAttribute("dsptchEml",dsptchEml);
		model.addAttribute("rcptnEml", rcptnEml);
		return "mail/inbox";
	}

	/**
	 * Spring Security에서 Principal에 저장된 내용 가져오기
	 * @return UserVO
	 */
	private UserVO authencation() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		CustomUser custom = (CustomUser) auth.getPrincipal();
		UserVO user = custom.getUserVO();
		return user;
	}

	/**
	 * 메일 보내기/발송
	 * 
	 * @param MailVO m
	 * @return 성공여부 success
	 */
	@ResponseBody
	@PostMapping("/send")
	public String send(MailVO m) {
		log.info("MailVO>> " + m);
		if (m.getFiles() != null) log.info("MailVO.files>> " + m.getFiles().length);
		this.mailServiceImpl.sendMail(m);
		this.mailServiceImpl.insert(m);
		return "success";
	}

	/**
	 * 보낸 메일함
	 * 
	 * @param m
	 * @return List<MailVO>
	 */
	@ResponseBody
	@PostMapping("/sender")
	public List<MailVO> sender(MailVO m, String emlSort) {
		m.setDsptchEml(emlSort);
		log.info("MailVO>> " + m);
		return this.mailServiceImpl.listSender(m);
	}

	/**
	 * 받는 메일함
	 * 
	 * @param MailVO m
	 * @return List<MailVO>
	 */
	@ResponseBody
	@PostMapping("/receiver")
	public List<MailVO> receiver(MailVO m, String emlSort) {
		m.setRcptnEml(emlSort);
		log.info("MailVO>> " + m);
		return this.mailServiceImpl.listReceiver(m);
	}

	/**
	 * 중요 메일함
	 * 
	 * @param MailVO m
	 * @return List<MsgVO>
	 */
	@ResponseBody
	@PostMapping("/importMsg")
	public List<MailVO> MsgImport(MailVO m, String emlSort) {
		m.setRcptnEml(emlSort);
		m.setEmlStts("MM005");
		return this.mailServiceImpl.listReceiver(m);
	}

	/**
	 * 중요메일 설정
	 * 
	 * @param MailVO m
	 * @return String 성공여부
	 */
	@ResponseBody
	@GetMapping("/importSet")
	public String importSet(MailVO m) {
		int result = this.mailServiceImpl.importSet(m);
		return "success";
	}

	/**
	 * 수신자 상세보기/받는 메일 상세보기
	 * 
	 * @param MailVO m
	 * @param Model  model
	 * @return String "mail/detail" JSP forwarding
	 */
	@GetMapping("/detailReceiver")
	public String detailReceiver(MailVO m, Model model) {
		m = this.mailServiceImpl.receiverDetail(m);
		model.addAttribute("eml", m);
		return "mail/detail";
	}

	/**
	 * 보낸 메일 상세보기
	 * 
	 * @param MailVO m
	 * @param Model model
	 * @return mail/detail JSP forwarding
	 */
	@GetMapping("/detailSender")
	public String detailSender(MailVO m, Model model) {
		m = this.mailServiceImpl.sendDetail(m);
		model.addAttribute("eml", m);
		return "mail/detail";
	}

	/**
	 * 휴지통 목록
	 * 
	 * @param MailVO m
	 * @return List<MsgVO>
	 */
	@ResponseBody
	@PostMapping("/trash")
	public List<MailVO> trash(MailVO m, String emlSort) {
		m.setRcptnEml(emlSort);
		return this.mailServiceImpl.trashList(m);
	}

	/**
	 * 메일 삭제 하는 기능
	 * 
	 * @param MailVO m
	 * @return String "success";
	 */
	@ResponseBody
	@PostMapping("/delete")
	public String delete(MailVO m) {
		log.info("deleteController>> "+m);
		int result = this.mailServiceImpl.deleteSet(m);
		return "success";
	}

	/**
	 * 휴지통에서 메일 복원 기능
	 * 
	 * @param MailVO m
	 * @return success 성공여부
	 */
	@ResponseBody
	@GetMapping("/restore")
	public String restore(MailVO m) {
		int result = this.mailServiceImpl.restore(m);
		return "success";
	}

}
