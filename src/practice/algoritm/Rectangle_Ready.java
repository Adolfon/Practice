package practice.algoritm;


/*
 * What they ask in the real test was the total area
 */

public class Rectangle_Ready {
	
	//The signature of the real question is "int" datatype and names A,B,C,D,E,F,G,H  (change that accordingly)
	//There are some cornercases to take on consider. 
	//The total area value and the individual rectangles cannot be bigger than Integer.MAX value.
	//In that case the the algorithm returns a code  value..
	//I think it was -1 (I am not sure about this though)
	
	//Substitute the parameters name for A,B,C,D,E,F,G,H
	public int overlapArea(int X1, int Y1, int X11, int Y11,
            int X2, int Y2, int X22, int Y22) {
		// No overlapping area conditions
		if ( (X2>=X11) || (Y2>= Y11) || (X1>=X22) || (Y1 >= Y22) )
	        return 0;
	    
		//Overlapped area coordinates 		
	    int bl_x = Math.max(X1, X2); //bottom left x
	    int bl_y = Math.max(Y1, Y2); //bottom left y
	    	    	   
	    int tr_x = Math.min(X11, X22); //top right X
	    int tr_y = Math.min(Y11, Y22); // to right Y
	    
	    // Overlapped area calculus
	    return (tr_x - bl_x) * (tr_y - bl_y); 
	    
	}
	
	/**
	 * Calculate the area of a single rectangle.  (Good for modularized my solution).
	 */
	public int computeArea(int A, int B, int C, int D) {
	    return (C-A) * (D-B);
	}
	
	/*
	 * This would be the real calculus, the total area of two intersecting rectangles (The real test question)
	 * 
	 */
	
	public int computeAreaReal(int A, int B, int C, int D,
            int E, int F, int G, int H) {
		// The addition of area of the two rectangles minus the overlapping area.
		return computeArea(A, B, C, D) + computeArea(E, F, G, H) - overlapArea(A, B, C, D, E, F, G, H);
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
