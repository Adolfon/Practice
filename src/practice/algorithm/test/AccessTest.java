package practice.algorithm.test;

import practice.algoritm.Rak_rect;


public class AccessTest extends Rak_rect{
	
	public int calcArea(int K, int L, int M, int N,
            int P, int Q, int R, int S) {
		return 0;
	}
	
	public void test() {
		
		
		//Here is the trick. You have to create an Object of 
		//this class and assign that object to a parent type variable
		//in order to access the parent protected method
		AccessTest at1=new AccessTest(); 
		Rak_rect rr=at1;				
		((AccessTest) rr).accessTest2();
		
		//or same thing with less steps..
		Rak_rect rrr=new AccessTest(); //Parent type but new this class Object
		((AccessTest) rrr).accessTest2(); //Call to the parent protected method
		 
	}
	
	
	
	
	public static void main(String[] args){
		AccessTest at=new AccessTest();
		at.test();
		
	}

}
