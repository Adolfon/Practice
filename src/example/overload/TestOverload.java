package example.overload;


import example.lambda.easy.*;
import java.util.*;

public class TestOverload {

	//Overload this method
	public int setVar(int a, int b, float c) {
		//int es=this.x; if x is not static Okay bc this method is not static.
		return 0;
	};

	//Duplicate method the return type doesnt matter..
//	public float setVar(int a, int b, float c){
//		return c*a;
//	}
	
	//Okay (different parameters)
	public int setVar(int a, float b, int c){
		return (int)(a + b + c);
		}
	
	
// Same method.. error
//	public int setVar(int x, int y, float z){
//		return x+y;

	
	//this( ... ) can only be called in a constructor and that too as a first statement.

//	public int setVar(int a, float b, int c){
//		return this(a, c, b);
//		}

	interface MyIface{};
	class A {};
	class B extends A implements MyIface{};
	class C implements MyIface{};

	A a = new A();
	B b = new B();
	C c = new C();
	
	MyIface i=c; //Because C implements i;
	
	
	//I am trying to call a method from a subclass of other Package in order to test the protected scope of the method "otherPackageCall"
	class HijoCalculator extends Calculator{
		
		public void metodo(){			
			Calculator cal=new Calculator();		
			cal.otherPackageCall(); //it will fail if the method of the other class is protected.
		}
		
	};
	
	
	 static int x; //Class member,  only 2 possibilities if you want to access from main method. 1 make it static member or
	//initializate it as an Object (line 74), but bc is a primitive type then you only have the choice of making it static if you
	// want to access it from the main method.
	
	 Integer xx;
	 
	 int xxx;
	 
	public static void main(String[] args){
			
		int m= TestOverload.x;
		
		System.out.println("Valor: "+m); //int primitive default value is 0 if is not initializated;
		
		//int m= new TestOverload().xxx; I will not work bc is a primitive data type.
		
		HijoCalculator hc= new TestOverload().new HijoCalculator();//If HijoCalculator was static then it would be:
		//HijoCalculator hc= new TestOverload.HijoCalculator();
		
		Integer varTest= new TestOverload().xx; //Accessing from main without being a static member, but you have to 
		//create an Object for this class. (You can NEVER use "this" inside of main method)

		hc.metodo();
		
		new TestOverload().loop();
		
		
		
		
		System.out.println("Salida test..");
	}

	
	public void loop() {
		int counter = 0;
		outer:
		for (int i = 0; i < 3; i++) {
			middle:
			for (int j = 0; j < 3; j++) {
				inner:
				for (int k = 0; k < 3; k++) {
					if (k - j > 0) {
						break middle;
					}
					counter++;
				}
			}
		}
		System.out.println(counter);
		}

	
}//Class TestOverload
