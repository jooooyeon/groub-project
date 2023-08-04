package kr.or.ddit.notice.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;

import kr.or.ddit.bbscommon.BbsAtchVO;
import kr.or.ddit.notice.controller.NoticeController;
import kr.or.ddit.notice.mapper.NoticeMapper;
import kr.or.ddit.notice.service.NoticeService;
import kr.or.ddit.notice.vo.NoticeVO;
import kr.or.ddit.notice.vo.PstHdVO;

/**
 * 공지사항 게시판 controller
 * 
 * @author 전아현
 * @since 2023.07.12
 * @version 1.0
 * @see
 *
 *      <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일     수정자           수정내용
 *  -------    --------    ---------------------------
 *  2023.07.12  전아현          최초 생성
 *	2023.07.13	전아현         게시글 등록 
 *	2023.07.19  전아현   
 *  2023.07.22  김종명			controller secured 추가      
 *      </pre>
 */

@Secured({"ROLE_ADMIN","ROLE_USER"})
@Controller
@RequestMapping("/notice")
public class NoticeController {

	@Autowired
	NoticeService noticeService;

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	/**
	 * 공지사항 목록을 출력한다.
	 * 
	 * @param model 화면모델
	 * @param
	 * @return forward:/notice/list
	 */
	//공지사항 목록
	@GetMapping("/list")
	public String list(Model model) {

		List<NoticeVO> data = this.noticeService.list();
		log.info("data : " + data);
		model.addAttribute("data", data);

		return "notice/list";

	}

	/**
	 * 공지사항 목록 중 게시물 하나를 출력한다.
	 * 
	 * @param noticeVO model 화면모델
	 * @param
	 * @return forward:/notice/detail
	 */

	//공지사항 상세보기
	@RequestMapping("/detail")
	public String detail(NoticeVO noticeVO, Model model) {
		log.info("noticeVO : " + noticeVO);

		// 내용보기
		noticeVO = this.noticeService.detail(noticeVO);
		log.info("detail noticeVO : " + noticeVO);
		model.addAttribute("data", noticeVO);

		// 조회수 증가
		noticeService.inqCnt(noticeVO.getPstNo());

//			//댓글 가져오기
//			List<CmntVO> comment = this.noticeService.commentSelect(cmntVO);
//			model.addAttribute("comment",comment);

		return "notice/detail";
	}
	
	/**
	 * 공지사항 게시물을 등록한다.
	 * 
	 * @param model 화면모델
	 * @param
	 * @return forward:/notice/register
	 */
	
	//공지사항 글 작성
	@Secured("ROLE_ADMIN")
	@GetMapping("/register")
	public String register(Model model, PstHdVO pstHdVO) {
		//공통코드에서 
		pstHdVO.setGrCd("NT");	

		List<PstHdVO> pstHdVOList = this.noticeService.getHd(pstHdVO);
		log.info("pstHdVOList : " + pstHdVOList);
		
		model.addAttribute("data",pstHdVOList);
		
		return "notice/register";
	}	

	//공지사항 글 작성
	@Secured("ROLE_ADMIN")
	@PostMapping("/register")
	public String registerPost(Model model, @ModelAttribute NoticeVO noticeVO,Principal principal) {
		//로그인 한 아이디 받음
		String userId = principal.getName();

		noticeVO.setUserId(userId);
		
		log.info("result: " + noticeVO);
		int result = noticeService.register(noticeVO);
		System.out.println("result : " + result);
		
		return "redirect:/notice/list";
	}	
	
	/**
	 * 공지사항 수정
	 * @param model
	 * @param noticeVO
	 * @param principal
	 * @return forward:/notice/update
	 */
	@Secured("ROLE_ADMIN")
	@GetMapping("/update")
	public String update(Model model, @ModelAttribute NoticeVO noticeVO) {
		
		noticeVO = this.noticeService.detail(noticeVO);
		
		log.info("update post noticeVO" + noticeVO);
		
		model.addAttribute("data", noticeVO);
		
		return "notice/update";
		
	}
	
	/**
	 * 공지사항 수정
	 * @param model
	 * @param noticeVO
	 * @param principal
	 * @return forward:/notice/list
	 */
	@Secured("ROLE_ADMIN")
	@PostMapping("/update")
	public String update(Model model, @ModelAttribute NoticeVO noticeVO, Principal principal) {
		log.info("update post noticeVO" + noticeVO);
		
		int result = noticeService.update(noticeVO);
		
		return "redirect:/notice/list";
		
	}
	
	/**
	 * 공지사항 삭제
	 * @param noticeVO
	 * @return
	 */
	@Secured("ROLE_ADMIN")
	@ResponseBody
	@PostMapping("/delete")
	public String delete(@RequestBody NoticeVO noticeVO) {
		log.info("delete : " + noticeVO);
		
		int result = noticeService.delete(noticeVO);
		
		if (result > 0) {
			return "success";
		} else {
			return "fail";
		}
		
	}
	
	/**
	 * 게시글 첨부파일 변경
	 * @param bbsAtchVO
	 * @return 결과 메시지
	 */
	@Secured("ROLE_ADMIN")
	@ResponseBody
	@PostMapping("/updateFileExist")
	public String updateFileExist(@RequestBody BbsAtchVO bbsAtchVO ) {
		log.info("updateFileExist bbsAtchVO : " + bbsAtchVO);
	    
		//FILE_EXIST 값을 N으로 처리
	    int result = noticeService.updateFileExist(bbsAtchVO);
	    log.info("result : " + result);
	    
	    if (result > 0) {
	        return "success";
	    } else {
	        return "fail";
	    }
	}

	/**
	 * 게시글 첨부파일 삭제 취소
	 * @param bbsAtchVO
	 * @return 결과 메시지
	 */
	@Secured("ROLE_ADMIN")
	@ResponseBody
	@PostMapping("/updateFileExistCancel")
	public String updateFileExistCancel(@RequestBody BbsAtchVO bbsAtchVO ) {
		log.info("updateFileExist bbsAtchVO : " + bbsAtchVO);
		
		//FILE_EXIST 값을 N으로 처리
		int result = noticeService.updateFileExistCancel(bbsAtchVO);
		log.info("result : " + result);
		
		if (result > 0) {
			return "success";
		} else {
			return "fail";
		}
	}	
	

}









