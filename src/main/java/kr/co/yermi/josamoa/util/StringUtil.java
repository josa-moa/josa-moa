package kr.co.yermi.josamoa.util;

public class StringUtil { 
	public static String proc(String str, String s1, String s2) { // 조사처리
		return (str.charAt(str.length()-1) - '가') % 28 != 0 ? str + s1 : str + s2;
	}
	
	public static boolean checkedPosition(String particle, String position) {
		boolean result = false;
		
		switch(position) {
		case "S": // 주격 조사 체크
			for(String s : Constant.NOMINATIVE) { if(particle.equals(s)) { result = true; } } break;

		case "V": // 서술격 조사 체크
			for(String s : Constant.VERB) { if(particle.equals(s)) { result = true; } } break;
			
		case "O": // 목적격 조사 체크
			for(String s : Constant.ACCUSATIVE) { if(particle.equals(s)) { result = true; } } break;
			
		case "C": // 보격 조사 체크
			for(String s : Constant.COMPLEMENT) { if(particle.equals(s)) { result = true; } } break;
			
		case "AD": // 부사격 조사 체크
			for(String s : Constant.ADVERB) { if(particle.equals(s)) { result = true; } } break;
			
		default: // 관형격 조사 체크
			for(String s : Constant.GENETIVE) { if(particle.equals(s)) { result = true; } } break;
		}
		return result;
	}
	
	public static void main(String[] args) {
		/*
		 * 해당 부분은 개념 이해를 위해 남겨두었습니다.
		 * 조사 분류 방식에 대한 로직 개념을 정리해보시면 좋겠습니다.
		 * 해당 클래스의 main은 삭제할 예정입니다.
		 * */
		
		// 14 + 된소리 5  >> 19
		System.out.println('힣' - '가' + 1);
		System.out.println((int)'가');
		System.out.println((int)'까');
		System.out.println('까' - '가');
		System.out.println('나' - '까');
		
		for (char i = '가'; i < '까'; i++) {
			System.out.print(i);
		}
		// 19, 28
		 System.out.println("가각갂갃간갅갆갇갈갉갊갋갌갍갎갏감갑값갓갔강갖갗갘같갚갛".length());
		
		System.out.println(proc("경보", "가", "이"));
		System.out.println(proc("동엽", "가", "이"));
		System.out.println(proc("치형", "가", "이"));
		System.out.println(proc("민지", "는", "은"));
		System.out.println(proc("소이", "는", "은"));
	} 
}
