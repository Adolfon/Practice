package practice.java.test;

import practice.algoritm.Rak_rect;


public class AccessTest{
	
	class A { };
	class B extends A { };
	
	
			
		
		
		

	
	public static void main(String[] args){
		Rak_rect rr=new Rak_rect();
		
		//Another test
		A[] a, a1;
		B[] b;
		a = new A[10]; a1 = a; //a1 now points to type A[] variable (debug)
		b = new B[20];
		a = b; // 1
		b = (B[]) a; // 2
		b = (B[]) a1; // 3  ..Only this fails on runtime..
		System.out.println("hola");
	}

}
/** Choose 2 answers --> C and E are the right ones.
 * A. Compile time error at line 3.
B. The program will throw a java.lang.ClassCastException at the line labelled 2 when run.
C. The program will throw a java.lang.ClassCastException at the line labelled 3 when run.
D. The program will compile and run if the (B[ ] ) cast in the line 2 and the whole line 3 is removed.
E. The cast at line 2 is needed.

 */

