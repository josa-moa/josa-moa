package kr.co.yermi.josamoa.util;

public class JosamoaUtil { 

	/**
	 * @param str : 조사가 붙을 단어를 입력합니다.
	 * @param particle : 처리할 조사(받침 유무)를 작성합니다.
	 * @param flag : 받침 유무를 판단합니다.
	 * @return : 조사모아 메서드의 결과물을 출력합니다.
	 * 
	 * <pre>
	 * <b>History:</b>
	 *    JosaMoa, 1.0, 222.10.31 최초작성
	 * </pre>
	 *
	 * @author cloudd81
	 * @version 1.0, 202.10.31 소스 삽입
	 * @see    None
	 */
	public static String result(String str, String particle, boolean flag) {
		String[] particles = particle.split("");
		return flag ? str + particles[0] : str + particles[1];
	}
	
	/**
	 * 
	 * @param str : 입력되어진 문자열의 끝단어의 유형을 판단합니다(한글, 숫자, 영문)
	 * @return : 한글 - 0 / 숫자 - 1 / 영어 - 2가 반환됩니다.
	 * 
	 * <pre>
	 * <b>History:</b>
	 *    JosaMoa, 1.0, 222.10.31 최초작성
	 * </pre>
	 *
	 * @author cloudd81
	 * @version 1.0, 202.10.31 소스 삽입
	 * @see    None
	 */
	public static int checkedLastLetter(String str) {
		char last = str.toLowerCase().charAt(str.length()-1);
		// 한글일 경우
		if((last >= '가' && last <= '힣')) {
			return 0;
		}
		// 숫자일 경우
		if(last >= '0' && last <= '9') {
			return 1;
		}
		// 영어일 경우
		if((last >= 'a' && last <= 'z')) {
			return 2;
		}
		return -1;
	}
	
	/**
	 * 
	 * @param str : 입력되어진 문자열의 끝단어(한글) 반환합니다.
	 * @return : 단어 가장 끝단어를 문자값(char)으로 반환합니다.
	 * 
	 * <pre>
	 * <b>History:</b>
	 *    JosaMoa, 1.0, 222.10.31 최초작성
	 * </pre>
	 *
	 * @author cloudd81
	 * @version 1.0, 202.10.31 소스 삽입
	 * @see    None
	 */
	public static boolean checkedKorean(String str) {
		return (str.charAt(str.length()-1) - '가') % 28 != 0;
	}
	
	/**
	 * 
	 * @param str : 입력되어진 문자열의 끝단어(숫자)를 한글표기법으로 반환합니다.
	 * @return : 단어의 가장 끝 숫자를 한글표기법에 맞춰 문자값(char)으로 반환합니다.
	 * 숫자의 한글 표기법 : 0 1 3 6 7 8 (영 일 삼 육 칠 팔), 2 4 5 9 (이 사 오 구)
	 * 
	 * <pre>
	 * <b>History:</b>
	 *    JosaMoa, 1.0, 222.10.31 최초작성
	 * </pre>
	 *
	 * @author cloudd81
	 * @version 1.0, 202.10.31 소스 삽입
	 * @see    None
	 */
	public static boolean checkedNumber(String str) {
		return "013678".contains(str.substring(str.length()-1));
	}
	
