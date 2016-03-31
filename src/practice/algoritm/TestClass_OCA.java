package practice.algoritm;
//OCA practice problem number 52
public class TestClass_OCA {
	
		public static void main(String args[]){
		A[] a, a1;
		B[] b;
		a = new A[10]; a1 = a;
		b = new B[20];
		a = b; // 1
		b = (B[]) a; // 2
		b = (B[]) a1; // 3
		}
		}
		class A { }
		class B extends A { }
/*
 * 
 * Correct Options are : C E
 * 
 * Choose 2 options:
A. Compile time error at line 3.
B. The program will throw a java.lang.ClassCastException at the line labelled 2 when
run.
C. The program will throw a java.lang.ClassCastException at the line labelled 3 when
run.
D. The program will compile and run if the (B[ ] ) cast in the line 2 and the whole line
3 is removed.
E. The cast at line 2 is needed.

C and E options are correct:
Explanation:
The line 1 will be allowed during compilation, since assignment is done from a
subclass reference to a superclass reference.

The cast in line 2 is needed because a superclass reference is assigned to a subclass
reference variable. And this works at runtime because the object referenced to by a is
actually of an array of B.  --------------------------->I don't understand this?????
Now, the cast at line 3 tells the compiler not to worry, that I'm a good programmer and
I know what I am doing and the object referenced by the super class reference (a1)
will actually be of class B at run time. So there is no compile time error. But at run
time, this fails because the actual object is not an array of B but is an array of A.

 */


