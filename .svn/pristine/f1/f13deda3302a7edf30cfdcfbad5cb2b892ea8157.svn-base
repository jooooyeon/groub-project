package kr.or.ddit.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GroubUtils {
 	private static String dateFormat = "yyyy-MM-dd";
 	private static String dateFormat2 = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 날짜 데이터의 시간 부분을 지우고 yyyy-MM-dd 형태로 바꿔줌
	 *
	 * @param year 바꿀 날짜 데이터
	 * @return yyyy-MM-dd 형태의 문자열 날짜
	 */
	public static String year2String(Date year) {
		SimpleDateFormat sDateFor = new SimpleDateFormat(dateFormat);
		String result = sDateFor.format(year);
		return result;
	};

	public static String year2String2(Date year) {
		SimpleDateFormat sDateFor = new SimpleDateFormat(dateFormat2);
		String result = sDateFor.format(year);
		return result;
	};


	/**
	 * 임시 비밀번호 생성을 위한 무작위 문자열 생성
	 * @return str 무작위로 생성된 10자리 문자열
	 */
	public static String getTempPassword(){
        char[] charSet = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F',
                'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

        String str = "";

        // 문자 배열 길이의 값을 랜덤으로 10개를 뽑아 구문을 작성함
        int idx = 0;
        for (int i = 0; i < 10; i++) {
            idx = (int) (charSet.length * Math.random());
            str += charSet[idx];
        }
        return str;
    }


}


