package practice.algoritm;

import java.util.HashMap;
import java.util.Map;

public class Complementary_Ready {

	public  long complementValue( long k, long[ ] A )
	{		
	  Map<Long, Long> C = new HashMap<Long, Long>( );
	  long complement=0,aux=0;
	  for ( int i = 0; i < A.length; i++ )
	  {
	     complement =   k  - A[ i ]; //complementary value to search for.	    
	     aux = 0;	    
	    if ( C.containsKey( complement ))
	    	aux=C.get( complement );	    	    
	    C.put( complement, aux + 1 ); //that value exists aux variable times..
	  }
	 
	  long counter = 0;
	  for ( int i = 0; i < A.length; i++ )
	  {
	    final long value = A[ i ];	    
	    //Scan for the complimentary
	    if (C.containsKey(value))
	    	counter+= C.get(value);	    
	  }
	 
	  return counter;
	}
	
	
	public static void main(String[] args){
		long[] A={1,5,9,3,7};		
		int search=6;		
		long n2=new Complementary_Ready().complementValue(search,A);
		System.out.println(n2);
		long n3=new Complementary_Ready().complementValue(6, new long[] {1,5,9,3,1,5,7});
		System.out.println(n3);
		
	}
	
	
}
