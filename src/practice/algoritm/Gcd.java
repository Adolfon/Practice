package practice.algoritm;

/*Static vs non-static method
 * 
 * One rule-of-thumb: ask yourself "does it make sense to call this method, even if no Obj has been constructed yet?" If so, it should definitely
 *  be static.

So in a class Car you might have a method double convertMpgToKpl(double mpg) which would be static, because one might want 
to know what 35mpg converts to, even if nobody has ever built a Car. But void setMileage(double mpg) 
(which sets the efficiency of one particular Car) can't be static since it's inconceivable to call the method before 
any Car has been constructed.

(Btw, the converse isn't always true: you might sometimes have a method which involves two Car objects, and still 
want it to be static. E.g. Car theMoreEfficientOf( Car c1, Car c2 ). Although this could be converted to a 
non-static version, some would argue that since there isn't a "privileged" choice of which Car is more important, 
you shouldn't force a caller to choose one Car as the object you'll invoke the method on. This situation accounts for a 
fairly small fraction of all static methods, though.)
----------------------------------------------

Define static methods in the following scenarios only:

1 If you are writing utility classes and they are not supposed to be changed.
2 If the method is not using any instance variable.
3 If any operation is not dependent on instance creation.
4 If there is some code that can easily be shared by all the instance methods, extract that code into a static method.
5 If you are sure that the definition of the method will never be changed or overridden. As static methods can not be overridden.
-------------------------------------------------
There are some valid reasons to use static methods:

Performance: if you want some code to be run, and don't want to instantiate an extra object to do so, shove it into a 
static method. The JVM also can optimize static methods a lot (I think I've once read James Gosling declaring that you 
don't need custom instructions in the JVM, since static methods will be just as fast, but couldn't find the source - thus 
it could be completely false). Yes, it is micro-optimization, and probably unneeded. And we programmers never do unneeded
 things just because they are cool, right?

Practicality: instead of calling new Util().method(arg), call Util.method(arg), or method(arg) with static imports. Easier,
 shorter.

Adding methods: you really wanted the class String to have a removeSpecialChars() instance method, but it's not there 
(and it shouldn't, since your project's special characters may be different from the other project's), and you can't add it
 (since Java is minimally sane), so you create an utility class, and call removeSpecialChars(s) instead of 
 s.removeSpecialChars(). Sweet.

Purity: taking some precautions, your static method will be a pure function, that is, the only thing it depends on is its 
parameters. Data in, data out. This is easier to read and debug, since you don't have inheritance quirks to worry about.
 You can do it with instance methods too, but the compiler will help you a little more with static methods (by not allowing
  references to instance attributes, overriding methods, etc.).

You'll also have to create a static method if you want to make a singleton, but... don't. I mean, think twice.

Now, more importantly, why you wouldn't want to create a static method? Basically, polymorphism goes out of the window. 
You'll not be able to override the method, nor declare it in an interface. It takes a lot of flexibility out from your 
design. Also, if you need state, you'll end up with lots of concurrency bugs and/or bottlenecks if you are not careful.



*/

public class Gcd { //Euclides algorithm, find the common greater division of 
	//two numbers  , this problem requires information about number properties in order to be resolved efficiently 
	
	//recursive
	public static int gcd(int p, int q){
		if (q==0) return p;
		else return gcd(q, p % q);
	}

	public static int gcd2(int p, int q){
		//while (q!=0){
		while (p!=0){
//			int temp=q;
//			q=p%q;
//			p=temp;
			//I guess this would be the same result (yes) commented and uncommented gives the same result..
			int temp2=p;
			p=q%p;
			q=temp2;
		}
		//return p;
		return q;
	}

	public static void main(String[] args){		
		System.out.println("Solution1: "+Gcd.gcd(25,35)+" Sol2: "
		+Gcd.gcd2(35, 25));
	}
}