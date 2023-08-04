package kr.or.ddit.msg.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

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

import kr.or.ddit.mail.vo.MailVO;
import kr.or.ddit.msg.service.MsgServiceImpl;
import kr.or.ddit.msg.vo.MsgVO;
import kr.or.ddit.security.CustomUser;
import kr.or.ddit.user.vo.UserVO;
import lombok.extern.slf4j.Slf4j;

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
 */
@Slf4j
@RequestMapping("/msg")
@Controller
@Secured({"ROLE_USER","ROLE_ADMIN"})
public class MsgController {
	
	@Autowired private MsgServiceImpl msgServiceImpl;
	
	@ResponseBody
	@GetMapping("/readAll")
	public String readAll(MsgVO m) {
		this.msgServiceImpl.readAllUpdate(m);
		return "success";
	}
	
	/**
	 * 종모양 전체 토스트 알람
	 * @param MsgVO m
	 * @return List<MsgVO>
	 */
	@ResponseBody
	@GetMapping("/alarm")
	public List<MsgVO> alarm(MsgVO m){
		return this.msgServiceImpl.listAlarm(m);
	}
	
	/**
	 * 쪽지 발송시 DB에 저장, 성공여부 보냄
	 * @param MsgVO msg
	 * @return String
	 */
	@ResponseBody
	@PostMapping("/save")
	public String save(MsgVO msg) {
		int result = this.msgServiceImpl.insert(msg);
		return "success";
	}
	
	/**
	 * 쪽지보내는 페이지
	 * @param MsgVO msg
	 * @param Model model
	 * @return String
	 */
	@GetMapping("/compose")
	public String compose(MsgVO msg,Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		CustomUser customUser = (CustomUser) auth.getPrincipal();
		String dsptch =customUser.getUserVO().getUserId();
		model.addAttribute("dsptch",dsptch);
		model.addAttribute("msg",msg);
		return "msg/compose";
	}
	
	/**
	 * 쪽지함 페이지
	 * @return String
	 */
	@GetMapping("/inbox")
	public String inbox() {
		return "msg/inbox";
	}
	
	/**
	 * 쪽지 발송, 쪽지 발송시 redirect:/msg/inbox로 보냄
	 * @return String
	 * @throws InterruptedException
	 */
	@PostMapping("/send")
	public String send() throws InterruptedException {
		return "redirect:/msg/inbox";
	}
	
	/**
	 * 사용자가 받는 쪽지 내용 페이지
	 * @param MsgVO msg
	 * @param Model model
	 * @return String
	 */
	@GetMapping("/detailReceiver")
	public String detailReceiver(MsgVO msg, Model model) {
		msg = this.msgServiceImpl.detailReceiver(msg);
		model.addAttribute("msg",msg);
		return "msg/detail";
	}
	
	/**
	 * 사용자가 보낸 쪽지 내용 페이지
	 * @param MsgVO msg
	 * @param Model model
	 * @return String
	 */
	@GetMapping("/detailSender")
	public String detailSender(MsgVO msg, Model model) {
		msg = this.msgServiceImpl.detailSender(msg);
		model.addAttribute("msg",msg);
		return "msg/detail";
	}
	
	/**
	 * 보낸 쪽지함
	 * @param MsgVO msg
	 * @return List<MsgVO>
	 */
	@ResponseBody
	@PostMapping("/sender")
	public List<MsgVO> sender(MsgVO msg){
		return this.msgServiceImpl.listSender(msg);
	}
	
	/**
	 * 받은 쪽지함
	 * @param MsgVO msg
	 * @return String
	 */
	@ResponseBody
	@PostMapping("/receiver")
	public List<MsgVO> receiver(MsgVO msg){
		return this.msgServiceImpl.listReceiver(msg);
	}
	
	/**
	 * 중요 쪽지함
	 * @param MsgVO msg
	 * @return List<MsgVO>
	 */
	@ResponseBody
	@PostMapping("/importMsg")
	public List<MsgVO> MsgImport(MsgVO msg){
		msg.setStatCd("MM005");
		return this.msgServiceImpl.listReceiver(msg);
	}
	
	/**
	 * 휴지통
	 * @param MsgVO msg
	 * @return List<MsgVO>
	 */
	@ResponseBody
	@PostMapping("/trash")
	public List<MsgVO> trash(MsgVO msg){
		msg.setStatCd("MM003");
		return this.msgServiceImpl.trash(msg);
	}
	
	/**
	 * 중요 쪽지 설정
	 * @param MsgVO msg
	 * @return String
	 */
	@ResponseBody
	@GetMapping("/importSet")
	public String importSet(MsgVO msg) {
		int result = this.msgServiceImpl.importMsg(msg);
		return "success";
	}
	
	/**
	 * 휴지통 설정
	 * @param MsgVO msg
	 * @return String
	 */
	@ResponseBody
	@PostMapping("/trashSet")
	public String trashSet(MsgVO msg) {
		int result = this.msgServiceImpl.trashSet(msg);
		return "success";
	}
	
	/**
	 * 삭제
	 * @param MsgVO msg
	 * @return String
	 */
	@ResponseBody
	@PostMapping("/delete")
	public String delete(MsgVO msg) {
		int result = this.msgServiceImpl.delete(msg);
		return "success";
	}
	
	/**
	 * 복원하기
	 * @param MsgVO msg
	 * @return String
	 */
	@ResponseBody
	@GetMapping("/restore")
	public String restore(MsgVO msg) {
		int result = this.msgServiceImpl.restore(msg);
		return "success";
	}
	
}
