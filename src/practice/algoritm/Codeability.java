package practice.algoritm;

public class Codeability {

	
	//Natrium 2014  (Test)
	//Find a pair (P, Q), such that A[P] <= A[Q] and the value Q - P is maximal (in distance inside the positions of the array).
	
	
	/*
	 * A non-empty zero-indexed array A consisting of N integers is given.

A monotonic pair is a pair of integers (P, Q), such that 0 ≤ P ≤ Q < N and A[P] ≤ A[Q].

The goal is to find the monotonic pair whose indices are the furthest apart. More precisely, we should maximize the value Q − P. 
It is sufficient to find only the distance.

For example, consider array A such that:

    A[0] = 5
    A[1] = 3
    A[2] = 6
    A[3] = 3
    A[4] = 4
    A[5] = 2
There are eleven monotonic pairs: (0,0), (0, 2), (1, 1), (1, 2), (1, 3), (1, 4), (2, 2), (3, 3), (3, 4), (4, 4), (5, 5). 
The biggest distance is 3, in the pair (1, 4).

Write a function:

class Solution { public int solution(int[] A); }

that, given a non-empty zero-indexed array A of N integers, returns the biggest distance within any of the monotonic pairs.

For example, given:

    A[0] = 5
    A[1] = 3
    A[2] = 6
    A[3] = 3
    A[4] = 4
    A[5] = 2
the function should return 3, as explained above.

Assume that:

N is an integer within the range [1..300,000];
each element of array A is an integer within the range [−1,000,000,000..1,000,000,000].
Complexity:

expected worst-case time complexity is O(N);
expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
Elements of input arrays can be modified.

Copyright 2009–2016 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
	 */
	
	//we are going to use a list with positions (already in Java api) adding the paths per order;
	//position firt lenght 1, position 2 length 2.
	
	class Node{
		public int x,y;
	}
	public int solution(int[] A) {
        // write your code in Java SE 8
		int max=0,min = 0,i=0;		
		for (i=0;i<A.length;i++){
			if (A[i]< min)
				min=A[i];
			if (A[i]>max)
				max=A[i];
		}//for
		return max-min;
    }
	
	public int solutionR(int[] A) {
		//I need a structure that keep 3 values Ex: distance between (0,2)=yes (0,1)=false; ... 
		//Aux array with inside of every position keeps the value of the distance or 0 if it is not valid distance
		
		for (int i=0; i<A.length; i++){
			int distance=0;		
			for (int j=i; j<A.length;j++){
				if (A[i]>A[j])
					//put Node with i,j and distance
					distance++;
			}
				
		}
		// traverse the List or return the last element, do the subtraction and return the value.
		return 0;
    }
	
	
	//Solution for the problem====================================================================
	
	//so you can quickly find them with binary search:
	//it finds the higher position of the higher number of the actual...
	//				A(0)=5  , returns 2,  path 2-0= 2
	//				A(1)=3 , returns 4 , path 4-1=3   this is the best (longest path)
	//				A(2)=6  , returns 2, path 2-2=0
	//				A(3)=3 , return 4, path 4-3=1
	
