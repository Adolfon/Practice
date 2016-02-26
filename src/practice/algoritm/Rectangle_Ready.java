package practice.algoritm;

public class Rectangle_Ready {
	
	
	public long overlapArea(long X1, long Y1, long X11, long Y11,
            long X2, long Y2, long X22, long Y22) {
		// No overlapping area conditions
		if ( (X2>=X11) || (Y2>= Y11) || (X1>=X22) || (Y1 >= Y22) )
	        return 0;
	    
		//Overlapped area coordinates 		
	    long bl_x = Math.max(X1, X2); //bottom left x
	    long bl_y = Math.max(Y1, Y2); //bottom left y
	    	    	   
	    long tr_x = Math.min(X11, X22); //top right X
	    long tr_y = Math.min(Y11, Y22); // to right Y
	    
	    // Overlapped area calculus
	    return (tr_x - bl_x) * (tr_y - bl_y); 
	    
	}
	
	
		
	
	public static void main(String[] args){
		long result=new Rectangle().overlapArea(2,2,6,6,5,1,9,4);
		System.out.println("Overlapped Area Result: "+result);
		
		//negative X and Y sector
		long result2=new Rectangle().overlapArea(-8,-5,-4,-1,-6,-7,-3,-3);
		System.out.println("Overlapped Negative sector Area Result: "+result2);
		
		//Positive X and Negative Y sector
		long result3=new Rectangle().overlapArea(3,-7,6,-4,4,-9,7,-5);
		System.out.println("Overlapped Negative Y ,positive X sector Area Result: "+result3);
	}

}
