package kr.co.yermi.josamoa;

import kr.co.yermi.josamoa.service.JosamoaService;
import kr.co.yermi.josamoa.service.JosamoaServiceImpl;

public class JosamoaTest {
	private JosamoaService josamoaService = new JosamoaServiceImpl();
	
	public String setS(String str, String particle) {
		return josamoaService.setS(str, particle);
	}
	
	public static void main(String[] args) {
		"사람".substring(1);
	}
}