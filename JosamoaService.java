package kr.co.yermi.josamoa.service;

public interface JosamoaService {
	
	// 주어 조사 세팅
	public String setS(String str, String particle);

	// 서술격 조사 세팅
	public String setV(String str, String particle);
	
	// 관형격 조사 세팅
	public String setG(String str, String particle);
	
	// 목적격 조사 세팅
	public String setO(String str, String particle);

	// 보격 조사 세팅
	public String setC(String str, String particle);

	// 부사격 조사 세팅
	public String setAD(String str, String particle);

}
