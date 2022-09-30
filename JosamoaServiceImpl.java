package kr.co.yermi.josamoa.service;

import kr.co.yermi.josamoa.util.Constant;
import kr.co.yermi.josamoa.util.StringUtil;

public class JosamoaServiceImpl implements JosamoaService {
	
	// 주격 조사
	@Override
	public String setS(String str, String particle) {
		String result = str + "?";
		String[] particles = Constant.NOMINATIVE;
		
		if(StringUtil.checkedPosition(particle, "S")) {
			if(particle.equals(particles[0])) {
				result = StringUtil.proc(str, "은", "는");
			} else if(particle.equals(particles[1])) {
				result = StringUtil.proc(str, "이", "가");
			}
		}
		return result;
	}

	// 서술격 조사
	@Override
	public String setV(String str, String particle) {
		String result = str + "?";
		String[] particles = Constant.VERB;
		
		if(StringUtil.checkedPosition(particle, "V")) {
			if(particle.equals(particles[0])) {
				result = StringUtil.proc(str, "이다", "이다");
			}
		}
		return result;
	}

	// 관형격 조사
	@Override
		public String setG(String str, String particle) {
		String result = str + "?";
		String[] particles = Constant.GENETIVE;
		
		if(StringUtil.checkedPosition(particle, "G")) {
			if(particle.equals(particles[0])) {
				result = StringUtil.proc(str, "의", "의");
			}
		}
		return result;
	}
	
	// 목적격 조사
	@Override
		public String setO(String str, String particle) {
		String result = str + "?";
		String[] particles = Constant.ACCUSATIVE;
		
		if(StringUtil.checkedPosition(particle, "O")) {
			if(particle.equals(particles[0])) {
				result = StringUtil.proc(str, "을", "를");
			}
		}
		return result;
	}

	// 보격 조사
	@Override
		public String setC(String str, String particle) {
		String result = str + "?";
		String[] particles = Constant.COMPLEMENT;
		
		if(StringUtil.checkedPosition(particle, "C")) {
			if(particle.equals(particles[0])) {
				result = StringUtil.proc(str, "이", "가");
			}
		}
		return result;
	}

	// 부사격 조사
	@Override
		public String setAD(String str, String particle) {
		String result = str + "?";
		String[] particles = Constant.ADVERB;
		
		if(StringUtil.checkedPosition(particle, "AD")) {
			if(particle.equals(particles[0])) {
				result = StringUtil.proc(str, "에게", "에게");
			}
		}
		return result;
	}
}
