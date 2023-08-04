package kr.or.ddit.empinfo.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.empinfo.mapper.EmpInfoMapper;
import kr.or.ddit.empinfo.service.EmpInfoService;
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
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EmpInfoServiceImpl implements EmpInfoService {

   @Inject
   EmpInfoMapper empInfoMapper;
   
   
   //인사정보 메인 리스트
   @Override
   public EmpInfoVO detail(EmpInfoVO empInfoVO) {
      return this.empInfoMapper.detail(empInfoVO);
   }
   //연차정보
   @Override
   public List<VacationVO> vacGrant(VacationVO vacationVO) {
      return this.empInfoMapper.vacGrant(vacationVO);
   }
   
   //총연차 사용연차 내역
   @Override
   public VacationVO vacMain(VacationVO vacationVO){
      return this.empInfoMapper.vacMain(vacationVO);
   }
   
   @Override
   public VacationVO findJoinYear(VacationVO vacationVO){
      return this.empInfoMapper.findJoinYear(vacationVO);
   }
   
   //인사정보 신상정보 수정
   @Override
   public int updatePersonal(EmpInfoVO empInfoVO) {
      return this.empInfoMapper.updatePersonal(empInfoVO);
   }
   
   //인사정보 자격증정보 삭제
   @Override
   public int deleteCrtfct(EmpInfoCertificationVO EmpInfoCertificationVO) {
      return this.empInfoMapper.deleteCrtfct(EmpInfoCertificationVO);
   }
   
   //자격증리스트
   @Override
   public List<CrtfctVO> selectCrtfct() {
      return this.empInfoMapper.selectCrtfct();
   }
   //자격증 추가
   @Override
   public int insertCrtfct(EmpInfoCertificationVO empInfoCertificationVO) {
      return this.empInfoMapper.insertCrtfct(empInfoCertificationVO);
   }
   //가족 삭제
   @Override
   public int deleteFam(FamVO famVO) {
      return this.empInfoMapper.deleteFam(famVO);
   }
   
   //로그인 아이디에 해당되는 가족 데이터 삭제
   @Override
   public int deleteFamUserId(EmpInfoVO empInfoVO) {
      //로그인 아이디에 해당되는 가족 데이터 삭제
      int result = this.empInfoMapper.deleteFamUserId(empInfoVO);
      
      List<FamVO> famVO = empInfoVO.getFamVO();
      
      for(FamVO vo : famVO) {
         result += this.empInfoMapper.insertFam(vo);
      }
      
      log.info("result : " + result);
      
      return result;
   }
      
   //로그인 아이디에 해당 는 가족 insert
   @Override
   public int insertFam(FamVO famVO) {
      return this.empInfoMapper.insertFam(famVO);
   }
   
   //공통코드 중 가족관계불러오기
   @Override
   public List<FamManageCodeVO> selectFamManageCode() {
      return this.empInfoMapper.selectFamManageCode();
   }
   //연차 사용 내역 현재 년도
   @Override
   public List<VacationVO> detailUsedVac(VacationVO vacationVO) {
      return this.empInfoMapper.detailUsedVac(vacationVO);
   }
   //연차사용내역 기존 년도
   @Override
   public List<VacationVO> showVacUsed(VacationVO vacationVO) {
      return this.empInfoMapper.showVacUsed(vacationVO);
   }
   //전직원 연차
   @Override
   public List<EmployeesVacVO> employeesVacVO(String coId) {
      return this.empInfoMapper.employeesVacVO(coId);
   }
   
   //급여 리스트
   @Override
   public List<PaymentVO> paymentVO(PaymentVO paymentVO) {
      return this.empInfoMapper.paymentVO(paymentVO);
   }
   
   //급여 상세
   @Override
   public PaymentVO paymentDetail(PaymentVO paymentVO) {
      return this.empInfoMapper.paymentDetail(paymentVO);
   }
   
   //급여 계좌 조회
   @Override
   public PaymentVO selectBank(PaymentVO paymentVO) {
      return this.empInfoMapper.selectBank(paymentVO);
   }
   
   //급여계좌 변경
   @Override
   public int paymentUpdate(PaymentVO paymentVO) {
      return this.empInfoMapper.paymentUpdate(paymentVO);
   }
   //전 직원 급여 리스트
   @Override
   public List<PaymentEmployeeVO> paymentEmployeeList(PaymentEmployeeVO paymentEmployeeVO) {
      return this.empInfoMapper.paymentEmployeeList(paymentEmployeeVO);
   }
   
   //전 직원 급여 리스트 엑셀 다운
   @Override
   public List<PaymentVO> paymentEmployeeExcel(PaymentVO paymentVO) {
      return this.empInfoMapper.paymentEmployeeExcel(paymentVO);
   }
   
   //직원 사진 변경하기
   @Override
   public int personpic(EmpInfoVO empInfoVO) {
      return this.empInfoMapper.personpic(empInfoVO);
   }
   
   //서명 사진 변경하기
   @Override
   public int regSign(EmpInfoVO empInfoVO) {
      return this.empInfoMapper.regSign(empInfoVO);
   }
   
   //직원 비밀번호 변경하기
   @Override
   public int changePw(UserVO userVO) {
      return this.empInfoMapper.changePw(userVO);
   }
   
}