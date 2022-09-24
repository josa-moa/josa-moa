package kr.co.yermi.josamoa;

import org.junit.Test;

public class josamoaTests {
	Josamoa josamoa = new Josamoa();
	
	@Test
	public void testPrintln() {
		System.out.println("Hello World!");
	}
	
	@Test
	public void testSetS() {
		System.out.println(josamoa.setS("예찬", "이가"));
	}
}
