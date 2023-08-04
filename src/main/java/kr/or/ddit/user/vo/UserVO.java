package kr.or.ddit.user.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import lombok.Data;

/**
* 그룹웨어 사용자 정보를 처리하기 위한 VO클래스
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
@Data
public class UserVO implements Serializable {
	private String userId;
	private String userPswd;
	private String coId;
	private String enabled;
	private String userNm;
	private String userTelno;
	private String userEml;
	private Date brthYmd;
	private String userZip;
	private String userAddr;
	private String userDaddr;
	private String userImg;
	private String signImg;
	private String gndrMf;
	private String hobby;
	private String spcabl;
	private String mngrYn;
	private String msngrStts;
	private String deptNo;
	private String jbgdCd;
	private String jbtlCd;
	private String msngrSttsNm;
	private String deptNm;
	private String jbgdNm;
	private String jbtlNm;
	private String hdofCd;
	private String hdofCdNm;
	private String mtrscCd;
	private String mtrscCdNm;
	private String faceYn;
	private String voiceYn;
	private int failCnt;

	private int anslry;
	private String bankNm;
	private long actNo;
	private String jncmpYmd;
	private String rsgntnYmd;

	@Valid
	private List<UsersAuthVO> usersAuthVOList;



}
