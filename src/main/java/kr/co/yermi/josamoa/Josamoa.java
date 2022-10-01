package kr.co.yermi.josamoa;

import kr.co.yermi.josamoa.service.JosamoaService;
import kr.co.yermi.josamoa.service.JosamoaServiceImpl;

public class Josamoa {
	private JosamoaService josamoaService = new JosamoaServiceImpl();
	
	public String setS(String str, String particle) {
		return josamoaService.setS(str, particle);
	}
}