	/**
	 * 
	 * @param str : 입력되어진 문자열의 끝단어(영어)를 한글표기법으로 반환합니다.
	 * @return : 단어의 가장 끝 영문자를 한글표기법 규칙에 맞춰 문자값(char)으로 반환합니다.
	 * 
	 * - 글자 길이가 3글자 이상일 경우
	 * 1) b와 c는 앞문자가 모음일 경우 받침을 가집니다.
	 * 2) p는 앞문자가 받침문자(l, m, n)가 아닐 경우 받침을 가집니다.
	 * 3) e는 앞문자가 받침문자(l, m, n)일 경우 받침을 가집니다.
	 * 4) k는 앞문자가 'c'인 경우 받침을 가집니다.
	 * 5) g는 앞문자가 'n'인 경우 받침을 가집니다.
	 * 
	 * - 글자 길이가 3글자 미만일 경우
	 * 6) 한 글자씩 읽습니다. ex) IC(아이씨), DJ(디제이)
	 * 
	 * <pre>
	 * <b>History:</b>
	 *    JosaMoa, 1.0, 222.10.31 최초작성
	 * </pre>
	 *
	 * @author cloudd81
	 * @version 1.0, 202.10.31 소스 삽입
	 * @see    None
	 */
	public static boolean checkedAlpabet(String str) {
		int length = str.length() - 1;
		char last = str.charAt(length);
		
		if(str.length() > 2) {
			// b와 c는 앞문자가 모음일 경우 받침을 가짐
			if(last == 'b' || last == 'c') {
				return containVowels(str.charAt(length - 1)) ? true : false;
			}
			// p는 앞문자가 받침문자(l, m, n)가 아닐 경우 받침을 가짐
			if(last == 'p') {
				return !containProp(str.charAt(length - 1)) ? true : false;
			}
			// e는 앞문자가 받침문자(l, m, n)일 경우 받침을 가짐
			if(last == 'e') {
				return containProp(str.charAt(length - 1)) ? true : false;
			}
			// k는 앞문자가 'c'인 경우 받침을 가짐
			if(last == 'k') {
				return str.charAt(length - 1) == 'c' ? true : false;
			}
			// g는 앞문자가 'n'인 경우 받침을 가짐
			if(last == 'g') {
				return str.charAt(length - 1) == 'n' ? true : false;
			}
		}
		// 글자 길이가 3 미만일 경우 한 글자 씩 읽음 ex) IC(아이씨), DJ(디제이)
		else {
			return "lmnr".contains(str) ? true : false;
		}
		return false;
	}
	
	/**
	 * 
	 * @param c : 영문자의 받침이 a, e, i, o, u 인지 확인합니다.
	 * @return : 영문자의 받침이  a, e, i, o, u 일 경우 true를 반환합니다.
	 * 
	 * <pre>
	 * <b>History:</b>
	 *    JosaMoa, 1.0, 222.10.31 최초작성
	 * </pre>
	 *
	 * @author cloudd81
	 * @version 1.0, 202.10.31 소스 삽입
	 * @see    None
	 */
	private static boolean containVowels(char c) {
		char[] vowels = {'a', 'e', 'i', 'o', 'u'};
		
		for(char vowel : vowels) {
			if(c == vowel) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @param c : 영문자의 받침이 l, m, n 인지 확인합니다.
	 * @return : 영문자의 받침이 l, m, n 일 경우 true를 반환합니다.
	 * 
	 * <pre>
	 * <b>History:</b>
	 *    JosaMoa, 1.0, 222.10.31 최초작성
	 * </pre>
	 *
	 * @author cloudd81
	 * @version 1.0, 202.10.31 소스 삽입
	 * @see    None
	 */
	private static boolean containProp(char c) {
		char[] props = {'l', 'm', 'n'};
		
		for(char prop : props) {
			if(c == prop) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @param str : 입력되어진 문자열의 끝단어가 특수문자일 경우 정해진 규칙에 따라 반환합니다.
	 * @return
	 *  1) ! ? , . ~ ' " ; : { } [ ] ( ) < > 는 무시합니다.
	 *  2) @ # % & * 등은 받침없음으로 처리합니다.
	 * 
	 * <pre>
	 * <b>History:</b>
	 *    JosaMoa, 1.0, 222.10.31 최초작성
	 * </pre>
	 *
	 * @author cloudd81
	 * @version 1.0, 202.10.31 소스 삽입
	 * @see    None
	 */
	public static String removeSpecial(String str) {
		String special = "!?,\\.~\'\";:{}[]()<>";
		String result = str;
		
		boolean flag = true;
		
		while(flag) {
			if(special.contains(result.substring(result.length()-1))) {
				result = result.substring(0, result.length()-1);
			} else {
				flag = false;
			}
		}
		return result;
	}
}
