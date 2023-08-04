package kr.or.ddit.community.board.controller;


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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.bbscommon.BbsAtchVO;
import kr.or.ddit.community.board.service.BoardService;
import kr.or.ddit.community.board.vo.BoardVO;
import kr.or.ddit.community.board.vo.CmntVO;
import kr.or.ddit.community.board.vo.PstHdVO;
import kr.or.ddit.user.vo.UserVO;


/**
 * 커뮤니티 탭에서 누구나 사용가능한 게시판에 대한
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
@RequestMapping("/community/board")
@Controller
public class Boardcontroller {
	
	@Autowired
	BoardService boardService;

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	/**
	 * 게시판의 목록
	 * @param model
	 * @return 게시판 목록 페이지로 이동
	 */
	@RequestMapping("/list")
	public String list(Model model) {
		
		List<BoardVO> data = this.boardService.list();
		log.info("data : " + data);
		model.addAttribute("data",data);
		
		return "community/board/boardList";
	}
	
	
	
	/**
	 * 게시판의 상세보기
	 * @param boardVO
	 * @param cmntVO
	 * @param model
	 * @return 게시판 상세보기 페이지로 이동
	 */
	@RequestMapping("/detail")
	public String detail(BoardVO boardVO, CmntVO cmntVO,  Model model) {
		log.info("boardVO : " + boardVO);
		
		//내용보기
		boardVO = this.boardService.detail(boardVO);
		log.info("detail boardVO : " + boardVO );
		model.addAttribute("data",boardVO);
		
		//조회수 증가
		boardService.inqCnt(boardVO.getPstNo());
		
		//댓글 가져오기
		List<CmntVO> comment = this.boardService.commentSelect(cmntVO);
		model.addAttribute("comment",comment);
		
		
		return "community/board/boardDetail";
	}
	
	
	/**
	 * 게시글 작성
	 * @param model
	 * @param hd 머리말 가져오기
	 * @return 작성페이지로 이동
	 */
	@GetMapping("/register")
	public String register(Model model, PstHdVO hd) {
		hd.setGrCd("HD");	

		List<PstHdVO> pstHdVOList = this.boardService.getHd(hd);
		log.info("pstHdVOList : " + pstHdVOList);
		
		model.addAttribute("data",pstHdVOList);
		
		return "community/board/boardRegister";
	}
	
	
	/**
	 * 게시글 작성
	 * @param model
	 * @param boardVO
	 * @param principal 로그인한 아이디로 저장
	 * @return 게시판 목록페이지로 이동
	 */
	@PostMapping("/register")
	public String registerPost(Model model,@ModelAttribute BoardVO boardVO,Principal principal) {
		//로그인 한 아이디 받음
		String userId = principal.getName();

		boardVO.setUserId(userId);
		
		log.info("result: " + boardVO);
		int result = boardService.register(boardVO);
		System.out.println("result : " + result);
		
		return "redirect:/community/board/list";
	}
	


	/**
	 * 게시글 수정
	 * @param model
	 * @param boardVO
	 * @return 수정페이지로이동
	 */
	@GetMapping("/update")
	public String update(Model model, @ModelAttribute BoardVO boardVO) {
	    // pstNo를 가공하거나 필요한 로직을 처리한 후 data 변수에 할당
	    
		boardVO = this.boardService.detail(boardVO);
		
		log.info("update boardVO" + boardVO);
		model.addAttribute("data",boardVO);

	    return "community/board/boardUpdate"; 
	}

	/**
	 * 게시글 수정
	 * @param model
	 * @param boardVO
	 * @param principal
	 * @return 목록페이지로 이동
	 */
	@PostMapping("/update")
	public String update(Model model,@ModelAttribute BoardVO boardVO, Principal principal) {
		log.info("update post boardVO : " + boardVO);
		
		int result = boardService.update(boardVO);
		
		return "redirect:/community/board/list";
	}


	/**
	 * 게시글 삭제
	 * @param boardVO
	 * @return 결과 메시지
	 */
	@ResponseBody
	@PostMapping("/deletePost")
	public String deletePost(@RequestBody BoardVO boardVO ) {
		log.info("deletePost boardVo : " + boardVO);
	    
	    int result = boardService.deletePost(boardVO);
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
	@ResponseBody
	@PostMapping("/updateFileExist")
	public String updateFileExist(@RequestBody BbsAtchVO bbsAtchVO ) {
		log.info("updateFileExist bbsAtchVO : " + bbsAtchVO);
	    
		//FILE_EXIST 값을 N으로 처리
	    int result = boardService.updateFileExist(bbsAtchVO);
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
	@ResponseBody
	@PostMapping("/updateFileExistCancel")
	public String updateFileExistCancel(@RequestBody BbsAtchVO bbsAtchVO ) {
		log.info("updateFileExist bbsAtchVO : " + bbsAtchVO);
		
		//FILE_EXIST 값을 N으로 처리
		int result = boardService.updateFileExistCancel(bbsAtchVO);
		log.info("result : " + result);
		
		if (result > 0) {
			return "success";
		} else {
			return "fail";
		}
	}
	
	
	
	//=====================================댓글===============================================
	
	/**
	 * 게시판 댓글 작성
	 * @param cmntVO
	 * @return 결과 메시지
	 */
	@ResponseBody
	@PostMapping("/commentRegister")
	public String commentRegister(@RequestBody CmntVO cmntVO ) {
		log.info("commentRegister cmntVO : " + cmntVO);
		
		int result = boardService.commentRegister(cmntVO);
		log.info("commentRegister result : " + result);
		
		if (result > 0) {
			return "success";
		} else {
			return "fail";
		}
	}
	
	
	
	/**
	 * 게시판 대댓글 작성
	 * @param cmntVO
	 * @return 결과 메시지
	 */
	@ResponseBody
	@PostMapping("/commentInComment")
	public String commentInComment(@RequestBody CmntVO cmntVO ) {
		log.info("commentInComment cmntVO : " + cmntVO);

		int result = boardService.commentInCommentRegister(cmntVO);
		log.info("commentInComment result : " + result);
		
		if (result > 0) {
			return "success";
		} else {
			return "fail";
		}
	}
	
	/**
	 * 게시판 대댓글 삭제
	 * @param cmntVO
	 * @return 결과 메시지
	 */ 
	@ResponseBody
	@PostMapping("/deleteCommentPost")
	public String deleteCommentPost(@RequestBody CmntVO cmntVO) {
		log.info("deleteCommentPost cmntVO : " + cmntVO);
		
		int result = boardService.deleteComment(cmntVO);
		log.info("deleteCommentPost result" + result);
		
		if (result > 0) {
			return "success";
		} else {
			return "fail";
		}
	}
	
	
	/**
	 * 게시판 댓글 수정
	 * @param cmntVO
	 * @return 결과 메시지
	 */
	@ResponseBody
	@PostMapping("/commentModify")
	public String commentModifyPost(@RequestBody CmntVO cmntVO) {
		log.info("commentModifyPost : " + cmntVO);
		
		int result = boardService.commentModify(cmntVO);
		log.info("commentModifyPost result" + result);
		if (result > 0) {
			return "success";
		} else {
			return "fail";
		}
	}
	
	
	
	
	
	
}
