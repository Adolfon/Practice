package practice.algoritm;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class ComplementaryAlgth {

	//Algorithms to find complemantary pairs of numbers in an array
	
	/*
	 * The problem is to find in an array A of int values the number of all pairs 
	 * of indices (i,j) so that A[i] + A[j] == K. 
	 * For example, let A = { 1, 5, 9 } with K = 10 we get the pairs 
	 * (0, 2), (2,0), and (1,1) and the result of the algorithm should be 3.
	 */
	
	
	//First simple solution: O(n^2) 
	public static int comp_pairs( int K, int[ ] A )
	{
	  int count = 0;
	 
	  for ( int i = 0; i < A.length; i++ )
	  {
	    for ( int j = i; j < A.length; j++ )
	    {
	      if ( A[ i ] + A[ j ] == K )
	      {
	        if ( i != j )
		{
		  count += 2;
		}
		else
	        {
		  count++;
		}
	      }
	    }
	  }
	 
	  return count;
	}
	
	//Second approach
	// 1 Remove duplicates and count them
	//2 Now put the array values (without dups) in a TreeMap
	// TreeMap log(n) for : containsKey, get, put and remove operations.
	//TreeMap is not synchronized..
	
	//We traverse the sorted array from left and right to the middle searching for the complimentary in the TreeMap
	public static int comp_pairs2( int K, int[ ] A )
	{
	  Map<Integer, Integer> B = new TreeMap<Integer, Integer>( );
	 
	  for ( int i = 0; i < A.length; i++ )
	  {
	    final int k = A[ i ];
	    final int tempValue = B.containsKey( k ) ? B.get( k ) : 0;
	    B.put( k, tempValue + 1 );
	  }
	 
	  Integer[ ] C = new LinkedList<Integer>( B.keySet( ) ).toArray( new Integer[ 0 ] );
	  int l = 0;
	  int r = C.length - 1;
	  int count = 0;
	 
	  while ( l <= r )
	  {
	    if ( C[ l ] + C[ r ] == K )
	    {
	      final int c1 = B.get( C[ l ] );
	      final int c2 = B.get( C[ r ] );
	 
	      count += ( l != r ) ? 2 * c1 * c2 : c1 * c1;
	 
	      l++; 
	      r--;
	    }
	    else if ( C[ l ] + C[ r ] < K )
	    {
	      l++;
	    }
	    else
	    {
	      r--;
	    }
	  }
	  return count;
	}
	
	
	
	//Running in O(n) complexity, found in ("http://peter-braun.org/2012/01/algorithms-to-find-complemantary-pairs-of-numbers-in-an-array/");
	public static long foo_opt( long k, long[ ] A )
	{
		//Array that I am going to scan O(1) , it is an array of complementary values of the given Array. 
		//So I am going to search (scan) for those values in the given array (A) if does exist the the pair exists and I can
		//add to the result counter. Duplicates are treated because in the scan array increments the value.
	  Map<Long, Long> C = new HashMap<Long, Long>( );
	  for ( int i = 0; i < A.length; i++ )
	  {
	    final long complValue =   k  - A[ i ]; //complementary value.
	    final long tempValue = C.containsKey( complValue ) ? C.get( complValue ) : 0; //if exist that value return it, if not initialize the count to 0+1; 
	    C.put( complValue, tempValue + 1 ); //that value exist tempValue times..
	  }
	 
	  long counter = 0;
	  for ( int i = 0; i < A.length; i++ )
	  {
	    final long value = A[ i ];
	    counter += C.containsKey( value ) ? C.get( value ) : 0; //Scan for the complimentary
	  }
	 
	  return counter;
	}
	
	
	
	
	public static void main(String[] args){
		long[] A={1,5,9,3};
		int[] A2={1,5,9,3};
		int search=10;
		int n=comp_pairs2(search,A2);
		System.out.println(n);
		long n2=foo_opt(search,A);
		System.out.println(n2);
		
		
		long[] A3={1,5,9,3,1,5,7};		
		int search2=6;
		long n3=foo_opt(search2,A3);
		System.out.println("Valor: "+n3);
	}
	
	
}
