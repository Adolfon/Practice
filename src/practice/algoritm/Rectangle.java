package practice.algoritm;

public class Rectangle {
	
	
	/**
	 * Calculate the overlapping area of two rectangles.
	 * I think the most important thing in this problem is how you do 
	 * the assumptions. Representation of the rectangles.
	 * 
	 * There are 4 coordinates in every Rectangle represented in 2D by (x,y) planes
	 * so in total there are 8 numbers by rectangle.
	 * In each rectangle you can assume two coordinates based in the other two. So 
	 * you can represent the both rectangles with only 2 coordinates each (x,y)(x,y)
	 * and the other (x1,y1)(x1,y1).
	 * This in the program are called (A,B) (C,D) for one rectangle and (CD)(EF) for 
	 * the other.
	 * It will be easier to understand just calculating the sides of each rectangles
	 * and putting names to it. After that calculate each sides of the overlapped 
	 * rectangle and calculate its area. (it will gain readability but it will use 
	 * more memory for each variable that you want to use.. 
	 * 
	 * Another case where is not directly intuitive how to write the algorithm
	 * In this cases you have to paint on paper the cases and derive the general rule.
	 * for example overlapped space inside of the 4 quadrant (+x +y)(+x -y) (-x -y)(-x +y)
	 *  So you can calculate the coordinates of overlapped space (square/rectangle) and its
	 *  area. 
	 *  
	 *  
	 */
	public int overlapArea(int A, int B, int C, int D,
	                        int E, int F, int G, int H) {
	    /* Check if there is indeed an overlap.
	     * e.g.  E >= C  i.e. the most left point of the rectangle (EFGH) is 
	     *       on the right side of the most right point of the rectangle (ABCD),
	     *       therefore there is no overlapping.
	     *       
	     *       Once one Axis is not cutting the other, there is not way of 
	     *       intersection space between rectangles
	     *       
	     *       (E,F)>(C,D) (it is on the right)
	     *       
	     *       (A,B)>(G,H) (it is on the left)
	     *       
	     */
	    if ( (E>=C) || (F>= D) || (A>=G) || (B >= H) )
	        return 0;
	    
	    /* bottom left point of the overlapping area. */
	    //It doesnt make sense unless you paint it. (then you understand..)
	    int bl_x = Math.max(A, E); //bottom left x
	    int bl_y = Math.max(B, F); //bottom left y

	    /* top right point of the overlapping area. */
	    int tr_x = Math.min(C, G); //top right X
	    int tr_y = Math.min(D, H); // to right Y

	    //return (tr_x - bl_x) * (tr_y - bl_y); //same as bellow..
	    return computeArea(bl_x,bl_y,tr_x,tr_y);
	}

	/**
	 * Calculate the area of a single rectangle.
	 */
	public int computeArea(int A, int B, int C, int D) {
	    return (C-A) * (D-B);
	}

	/**
	 * Find the total area covered by two rectilinear rectangles in a 2D plane.
	 * Each rectangle is defined by its bottom left corner and top right corner.
	 * 
	 * Left bottom corner (x,y) coordinates
	 * Right top corner (x,y) coordinates
	 * 
	 * The other points are deducted from this ones before.
	 * 
	 *int area = computeArea(x1,y1,x2,y2)
	 * 
	 */
	public int computeArea(int A, int B, int C, int D,
	                       int E, int F, int G, int H) {
	    // The addition of area of the two rectangles minus the overlapping area.
	    return computeArea(A, B, C, D) + computeArea(E, F, G, H) - 
	           overlapArea(A, B, C, D, E, F, G, H);
	}
	public static void main(String args[]){
		//I just want to know the overlapped area of 2 triangles
		//Parameters left bottom coordinate,top right coordinate (1 triangle)
		// left bottom coordinate, right top coordinate (second triangle)
		
		//Tests (Result= it works perfect, tested on paper with a graph as well..)
		//positive X and Y sector
		int result=new Rectangle().overlapArea(2,2,6,6,5,1,9,4);
		System.out.println("Overlapped Area Result: "+result);
		//negative X and Y sector
		int result2=new Rectangle().overlapArea(-8,-5,-4,-1,-6,-7,-3,-3);
		System.out.println("Overlapped Negative sector Area Result: "+result2);
		//Positive X and Negative Y sector
		int result3=new Rectangle().overlapArea(3,-7,6,-4,4,-9,7,-5);
		System.out.println("Overlapped Negative Y ,positive X sector Area Result: "+result3);
		
		
		/*
		 * Overlapped Area Result: 2
			Overlapped Negative sector Area Result: 4
			Overlapped Negative Y ,positive X sector Area Result: 4
		 */
	}

	//Work in a solution with 8 input parameters ... (you just pass 8 and use only the ones you want adapting this 
	//solution..
}
