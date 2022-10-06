package kr.co.yermi.josamoa.test.builderPattern;

import kr.co.yermi.josamoa.util.StringUtil;

public class Josamoa {
    private String s, v , o, c;
    
    public String getS() {
		return s;
	}

	public String getV() {
		return v;
	}

	public String getO() {
		return o;
	}

	public String getC() {
		return c;
	}

	private Josamoa(JosamoaBuilder builder) {
        this.s = builder.s;
        this.v = builder.v;
        this.o = builder.o;
        this.c = builder.c;
    }
	
    //Builder Class
    public static class JosamoaBuilder {
    	private String s, v , o, c;
 
		
        public JosamoaBuilder(String s, String v){
            this.s = s;
            this.v = v;
        }
 
        public JosamoaBuilder setO(String o) {
            this.o = o;
            return this;
        }
 
        public JosamoaBuilder setC(String c) {
            this.c = c;
            return this;
        }
		
        public Josamoa build(){
            return new Josamoa(this);
        }
    }

	@Override
	public String toString() {
		String str = "";
		
		if(c != null) {
			str = StringUtil.proc(s, "은", "는") + " " + StringUtil.proc(c, "이다", "다");
		}
		else if(o != null) {
			str = StringUtil.proc(s, "은", "는") + " " + StringUtil.proc(o, "을", "를") + " " + v;
		}
		else {
			str = StringUtil.proc(s, "은", "는") + " " + v;
		}
		
		return str;
	}
}