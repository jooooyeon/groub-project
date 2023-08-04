package kr.or.ddit;

import java.security.Principal;
import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.or.ddit.draft.service.DraftService;
import kr.or.ddit.notice.service.NoticeService;
import kr.or.ddit.notice.service.impl.NoticeServiceImpl;
import kr.or.ddit.notice.vo.NoticeVO;
import kr.or.ddit.reservation.service.OffmlRsvtService;
import kr.or.ddit.reservation.service.VhclRsvtService;
import kr.or.ddit.reservation.vo.OffmRsvtVO;
import kr.or.ddit.reservation.vo.VhclRsvtVO;
import lombok.extern.slf4j.Slf4j;

/**
 * 메인 화면 구성에 관한 처리를 수행하고
 * 웹 화면으로 전달하는 Controller를 정의한다
 * @author 노태현
 * @since 2023.07.21
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일      	수정자           수정내용
 *  -------    --------    ---------------------------
 *   2023.07.20  노태현          최초 생성
 *
 * </pre>
 */
@Slf4j
@Secured({ "ROLE_USER", "ROLE_ADMIN" })
@Controller
public class HomeController {

	@Autowired
	NoticeService noticeService;

	@Autowired
	private VhclRsvtService vhclRsvtService;

	@Autowired
	private OffmlRsvtService offmlRsvtService;
	
	@Autowired
	private DraftService draftService;

	@GetMapping("/")
	public String home(Model model, Principal principal) throws Exception {
		log.info("home");

		String userId = principal.getName();
		//카드에 등록될 로직 처리

		/**
		 * 메인페이지의 공지사항 카드에 리스트 출력
		 */
		List<NoticeVO> noticeList = this.noticeService.selectMainPageList();
		model.addAttribute("noticeList" , noticeList);


		/**
		 * 메인페이지의 당일 예약 목록 출력
		 */
		List<OffmRsvtVO> offmList = this.offmlRsvtService.getMylistToday(userId);
		List<VhclRsvtVO> vhclList = this.vhclRsvtService.getMylistToday(userId);
		model.addAttribute("offmList" , offmList);
		model.addAttribute("vhclList" , vhclList);

		return "home";
	}

}