	//Search in the given sorted (descending) array in what position should be placed "min" number. The array is sorted
	static int find(int[] t, int mynumber) { //inversed top array and then actual number in the real array
	    int first = 0; //inferior array limit
	    int last = t.length-1;  //top array limit
	    //last reversed array element which means is the smaller number possible
	    if (t[last] >= mynumber) return last;

	    while (true) {
	        int middle = (first+last) / 2; //point to the arrays middle
	        // Exit condition
	        //if the middle point is the array length (the last element..) return this element.	(we reached the end) (end condition)       	        
	        if (middle == t.length-1) return t.length-1;
	        //We found the position when it is the changing point
	        if (t[middle] >= mynumber && t[middle+1] < mynumber) return middle;
	        //rearrange array delimitations  lowest s, highest e 
	        if (t[middle] < mynumber) last = middle; //remember the array is in descending order..
	        else first = middle;
	    }
	}
	
	
	public static void main(String[] args){
		
		//Create a temporary array containing "maximum" values in descending order:
		//For the given array int[] A={5,3,6,3,4,2}; top array would be:int top={6,6,6,4,4,2}
		int[] A={5,3,6,3,4,2};			
		int[] top = new int[A.length];
		int max = -Integer.MAX_VALUE;
		for (int i=A.length-1; i>=0; i--) {
		    if (A[i] > max) max = A[i];
		    top[i] = max;
		}
		
		//Final solution part
		int best = 0;
		for (int i=0; i<A.length; i++) {
		    int c = find(top, A[i]) - i;//this is the path number, the position that the number should be - your position 
		    //if you found a path which number is bigger than the possible later solution (array length remaining) then stop
		    if (c > best) best = c;
		    if (best >= A.length-i)
		    	//return best;
		    	break;
		}

		//return best;
		System.out.println("O(n long n) Best: "+best);
		
		//For debug purpose clarity only (A1,Top1)
		int A1,top1;
		//Best solution O(n) complexity (it just change the search method for the top array)
		// Search incrementally at the same time you are traversing in the given array that is
		//why this algorithm is complexity O(n), traverse 2 arrays at the same time. (it would be
		//like 2 consecutive loops complexity...
		int bestN = 0;
		int curMaxIndex = 0;
		for (int i=0; i<A.length; i++) { //check the whole given array
			//Debug vars A1 Top1
			A1=A[i];top1=top[curMaxIndex];
		    while(curMaxIndex < top.length && top[curMaxIndex] >= A[i]){ //check whole top array && while bigger position in top array than the given array..		    	
		        curMaxIndex++;
		      if(top.length<curMaxIndex) top1=top[curMaxIndex]; //Just for debug, "if" avoids IndexOutOfBounds Exception
		    }
		    if((curMaxIndex - 1 - i) > bestN)
		    	bestN = curMaxIndex - 1 - i;
		}//for

		System.out.println("O(n) linear complexity result: "+ bestN); 
		
		
		
	}
	/*
	 * Solutions found in StackOverflow
	 * 
	 * This one is O(n log n)
	 * 
	 * 

Create a temporary array containing maximum values in descending order:

int[] top = new int[A.length];
int max = -Integer.MAX_VALUE;
for (int i=A.length-1; i>=0; i--) {
    if (A[i] > max) max = A[i];
    top[i] = max;
}
//so you can quickly find them with binary search:

int find(int[] t, int min) {
    int s = 0;
    int e = t.length-1;

    if (t[e] >= min) return e;

    while (true) {
        int x = (s+e) / 2;
        if (x == t.length-1) return t.length-1;
        if (t[x] >= min && t[x+1] < min) return x;

        if (t[x] < min) e = x;
        else s = x;
    }
}

//And you got a solution:

int best = 0;
for (int i=0; i<A.length; i++) {
    int c = find(top, A[i]) - i;
    if (c > best) best = c;
    if (best >= A.length-i) return best;
}

return best;
	 *   Now this is the best that I could find runs in O(n)
	 *   
	 *   the before algorithm still runs in n log n. 
	 *   You can optimize by not doing your log n lookup every time. Instead, iterate forward over your max array and 
	 *   your input A[] array at the same time to guarantee linear time.

int[] top = new int[A.length];
int max = -Integer.MAX_VALUE;
for (int i=A.length-1; i>=0; i--) {
    if (A[i] > max) max = A[i];
    top[i] = max;
}

int best = 0;
int curMaxIndex = 0;
for (int i=0; i<A.length; i++) {
    while(curMaxIndex < top.length && top[curMaxIndex] >= A[i])
        curMaxIndex++;
    if((curMaxIndex - 1 - i) > best)
        best = curMaxIndex - 1 - i
}

return best; 
	 */
	
	
	
}
