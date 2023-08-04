package kr.or.ddit.community.anonyboard.controller;


import java.security.Principal;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.bbscommon.BbsAtchVO;
import kr.or.ddit.community.anonyboard.service.AnonyBoardService;
import kr.or.ddit.community.anonyboard.vo.AnonyBoardVO;
import kr.or.ddit.community.anonyboard.vo.AnonyCmntVO;
import kr.or.ddit.community.anonyboard.vo.AnonyPstHdVO;
import kr.or.ddit.user.vo.UserVO;

/**
 * 커뮤니티 탭에서 익명으로 사용가능한 게시판에 대한
 * 웹화면으로 전달하는  Controller를 정의한다
 * @author 이주연
 * @since 2023.07.18
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일      	수정자           수정내용
 *  -------    --------    ---------------------------
 *   2023.07.18  이주연          최초 생성
 *
 * </pre>
 */
@RequestMapping("/community/anonyboard")
@Controller
public class AnonyBoardController {
	
	@Autowired
	AnonyBoardService anonyBoardService;

	private final Logger log = LoggerFactory.getLogger(this.getClass());


	/**
	 * 익명게시판의 목록
	 * @param model JSP화면으로 넘겨주기 위함
	 * @return 익명게시판 목록 페이지로 이동
	 */
	@RequestMapping("/list")
	public String list(Model model) {
		
		List<AnonyBoardVO> data = this.anonyBoardService.list();
		log.info("data : " + data);
		model.addAttribute("data",data);
		
		
		
		return "community/anonyBoard/anonyBoardList";
	}
	
	
	
	/**
	 * 익명게시판의 상세보기
	 * @param anonyBoardVO 게시판의 내용을 불러오기 위함
	 * @param anonyCmntVO  게시판의 댓글을 불러오기 위함
	 * @param model JSP화면으로 넘겨주기 위함
	 * @return 익명게시판 상세보기 페이지로 이동
	 */
	@RequestMapping("/detail")
	public String detail(AnonyBoardVO anonyBoardVO, AnonyCmntVO anonyCmntVO,  Model model) {
		log.info("anonyBoardVO : " + anonyBoardVO);
		
		
		//내용보기
		anonyBoardVO = this.anonyBoardService.detail(anonyBoardVO);
		log.info("detail anonyBoardVO : " + anonyBoardVO );
		model.addAttribute("data",anonyBoardVO);
		
		//조회수 증가
		anonyBoardService.inqCnt(anonyBoardVO.getPstNo());
		
		//댓글 가져오기
		List<AnonyCmntVO> comment = this.anonyBoardService.commentSelect(anonyCmntVO);
		model.addAttribute("comment",comment);
		
		
		return "community/anonyBoard/anonyBoardDetail";
	}
	
	
	
	
	/**
	 * 익명게시판의 게시글 작성
	 * @param model JSP화면으로 넘겨주기 위함
	 * @param hd 머리말(헤더)를 전달
	 * @return 익명게시판 작성페이지로 이동
	 */
	@GetMapping("/register")
	public String register(Model model, AnonyPstHdVO hd) {
		hd.setGrCd("HD");	

		List<AnonyPstHdVO> pstHdVOList = this.anonyBoardService.getHd(hd);
		log.info("pstHdVOList : " + pstHdVOList);
		
		model.addAttribute("data",pstHdVOList);
		
		return "community/anonyBoard/anonyBoardRegister";
	}
	
	
	/**
	 * 익명 게시판의 게시글 작성
	 * @param anonyBoardVO 게시글을 저장하기 위함
	 * @param principal ID를 받아오기 위함
	 * @return 익명게시판 목록페이지로 이동
	 */
	@PostMapping("/register")
	public String registerPost(@ModelAttribute AnonyBoardVO anonyBoardVO,Principal principal) {
		//로그인 한 아이디 받음
		String userId = principal.getName();

		anonyBoardVO.setUserId(userId);
		
		log.info("result: " + anonyBoardVO);
		int result = anonyBoardService.register(anonyBoardVO);
		System.out.println("result : " + result);
		
		return "redirect:/community/anonyboard/list";
	}
	

	/**
	 * 익명 게시판의 게시글 수정
	 * @param model JSP화면으로 넘겨주기 위함
	 * @param anonyBoardVO 내용을 불러오기 위함
	 * @return 익명 게시판 게시글 수정 페이지로 이동
	 */
	@GetMapping("/update")
	public String update(Model model, @ModelAttribute AnonyBoardVO anonyBoardVO) {
	    // pstNo를 가공하거나 필요한 로직을 처리한 후 data 변수에 할당
		anonyBoardVO = this.anonyBoardService.detail(anonyBoardVO);
		
		log.info("update anonyBoardVO" + anonyBoardVO);
		model.addAttribute("data",anonyBoardVO);

	    return "community/anonyBoard/anonyBoardUpdate"; 
	}

