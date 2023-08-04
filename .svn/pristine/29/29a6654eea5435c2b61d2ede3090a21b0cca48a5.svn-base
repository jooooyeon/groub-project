package kr.or.ddit.empinfo.controller;

import java.io.File;
import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.empinfo.service.EmpInfoService;
import kr.or.ddit.empinfo.vo.EmpInfoVO;
import kr.or.ddit.security.CustomUser;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.vo.UserVO;
import kr.or.ddit.util.CommonFile;


/**
 * 내정보페이지로 개인정보 확인 및 비밀번호 변경, 얼굴/음성 인식 등록기능을
 * 웹화면으로 전달하는  Controller를 정의한다
 * @author 노태현,이주연
 * @since 2023.07.18
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일         수정자           수정내용
 *  -------    --------    ---------------------------
 *   2023.07.18  노태현          최초 생성
 *   2023.07.18  이주연          음성인식,비밀번호변경 추가
 *
 * </pre>
 */
@Controller
public class MyPageController {
   private final Logger log = LoggerFactory.getLogger(this.getClass());
   
   @Inject
   UserService userService;
   
   @Autowired
   EmpInfoService empInfoService;
   
    @Autowired
    private HttpServletRequest request;
   
    
    
    /**
     * 내정보
     * @param mav를 통한 값 전달
     * @param authentication 접속자id 확인
     * @return UserVO의 값
     */
   @RequestMapping("/mypage")
   public ModelAndView myPage(ModelAndView mav, Authentication authentication) {
      CustomUser customUser = (CustomUser) authentication.getPrincipal();
      UserVO userVO = customUser.getUserVO();

      mav.setViewName("empInfo/myPage");
      mav.addObject("userVO", userVO);

      return mav;
   }





   /**
    * 계정의 얼굴인식 사용여부 상태 값을 변경한다.
    * @param userId 변경하고자 하는 대상
    * @return 결과 메시지
    */
   @Transactional
   @PostMapping("/mypage/faceAct")
   @ResponseBody
   public String accountAct(@RequestParam("userId") String userId) {
       int cnt = 0;
       String message = null;

       cnt = userService.faceAct(userId);

       if(cnt==1) {//계정 활성화
           message = "success";
       }else {
           message ="fail";
       }
       return message;
   };
   
   
   
   /**
    * 인물사진 변경
    * @param file 변경하고자하는 사진 파일
    * @param authentication 접속자id확인
    * @param empInfoVO 경로 지정
    * @return 결과정보
    * @throws IOException
    */
   @PostMapping("/mypage/personpic")
   @ResponseBody
   public String personpic(@RequestParam("personpic") MultipartFile file, Authentication authentication, EmpInfoVO empInfoVO) throws IOException {
       //log.info("Personpic에왔다");
       CustomUser customUser = (CustomUser) authentication.getPrincipal();
       UserVO userVO = customUser.getUserVO();
       String userId = userVO.getUserId();
       empInfoVO.setUserId(userId);

       // 파일 업로드
       if (!file.isEmpty()) {
           String originalFilename = file.getOriginalFilename();
           String extension = FilenameUtils.getExtension(originalFilename); // 파일의 확장자 추출
           String saveFileName = userId + "." + extension; // 저장될 파일 이름

           // 파일 저장
           String savePath = CommonFile.uploadFolderUserPic + File.separator + saveFileName;
           //log.info(savePath);
           File saveFile = new File(savePath);
           file.transferTo(saveFile);
           //log.info("saveFile : ", saveFile);

           String userImg = savePath.split("webapp")[1];
           //log.info(userImg);

           empInfoVO.setUserImg(userImg);

           int result = this.empInfoService.personpic(empInfoVO);

           if (result > 0) {
               return "success";
           }
       }

       return "fail";
   }
   
   
   
   
   /**
    * 서명사진 변경
    * @param file 변경하고자하는 사진 파일
    * @param authentication 접속자id확인
    * @param empInfoVO 경로 지정
    * @return 결과정보
    * @throws IOException
    */
   @PostMapping("/mypage/regSign")
   @ResponseBody
   public String regSign(@RequestParam("regSign") MultipartFile file, Authentication authentication, EmpInfoVO empInfoVO) throws IOException {
      log.info("regSign에왔다");
      CustomUser customUser = (CustomUser) authentication.getPrincipal();
      UserVO userVO = customUser.getUserVO();
      String userId = userVO.getUserId();
      empInfoVO.setUserId(userId);
      
      // 파일 업로드
      if (!file.isEmpty()) {
         String originalFilename = file.getOriginalFilename();
         String extension = FilenameUtils.getExtension(originalFilename); // 파일의 확장자 추출
         String saveFileName = "sign" + userId + "." + extension; // 저장될 파일 이름
         
         // 파일 저장
         String savePath = CommonFile.uploadFolderUserSign + File.separator + saveFileName;
         //log.info(savePath);
         File saveFile = new File(savePath);
         file.transferTo(saveFile);
         //log.info("saveFile : ", saveFile);
         
         String signImg = savePath.split("webapp")[1];
         //log.info(userImg);
         
         empInfoVO.setSignImg(signImg);
         
         int result = this.empInfoService.regSign(empInfoVO);
         
         if (result > 0) {
            return "success";
         }
      }
      
      return "fail";
   }
   
   
   
   /**
    * 비밀번호 변경
    * @param userVO userId, userPswd
    * @return 결과정보
    */
   @PostMapping("/mypage/changePw")
   @ResponseBody
   public String changePw(@RequestBody UserVO userVO) {
      log.info("changePw에 왔다!");
      log.info("changePw userVO {}", userVO);
          
      
      int result = this.empInfoService.changePw(userVO);
      
      if(result < 0) {
         return "success";
      }else {
         return "fail";
      }
      
   }//changePw
   
   
   
}