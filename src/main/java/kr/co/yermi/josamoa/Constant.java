package kr.co.yermi.josamoa;

public class Constant {
	/* 주격 조사 */
	enum SUBJECTIVE { 은는, 이가 }

	public static void main(String[] args) {
		System.out.println(SUBJECTIVE.이가);
		System.out.println(SUBJECTIVE.valueOf("은는"));
		System.out.println(SUBJECTIVE.valueOf("이가"));
		System.out.println(SUBJECTIVE.values());
	}
}
