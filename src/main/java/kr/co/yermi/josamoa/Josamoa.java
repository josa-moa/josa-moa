package kr.co.yermi.josamoa;

import kr.co.yermi.josamoa.util.JosamoaUtil;

public class Josamoa {
	public String setJosa(String str, String particle) {
		String[] particles = particle.split("");
		return JosamoaUtil.proc(str, particles[0], particles[1]);
	}
}
