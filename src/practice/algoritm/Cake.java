package practice.algoritm;

import java.util.*;


/*
 * The cake has been cut into (N + 1)^2 pieces 
 * 	The cuts are represented by two non-empty zero-indexed arrays A 
 * and B consisting of N integers. More precisely, A[I] such 
 * that 0 ≤ I < N represents the position of a cut along the 
 * first side, and B[I] such that 0 ≤ I < N represents the 
 * position of a cut along the second side
 * 
 * The goal is to find the K-th piece of cake in order of size, starting with the largest piece first. We will consider the size of a piece to be its area.
 * 
 * Complexity:

expected worst-case time complexity is O(N*log(N+X+Y));
expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
Elements of input arrays can be modified.

 *
 *
 *
 *Results:
 *two_cuts 
only two cuts WRONG ANSWER 
got 3 expected 4
 *
 *imple1 
first simple test, every K-th size for 1 <= K <= 16 ✘WRONG ANSWER 
got 4 expected 6


medium_random 
random test with ~400 cuts ✘WRONG ANSWER 
got 89846250 expected 89930748


large_random 
random test with ~100,000 cuts ✘TIMEOUT ERROR 
running time: >10.00 sec., time limit: 4.36 sec.
 */





public class Cake {
	
	//First approach
	public static int solution(int X, int Y, int K, int[] A, int[] B) {
        // write your code in Java SE 8
		//Calculate the main loop iteration
		ArrayList<Integer> sol=new ArrayList<Integer>(); //Capacity [(A.length+1)*(B.length+1)]	
		//Resize Arrays and adding new value at the end and at the beginning
		//Arrays.copyOf(original, newLength);  
		int[] A1=new  int[A.length+2];		
		//int[] A1 = Arrays.copyOf(A, A.length+2); //it copies the original (A) with the given capacity and return the result Array
		int[] B1=new  int[B.length+2];
		System.arraycopy(A, 0, A1, 1, A.length);			
		A1[A1.length-1]=X;		
		//B1=Arrays.copyOfRange(B, 0, B.length+1);
		System.arraycopy(B, 0, B1, 1, B.length);
		B1[B1.length-1]=Y;
		
		int count=0;		
		for (int i=0;i<A1.length-1;i++){
			for (int j=0;j<B1.length-1;j++){
						sol.add(count,(A1[i+1]-A1[i])*(B1[j+1]-B1[j]));
						count++;											
			}//for
		}//for				
		//Now order the array in Desc order and return the K index of the array
		Collections.sort(sol);
		Collections.reverse(sol);	
		//Set it=new LinkedHashSet<Integer>(sol);
		//I need to remove dups..Because is ordered just need to remove the equals next.
		
		for (int i=0;i<sol.size();i++){			
			if (sol.size()>i+1&&sol.get(i).equals(sol.get(i+1)))
				sol.remove(i);
		}
		//lacking last case and check if K is trying to access an ArrayOutOfBound 
		return sol.get(K-1);
    }
	
	//2nd approach
	/*
	 * These are the keys in order to resolve the problem more efficiently:
	 * The cake has been cut into (N + 1)^2 pieces 
	 * 	The cuts are represented by two non-empty zero-indexed arrays 
	 * Conclusion: Both arrays have the same size (possible divisions:1,4,9,16,25,36,49 ..)
	 * 
	 * Resolution method
	 * 1st) Calculate the individual pieces per axis. and put it in an common array. (one loop)
	 * 2nd) Because the multiplicity I know when X axis finish and Y axis starts. 1,4,9,16,25..-->2,3,4,5..
	 * 3rd) Calculate the result array multiplying the values of the single array. (one loop)
	 */
	
	public static int solution2(int X, int Y, int K, int[] A, int[] B) {
        // write your code in Java SE 8
		//Calculate the main loop iteration
		ArrayList<Integer> sol=new ArrayList<Integer>(); //Capacity [(A.length+1)*(B.length+1)]	
		//Resize Arrays and adding new value at the end and at the beginning
		ArrayList<Integer> aux=new ArrayList<Integer>();			
		//Approach array (A1,B1,A2,B2,A3,B3..)		
		for (int i=0;i<A.length-1;i++){
			if (i==0){
				aux.add(A[i]);
				aux.add(B[i]);
			}else{
				aux.add(Math.abs(A[i+1]-A[i]));
				aux.add(Math.abs(B[i+1]-B[i]));
			}			
		}//for
		//Last values (Avoiding Out of Array Bounds Exception)
		aux.add(Math.abs(A[A.length-2]-A[A.length-1]));
		aux.add(Math.abs(B[B.length-2]-B[B.length-1]));
		//Need to add the last values pieces X and Y (input parameters)
		aux.add(Math.abs(X-A[A.length-1]));
		aux.add(Math.abs(Y-B[B.length-1]));
		//The values are perfect (tested)
		
		//Now I need to calculate all the final values knowing where the axis are situated and the length of the Matrix..
		//Play with the numbers knowing the length, I don't have time for this....
		int multFactor=(aux.size()/2)^2;
		for(int i=0;i<aux.size();i++){
			
		}
		
			
		
		
		
		//Now order the array in Desc order and return the K index of the array
		Collections.sort(sol);
		Collections.reverse(sol);	
		//Set it=new LinkedHashSet<Integer>(sol);
		//I need to remove dups..Because is ordered just need to remove the equals next.		
		for (int i=0;i<sol.size();i++){			
			if (sol.size()>i+1&&sol.get(i).equals(sol.get(i+1)))
				sol.remove(i);
		}
		return sol.get(K-1);
    }
	
	
	
	
	
	public ArrayList<Integer> removeDups(ArrayList<Integer> arr){
		
		return arr;
	}
	
	public  static void main(String[] Args){
		int[] inp1={1,3};
		int[] inp2={1,5};		
		
		//System.out.println(solution(2,2,3,new int[]{1},new int[]{1}));
		//System.out.println(solution2(6,7,3,inp1,inp2));
		System.out.println(solution(6,7,3,inp1,inp2));
	}

}
