package kr.co.yermi.josamoa.util;

public class JosamoaUtil { 
	public static String result(String str, String particle, boolean flag) {
		String[] particles = particle.split("");
		return flag ? str + particles[0] : str + particles[1];
	}
	
	public static int checkedLastLetter(String str) {
		char last = str.charAt(str.length()-1);
		// 한글일 경우
		if((last >= '가' && last <= '힣')) {
			return 0;
		}
		// 숫자일 경우
		if(last >= '0' && last <= '9') {
			return 1;
		}
		// 영어일 경우
		if((last >= 'A' && last <= 'Z') || (last >= 'a' && last <= 'z')) {
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
		return true;
	}
}
