package kr.co.yermi.josamoa;

import kr.co.yermi.josamoa.util.JosamoaUtil;

public class Josamoa {
	public String setJosa(String str, String particle) {
		str = str.trim();
		
		if(str.length() > 0 && particle.length() != 2) {
			return str;
		}
		
		// 특수문자 체크 및 제거. @ # % & * 받침없음으로 처리
		String changeStr = JosamoaUtil.removeSpecial(str);
		
		// 받침 유무 확인
		boolean flag = false;
		int last = JosamoaUtil.checkedLastLetter(changeStr);
		
		switch (last) {
		// 마지막 글자가 한글인 경우
		case 0: flag = JosamoaUtil.checkedKorean(changeStr); break;

		// 마지막 글자가 숫자일 경우
		case 1: flag = JosamoaUtil.checkedNumber(changeStr); break;
		
		// 마지막 글자가 영어일 경우
		case 2: flag = JosamoaUtil.checkedAlpabet(changeStr.toLowerCase()); break;
		}
		
		return JosamoaUtil.result(str, particle, flag);
	}
}
