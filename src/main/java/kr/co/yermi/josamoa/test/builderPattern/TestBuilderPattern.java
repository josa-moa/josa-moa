package kr.co.yermi.josamoa.test.builderPattern;

public class TestBuilderPattern {
    public static void main(String[] args) {
    	// 내부 클래스로 인한 호출
        Computer comp = new Computer.ComputerBuilder("500 GB", "2 GB")
                .setBluetoothEnabled(true)
                .setGraphicsCardEnabled(true)
                .build();
        
        System.out.println(comp);
        System.out.println(comp.getHDD() + ", " + comp.getRAM() + ", " + comp.isGraphicsCardEnabled() + ", " + comp.isBluetoothEnabled());
        
        System.out.println("----------------------------------------------------");
        
        Josamoa josamoa = new Josamoa.JosamoaBuilder("철수", "좋아한다").setO("영희").build();
        System.out.println(josamoa);
    }
}
