package kr.co.yermi.josamoa.util;

public class JosamoaUtil { 
	public static String proc(String str, String s1, String s2) {
		return (str.charAt(str.length()-1) - '가') % 28 != 0 ? str + s1 : str + s2;
	}
}
