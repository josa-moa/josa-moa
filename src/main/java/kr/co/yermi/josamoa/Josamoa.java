package kr.co.yermi.josamoa;

import kr.co.yermi.josamoa.util.JosamoaUtil;

public class Josamoa {
	public String setJosa(String str, String particle) {
		str = str.trim();
		
		if(str.length() > 0 && particle.length() != 2) {
			return str;
		}
		
		// 받침 유무 확인
		boolean flag = true;
		int last = JosamoaUtil.checkedLastLetter(str);
		
		switch (last) {
		// 마지막 글자가 한글인 경우
		case 0: flag = JosamoaUtil.checkedKorean(str); break;

		// 마지막 글자가 숫자일 경우
		case 1: flag = JosamoaUtil.checkedNumber(str); break;
		
		// 마지막 글자가 영어일 경우
		case 2: flag = JosamoaUtil.checkedAlpabet(str); break;
		
		default: break;
		}
		
		return JosamoaUtil.result(str, particle, flag);
	}
}
