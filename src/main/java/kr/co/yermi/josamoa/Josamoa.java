package kr.co.yermi.josamoa;

import kr.co.yermi.josamoa.util.JosamoaUtil;

public class Josamoa {

	/**
	 * @param str : 조사가 붙을 단어를 입력합니다.
	 * @param particle : 처리할 조사(받침 유무)를 작성합니다.
	 * @return
	 *  setJosa() 는 받침이 있는 경우 두 받침 중 앞 글자를, 받침이 없는 경우 두 받침 중 뒷 글자를 반환합니다.
	 *  - 한글의 경우 받침의 유무를 기준으로 조사를 붙입니다.
	 *  - 숫자의 경우 숫자를 한글로 표기한 후 받침 유무를 판단하여 조사를 붙입니다.
	 *  - 영어의 경우 정해진 규칙에 따라 조사를 붙입니다(checkedAlpabet() 메서드의 주석 참조).
	 *  - 문장부호로 쓰이는 특수문자의 경우 정해진 규칙에 따라 조사를 붙입니다(removeSpecial() 메서드의 주석 참조).
	 *  
	 *  예)
	 *  setJosa("철수", "은는") -> "철수는" / setJosa("장갑", "을를") -> "장갑을"
	 *  setJosa("사람1", "은는") -> "사람1은" / setJosa("사람4", "은는") -> "사람4는"
	 *  setJosa("cap", "은는") -> 캡은 -> "cap은" / setJosa("ai", "은는") -> 에이아이는 -> "ai는"
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
