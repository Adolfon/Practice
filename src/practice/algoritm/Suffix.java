package practice.algoritm;

public class Suffix {

	
	//this one gives the score of 76% bc (100% performance , 65% correctness) it overflows bc I used int for operation(bf, aft)
	public int[] solution(int[] A) {
        // write your code in Java SE 8
        int bf=0;
        int aft=0;
        int result[]=new int[A.length];
        int count=0;
        
        for (int i=0;i<A.length;i++){
        	aft+=A[i];
        }//for
        
        for (int i=0;i<A.length;i++){  
        	aft=aft-A[i];
        	if (bf==aft){        	
        		result[count]=i;
        		count++;        		 
        	}
        	bf+=A[i];
        	        
        }//for     
        return result;
    }//method
	
	
	//Changes that prevented me from getting 100% score
	//The value returned was wrong. I was returning 0 when the algorithm doesnt find a solution, but the truth is that '0' is a 
	//valid position of the array so the answer was wrong. (it decreased my scored in correctness)
	//the var type for calculating after and before: I was using "int" but the test overflow in operation so I changed to "long"
	// Now this algorithm gives the score of 100%.     the complexity is O(n) bc you can not avoid to check every singles position of
	//the array in any way. So that is the worst case scenario.
	 public int solutionWeb(int[] A) {
	        // write your code in Java SE 8
	        long bf=0;
	        long aft=0;                
	        
	        for (int i=0;i<A.length;i++){
	        	aft+=A[i];
	        }//for
	        
	        for (int i=0;i<A.length;i++){  
	        	aft=aft-A[i];
	        	if (bf==aft){        	        		        		
	        		return i;
	        	}
	        	bf+=A[i];        	       
	        }//for     
	        return -1;
	    }
	
	
	
	
	public int solution1(int[] A) {
        // write your code in Java SE 8
        int bf=0;
        int aft=0;
        int result[]=new int[A.length];
        int count=0;
        
        for (int i=0;i<A.length;i++){
        	aft+=A[i];
        }//for
        
        for (int i=0;i<A.length;i++){  
        	aft=aft-A[i];
        	if (bf==aft){        	
        		result[count]=i;
        		count++; 
        		return i;
        	}
        	bf+=A[i];
        	        
        }//for     
        return 0;
    }//method
	
	
	@Override
	public String toString(){		
		return null;
		
	}
	
	public static void main(String args[]){
		int[] ar={-1, 3, -4, 5, 1, -6, 2, 1};
		int[] res=new Suffix().solution(ar);
		for(int i=0;i<res.length;i++)
			System.out.println(" ,"+res[i]);
	}
	
}
