package kr.co.yermi.josamoa.service;

import kr.co.yermi.josamoa.util.Constant;
import kr.co.yermi.josamoa.util.StringUtil;

public class JosamoaServiceImpl implements JosamoaService {
	
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
	
}
