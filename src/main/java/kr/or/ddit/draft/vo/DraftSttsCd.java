package kr.or.ddit.draft.vo;

/**
 * 기안 상태 공통 코드 Enum
 * @author 정시윤
 *
 */
public enum DraftSttsCd {
	TEMP("DF001")
	, COMPLETE("DF002")
	, DURING("DF003")
	, REJECT("DF004");
	
	private String draftSttsCd;
	
	DraftSttsCd(String draftSttsCd) {
		this.draftSttsCd = draftSttsCd;
	}

	public String getDraftSttsCd() {
		return draftSttsCd;
	}
	
}
