package kr.co.yermi.josamoa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringUtil { 
	public static void main(String[] args) throws InterruptedException {
		// 14 + 된소리 5  >> 19
		System.out.println('힣' - '가' + 1);
		System.out.println((int)'가');
		System.out.println((int)'까');
		System.out.println('까' - '가');
		System.out.println('나' - '까');
		
		for (char i = '가'; i < '까'; i++) {
			System.out.print(i);
		}
		// 19, 28
		 System.out.println("가각갂갃간갅갆갇갈갉갊갋갌갍갎갏감갑값갓갔강갖갗갘같갚갛".length());
		
		System.out.println(proc("경보", "가", "이"));
		System.out.println(proc("동엽", "가", "이"));
		System.out.println(proc("치형", "가", "이"));
		System.out.println(proc("민지", "는", "은"));
		System.out.println(proc("소이", "는", "은"));
	} 
	
	static String proc(String str, String s1, String s2) { // 조사처리
		return (str.charAt(str.length()-1) - '가') % 28 == 0 ? str + s1 : str + s2;
	}
}

class Table {
	List<String> dishNames = new ArrayList<String>(Arrays.asList(new String[] {"국밥", "국밥", "돈까스"})); 
	final int MAX_FOOD = 6;
	
	private ArrayList<String> dishes = new ArrayList<>();
	
	public void add(String dish) {
		if(dishes.size() >= MAX_FOOD) return;
		dishes.add(dish);
		System.out.println("접시의 메뉴 : " + dishes);
	}
	
	public boolean remove(String dish) {
		for(int i = 0; i < dishes.size(); i++) {
			if(dish.equals(i)) {
				dishes.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public int dishNum() {
		return dishNames.size();
	}
}

class Cook implements Runnable {
	private Table table;
	public Cook(Table table) {
		this.table = table;
	}
	
	@Override
	public void run() {
		while(true) {
			int idx = (int)(Math.random() * table.dishNum());
			table.add(table.dishNames.get(idx));
			try {
				Thread.sleep(1);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
}

class Customer implements Runnable{
	private Table table;
	private String name;
	private String food;
	public Customer(Table table, String name, String food) {
		this.table = table;
		this.name = name;
		this.food = food;
	}
	@Override
	public void run() {
		try {
			Thread.sleep(10);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		if(table.remove(food)) {
			System.out.println(name + "이/가" + food + " 을/를 먹습니다.");
		}
		else {
			System.out.println(name + "은/는 음식을 못먹고 있습니다.");
		}
	}
	
}
