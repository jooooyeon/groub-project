package kr.or.ddit.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.or.ddit.admin.account.vo.UserRegisterVO;
import kr.or.ddit.user.vo.UserLogVO;
import kr.or.ddit.user.vo.UserVO;

/**
* 그룹웨어 사용자 데이터에 접근하는 클래스를 정의한다.
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
 *   2023.07.21  노태현          최초 생성
*
* </pre>
*/
public interface UserMapper {

	/**
	 * 기업에 속하는 사용자 목록을 조회한다
	 * @param coId 조회하려는 기업
	 * @return 사용자 목록
	 */
	public List<UserVO> list(String coId);

	/**
	 * 기업에서 관리자 권한을 가지고 있는 사용자 목록을 조회한다
	 * @param coId 조회하려는 기업
	 * @return 사용자 목록
	 */
	public List<UserVO> hasAdminList(String coId);

	/**
	 * 사용자의 상세 정보를 조회한다
	 * @param userVO 조회하려는 사용자
	 * @return 사용자 상세 정보
	 */
	public UserVO detail(UserVO userVO);

	/**
	 * 사용자의 권한정보를 포함한 상세 정보를 조회한다
	 * @param userVO 조회하려는 사용자
	 * @return 사용자 상세 정보
	 */
	public UserVO detailUserAuth(UserVO userVO);

	/**
	 * 신규 사용자의 계정 정보를 등록한다
	 * @param userRegisterVO 등록하려는 사용자의 정보
	 * @return
	 */
	public int registerUser(UserRegisterVO userRegisterVO);

	/**
	 * 신규 사용자의 인사정보를 증록한다
	 * @param userRegisterVO 등록하려는 사용자의 정보
	 * @return
	 */
	public int registerEmpInfo(UserRegisterVO userRegisterVO);

	/**
	 * 사용자에게 권한을 부여한다
	 * @param auth 부여하려는 권한
	 * @param userId 권한을 부여하려는 대상
	 * @return
	 */
	public int addAuth(@Param("auth") String auth, @Param("userId") String userId);

	/**
	 * 사용자에게서 권한을 삭제한다
	 * @param auth 삭제하려는 권한
	 * @param userId 권한을 삭제하려는 대상
	 * @return
	 */
	public int delAuth(@Param("auth") String auth, @Param("userId") String userId);

	/**
	 * 사용자의 계정 정보를 수정한다
	 * @param userVO 수정 대상이 되는 사용자와 그 정보
	 * @return
	 */
	public int updateUser(UserVO userVO);

	/**
	 * 사용자의 인사정보를 수정한다
	 * @param userVO 수정 대상이 되는 사용자와 그 정보
	 * @return
	 */
	public int updateEmpInfo(UserVO userVO);


	/**
	 * 사용자계정 자동생성을 위해서 해당 조건의 마지막 계정을 조회한다
	 * @param search 신규 사용자의 입사연월
	 * @return
	 */
	public String maxUserId(String search);

	/**
	 * 신규 생성 또는 정보 수정시 이메일 중복 여부를 조회한다
	 * @param email 입력된 이메일 주소
	 * @return
	 */
	public int checkEmail(String email);

	/**
	 * 계정의 활성화 상태를 변경한다
	 * @param userId
	 * @return
	 */
	public int accountAct(String userId);

	/**
	 * 얼굴인식 로그인 사용여부의 상태를 변경한다
	 * @param userId
	 * @return
	 */
	public int faceAct(String userId);

	/**
	 * 로그인에 관한 로그를 기록한다
	 * @param userLogVO
	 * @return
	 */
	public int userLog(UserLogVO userLogVO);

	/**
	 * 로그인 성공시 연속 로그인 실패 횟수를 0으로 한다
	 * @param userId
	 * @return
	 */
	public int logSuccessZero(String userId);

	/**
	 * 로그인 실패시 실패 횟수를 1증가 시킨다
	 * @param userId
	 * @return
	 */
	public int logFailCntUp(String userId);

	/**
	 * 로그인시마다 실패 횟수를 조회한다
	 * @param userId
	 * @return
	 */
	public int checkCntUp(String userId);

	/**
	 * 로그인을 시도하는 아이디의 존재 유무를 확인한다
	 * @param userId
	 * @return
	 */
	public int checkId(String userId);

	/**
	 * 로그인을 시도하는 아디의 계정 활성화 여부룰 확인한다
	 * @param userId
	 * @return
	 */
	public String checkIdEn(String userId);

	/**
	 * 입력된 계정의 이메일 주소를 조회한다
	 * @param userId
	 * @return 이메일 주소
	 */
	public String checkEmlId(String userId);

	/**
	 * 권한 ROLE_USER만 가지고 있는 계정 목록을 조회한다
	 * @param coId
	 * @return
	 */
	public List<UserVO> onlyUserAuth(String coId);

}
