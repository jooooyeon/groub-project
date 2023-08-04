package kr.or.ddit.empinfo.service;

import java.util.List;

import kr.or.ddit.empinfo.vo.CrtfctVO;
import kr.or.ddit.empinfo.vo.EmpInfoCertificationVO;
import kr.or.ddit.empinfo.vo.EmpInfoVO;
import kr.or.ddit.empinfo.vo.EmployeesVacVO;
import kr.or.ddit.empinfo.vo.FamManageCodeVO;
import kr.or.ddit.empinfo.vo.FamVO;
import kr.or.ddit.empinfo.vo.PaymentEmployeeVO;
import kr.or.ddit.empinfo.vo.PaymentVO;
import kr.or.ddit.empinfo.vo.VacationVO;
import kr.or.ddit.user.vo.UserVO;

public interface EmpInfoService {

   //인사정보 메인 값 읽어오기
   public EmpInfoVO detail(EmpInfoVO empInfoVO);

   //인사정보 신상정보 변경
   public int updatePersonal(EmpInfoVO empInfoVO);
   
   //인사정보 자격증정보 삭제
   public int deleteCrtfct(EmpInfoCertificationVO EmpInfoCertificationVO);
   
   //자격증 리스트 불러오기
   public List<CrtfctVO> selectCrtfct();
   
   //자격증 추가
   public int insertCrtfct(EmpInfoCertificationVO empInfoCertificationVO);
   
   //가족 삭제
   public int deleteFam(FamVO famVO);
   
   //공통코드 중 가족관계불러오기
   public List<FamManageCodeVO> selectFamManageCode();
   
   
   //연차 리스트 현재년도
   public List<VacationVO> vacGrant(VacationVO vacationVO);

   //총연차 사용연차 내역
   public VacationVO vacMain(VacationVO vacationVO);
   
   //입사일 확인
   public VacationVO findJoinYear(VacationVO vacationVO);
   
   //연차 사용 내역
   public List<VacationVO> detailUsedVac(VacationVO vacationVO);

   //로그인 아이디에 해당되는 가족 데이터 삭제
   public int deleteFamUserId(EmpInfoVO empInfoVO);

   //로그인 아이디에 해당 는 가족 insert
   public int insertFam(FamVO famVO);
   
   //연차 사용 내역 기존년도
   public List<VacationVO> showVacUsed(VacationVO vacationVO);
   
   //전직원 연차
   public List<EmployeesVacVO> employeesVacVO(String coId);
   
   
   
   //급여 리스트
   public List<PaymentVO> paymentVO(PaymentVO paymentVO);
   
   //급여 상세
   public PaymentVO paymentDetail(PaymentVO paymentVO);
   

   //급여 계좌 조회
   public PaymentVO selectBank(PaymentVO paymentVO);
   
   //급여계좌 변경
   public int paymentUpdate(PaymentVO paymentVO);
   
   
   //전 직원 급여 리스트
   public List<PaymentEmployeeVO> paymentEmployeeList(PaymentEmployeeVO paymentEmployeeVO);
   
   //전 직원 급여 리스트 엑셀 다운
   public List<PaymentVO> paymentEmployeeExcel(PaymentVO paymentVO);
   
   
   //직원 사진 변경하기
   public int personpic(EmpInfoVO empInfoVO);
   
   //서명 사진 변경하기
   public int regSign(EmpInfoVO empInfoVO);
   
   //직원 비밀번호 변경하기
   public int changePw(UserVO userVO);
   
}