	/**
	 * 익명 게시판의 게시글 수정
	 * @param model
	 * @param anonyBoardVO 게시글을 저장하기 위함
	 * @param principal 
	 * @return 익명게시판 목록페이지로 이동
	 */
	@PostMapping("/update")
	public String update(Model model,@ModelAttribute AnonyBoardVO anonyBoardVO, Principal principal) {
		log.info("updatePost다!");
		log.info("update post anonyBoardVO : " + anonyBoardVO);
		
		int result = anonyBoardService.update(anonyBoardVO);
		
		return "redirect:/community/anonyboard/list";
	}

	/**
	 * 익명 게시판의 게시글 삭제
	 * @param anonyBoardVO
	 * @return 결과 메시지
	 */
	@ResponseBody
	@PostMapping("/deletePost")
	public String deletePost(@RequestBody AnonyBoardVO anonyBoardVO ) {
		log.info("deletePost boardVo : " + anonyBoardVO);
	    
	    int result = anonyBoardService.deletePost(anonyBoardVO);
	    if (result > 0) {
	        return "success";
	    } else {
	        return "fail";
	    }
	}


	/**
	 * 익명 게시판의 첨부파일 변경
	 * @param bbsAtchVO 첨부파일
	 * @return 결과메시지
	 */
	@ResponseBody
	@PostMapping("/updateFileExist")
	public String updateFileExist(@RequestBody BbsAtchVO bbsAtchVO ) {
		log.info("updateFileExist bbsAtchVO : " + bbsAtchVO);
	    
		//FILE_EXIST 값을 N으로 처리
	    int result = anonyBoardService.updateFileExist(bbsAtchVO);
	    log.info("result : " + result);
	    
	    if (result > 0) {
	        return "success";
	    } else {
	        return "fail";
	    }
	}


	/**
	 * 익명 게시판의 첨부파일 삭제 취소(되돌리기)
	 * @param bbsAtchVO 첨부파일 
	 * @return 결과 메시지
	 */ 
	@ResponseBody
	@PostMapping("/updateFileExistCancel")
	public String updateFileExistCancel(@RequestBody BbsAtchVO bbsAtchVO ) {
		log.info("updateFileExist bbsAtchVO : " + bbsAtchVO);
		
		//FILE_EXIST 값을 N으로 처리
		int result = anonyBoardService.updateFileExistCancel(bbsAtchVO);
		log.info("result : " + result);
		
		if (result > 0) {
			return "success";
		} else {
			return "fail";
		}
	}
	
	
	
	//=====================================댓글===============================================
	
	/**
	 * 익명게시판 댓글 작성
	 * @param anonyCmntVO
	 * @return 결과 메시지
	 */
	@ResponseBody
	@PostMapping("/commentRegister")
	public String commentRegister(@RequestBody AnonyCmntVO anonyCmntVO ) {
		log.info("commentRegister anonyCmntVO : " + anonyCmntVO);
		//anonyCmntVO : AnonyCmntVO(cmntNo=0, pstNo=48, userId=NAVER_2014030001, 
		//cmntCn=ggg, regDt=null, mdfcnDt=null, delDt=null, delrNm=null,
		//upCmntNo=0, cmntLv=null)
		int result = anonyBoardService.commentRegister(anonyCmntVO);
		log.info("commentRegister result : " + result);
		
		if (result > 0) {
			return "success";
		} else {
			return "fail";
		}
	}
	
	
	
	/**
	 * 익명게시판 대댓글 작성
	 * @param anonyCmntVO
	 * @return 결과 메시지
	 */
	@ResponseBody
	@PostMapping("/commentInComment")
	public String commentInComment(@RequestBody AnonyCmntVO anonyCmntVO ) {
		log.info("commentInComment anonyCmntVO : " + anonyCmntVO);
		//anonyCmntVO : AnonyCmntVO(cmntNo=0, pstNo=48, userId=NAVER_2014030001, 
		//cmntCn=ggg, regDt=null, mdfcnDt=null, delDt=null, delrNm=null,
		//upCmntNo=0, cmntLv=null)
		int result = anonyBoardService.commentInCommentRegister(anonyCmntVO);
		log.info("commentInComment result : " + result);
		
		if (result > 0) {
			return "success";
		} else {
			return "fail";
		}
	}
	

	/**
	 * 익명게시판 댓글 삭제
	 * @param anonyCmntVO
	 * @return 결과 메시지
	 */
	@ResponseBody
	@PostMapping("/deleteCommentPost")
	public String deleteCommentPost(@RequestBody AnonyCmntVO anonyCmntVO) {
		log.info("deleteCommentPost anonyCmntVO : " + anonyCmntVO);
		
		int result = anonyBoardService.deleteComment(anonyCmntVO);
		log.info("deleteCommentPost result" + result);
		
		if (result > 0) {
			return "success";
		} else {
			return "fail";
		}
	}
	
	/**
	 * 익명게시판 댓글 수정
	 * @param anonyCmntVO
	 * @return 결과 메시지
	 */
	@ResponseBody
	@PostMapping("/commentModify")
	public String commentModifyPost(@RequestBody AnonyCmntVO anonyCmntVO) {
		log.info("commentModifyPost : " + anonyCmntVO);
		
		int result = anonyBoardService.commentModify(anonyCmntVO);
		log.info("commentModifyPost result" + result);
		if (result > 0) {
			return "success";
		} else {
			return "fail";
		}
	}
	
	
	
	
	
	
}
