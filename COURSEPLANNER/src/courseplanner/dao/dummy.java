package courseplanner.dao;

import java.util.ArrayList;
import java.util.List;

class abc{
	private int a;
	private int b;
	abc(){
		
	}
	abc(int b){
		this.b = b;
	}
	abc(int a, int b){
		this.a = a;
		this.b = b;
	}
	@Override
	public String toString() {
		if(a!=0) {
			return "a" + a;
		}
		else {
			return "b" + b;
		}
	}
	
	
}


public class dummy {
public static void main(String[] args) {
	abc a1 = new abc();
	List<abc> l1 = new ArrayList<>();
	System.out.println(l1);
	
}
}
