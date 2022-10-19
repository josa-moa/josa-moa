package kr.co.yermi.josamoa.util;

public class JosamoaUtil { 
	public static String result(String str, String particle, boolean flag) {
		String[] particles = particle.split("");
		return flag ? str + particles[0] : str + particles[1];
	}
	
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
	
	public static boolean checkedKorean(String str) {
		return (str.charAt(str.length()-1) - '가') % 28 != 0;
	}
	
	// 0 1 3 6 7 8 (영 일 삼 육 칠 팔), 2 4 5 9 (이 사 오 구)
	public static boolean checkedNumber(String str) {
		return "013678".contains(str.substring(str.length()-1));
	}
	
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
	
	private static boolean containVowels(char c) {
		char[] vowels = {'a', 'e', 'i', 'o', 'u'};
		
		for(char vowel : vowels) {
			if(c == vowel) {
				return true;
			}
		}
		return false;
	}
	
	private static boolean containProp(char c) {
		char[] props = {'l', 'm', 'n'};
		
		for(char prop : props) {
			if(c == prop) {
				return true;
			}
		}
		return false;
	}
	
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
