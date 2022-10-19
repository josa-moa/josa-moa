package kr.co.yermi.josamoa;

import org.junit.Test;

public class josamoaTests {
	Josamoa josamoa = new Josamoa();
	
	@Test
	public void testPrintln() {
		System.out.println("Hello World!");
	}
	
	@Test
	public void testSetJosamoa() {
		System.out.println(josamoa.setJosa("철", "은는"));
		
		// Test : b, c
		System.out.println(josamoa.setJosa("a", "은는"));
		System.out.println(josamoa.setJosa("F", "은는"));
		System.out.println(josamoa.setJosa("l", "은는"));
		
		System.out.println("-----------------------------------");
		System.out.println(josamoa.setJosa("ia", "은는"));
		System.out.println(josamoa.setJosa("ib", "은는"));
		System.out.println(josamoa.setJosa("biC", "은는"));
		
		System.out.println("-----------------------------------");
		System.out.println(josamoa.setJosa("p", "은는"));
		System.out.println(josamoa.setJosa("helP", "은는"));
		System.out.println(josamoa.setJosa("pop", "은는"));
		
		System.out.println("-----------------------------------");
		System.out.println(josamoa.setJosa("e", "은는"));
		System.out.println(josamoa.setJosa("hidE", "은는"));
		System.out.println(josamoa.setJosa("pole", "은는"));
		
		System.out.println("-----------------------------------");
		System.out.println(josamoa.setJosa("kicK", "은는"));
		System.out.println(josamoa.setJosa("pork", "은는"));
		
		System.out.println("-----------------------------------");
		System.out.println(josamoa.setJosa("ponG", "은는"));
		System.out.println(josamoa.setJosa("leg", "은는"));
		
		System.out.println("-----------------------------------");
		System.out.println(josamoa.setJosa("ponG!", "은는"));
		System.out.println(josamoa.setJosa("podG!", "은는"));
		System.out.println(josamoa.setJosa("leg$", "은는"));
		System.out.println(josamoa.setJosa("김김@@", "은는"));
		
		System.out.println("-----------------------------------");
		System.out.println(josamoa.setJosa("cdfdfd\'", "은는"));
		System.out.println(josamoa.setJosa("cdfdic\'", "은는"));
		System.out.println(josamoa.setJosa("cdbang!!!!", "은는"));
	}
	
}
