package practice.algoritm;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * As a technique used in order to make seeing the trends on a time sequential graph easier, there is something called a 
 * moving average. It is a technique where a value is determined by averaging the immediately preceding points of an element,
 *  and drawing a graph based on those values.
For example in stock prices, in order to see a short-term trend, a 25 day moving average taken from averaging the past 25 days
 of data is used.
When a real array is given as data, write a program that determines a 3 element moving average and creates an array. 
The number of elements in the array becomes 2 elements shorter than the given sequence. For example, 
if you are given [7.0 ,9.0 ,5.0 ,1.0 ,3.0], you get [7.0, 5.0, 3.0].

So what I understood is that you have to read groups of 3 an array and calculate the average in the result array and 
continuing doing so until in this case length of array  - 2

I want to generalize this particular case in order to reuse purpose so I will be using generics as a parameter type array,
and the number of groups you want to do the average for.
In this case would be groups of 3.
First you need a checker so the number of groups is smaller than the array. This case groups of 3 < array length= okay
the number of groups >0


I have an idea, what if I setup a variable with the sum of groups - 1 and I just add 
the next value divide per group until the end of the algorithm.In this way I would save
a lot of loops ...
For example 5 elements groups of 3.
accumulated of 2 values - first one + next one / group
it would be like a list. first element, last element and next element.
 */
public class LineTest {

	public ArrayList<Float> movingAverage(ArrayList<Float> array, int groups){
		if (groups> array.size()||groups==0)
			return null;		
		if (groups==1)
			return array;
		ArrayList<Float> result=new ArrayList<Float>();
		Float average;
		for (int i=0; i<=array.size()-groups; i++){			
			average=new Float(0);
			for (int j=i;j<=i+groups-1;j++){
				average+=array.get(j);				
			}		
			average=average/groups;
			result.add(average);				
		}		
		return result;
	}
	
	
	public ArrayList<Float> solution2(ArrayList<Float> array, int groups){
		//Error conditions
		if (groups> array.size()||groups==0)
			return null;	
		//Performance condition
		if (groups==1)
			return array;
		Float average=new Float(0);				
		int a,position; position=0;
		//Initial group
		for(a=0; a<groups; a++) 
			average+=array.get(a);			
		ArrayList<Float> result=new ArrayList<Float>();	
		result.add(average/groups);
		//Remaining array
		for (int i=a; i<=array.size()-1; i++){			
			average-=array.get(position);
			average+=array.get(i);
			position++;			
			result.add(average/groups);				
		}		
		return result;
	}
	
	
	
	/*
	 * When n is a positive integer, there is a function f(n) which satisfies the following.
		f(0)=0
		f(1)=1
		f(n)=f(n-1)+ f(n-2)
		Please create a program to determine f(n) . (You can write in the language 
		that you are good at.)
		
		This is exposed in a way that make the resolution very easy for recursive 
		programming but extremely inefficient O(2 power n).
	 */
	
	public double f(int a){
//		if (a==0)
//			return 0;
//		if (a==1)
//			return 1;	
//		return f(a-1)+f(a-2);
		if (a<2)
			return a;
		else
			return f(a-1)+f(a-2);
	}//function
	
	//With double type values
	public double fibo(int n){
		double before1,before2,number;
		before1=number=0;
		before2=1;
		for (int i=0; i<=n; i++){
			before1=before2;
			before2=number;
			number=before1+before2;
		}
		return before2;
	}
	
	//With BigInteger for very Big values
	public BigInteger fiboBig(int n){
		BigInteger before1,before2,number;
		number=new BigInteger("0");
		before1=number;
		before2=new BigInteger("1");
		for (short i=0; i<=n; i++){
			before1=before2;
			before2=number;
			number=before1.add(before2);
		}
		return before2;
	}
	//You can save one variable but I left it this way for readability.
	//For calculations n<1477 (approximately) you can use double type in order to save memory
	
	public BigInteger fiboBig2(int n){
		BigInteger before1,before2,number;
		before1=number=new BigInteger("0");		
		before2=new BigInteger("1");
		for (int i=0; i<=n; i++){
			before1=before2;
			before2=number;
			number=before1.add(before2);
		}
		return before2;
	}
	
	public void functionFiboResult(int n){
		double result;
		BigInteger bi;
		//Iterative Big
		bi=fiboBig2(n);
		System.out.println("Iterative big result of "+n+" ,is "+bi);
		//Iterative
			result=fibo(n);
			System.out.println("Iterative result of "+n+" ,is "+result);
		//Recursive
//			result=f(n);	
//			System.out.println("Recursive result of "+n+" ,is "+result);
	}
	
	//It can be improved analyzing the series and finding rules to apply in order to get
	//the numbers of that serie and later generalize.
	//For example Exponentiation by squaring methods (O(log n)).
	//Based on power expressions applied to the odd or even positions of number from that series.
	
	/*
	 * 
	 */
	
	
	/**  (Saves one variable through calculation of one of the variables)
	    * returns the Nth number in the Fibonacci sequence 
	    */
	  public int fibonacci(int N) {
	      int lo = 0;
	      int hi = 1;
	      for (int i = 0; i < N; i++) {
	          hi = lo + hi;
	          lo = hi - lo;
	      }
	      return lo;
	  }
	
	
	public void LineTest(){};
	
	public static void main(String args[]){
		float[] arr={7.0f, 9.0f, 5.0f, 1.0f, 3.0f};
		ArrayList<Float>  array=new ArrayList<Float>();
		List<Float> myList =
	              new ArrayList<Float>(Arrays.asList(7.0f, 9.0f, 5.0f, 1.0f, 3.0f));
		array=new LineTest().solution2((ArrayList<Float>)myList,3);
		
		for (int i=0;i<array.size();i++)
			System.out.println(array.get(i));
		
		
	/*
	 * Use the program from (1) to determine f(8181)
	 */
		//from 1477 and on the result for double is Infinity
		//>17181 BigInteger in trouble..today for >17390 ... (it depends of the memory 
		//reserved for the VM for the different types, for example today for double type
		//the maximum is 1476 (I need further research for this conclusions..)
		new LineTest().functionFiboResult(8181);
		
	}
	
	
	
}
