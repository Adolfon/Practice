package practice.algoritm;

public class ArraysStructures {

	/* 
	Implement a method to perform basic string compression using the counts of
	repeated characters. For example, the string aabcccccaaa would become
	a2blc5a3. If the "compressed" string would not become smaller than the original
	string, your method should return the original string 
	*/

	public String compressed(String str){
		StringBuilder stringResult=new StringBuilder(""); //In the book solution they use StringBuffer which is the same but syncronized
		int count=1;
		char character=str.charAt(0);
		for (int i=1;i<str.length();i++){
			if (character==str.charAt(i)){//0 compare to 1
				count++;				
			}else{
				stringResult.append(String.valueOf(character)+count);
				count=1;				
			}
			character=str.charAt(i);
		}
		//last case because character is one step behind when exits the loop.
		stringResult.append(String.valueOf(character)+count);
		if (str.length()>=stringResult.length())
			return stringResult.toString();
		else
			return str;
		
	}// procedure
	
	//If they would not let us use StringBuilder or StringBuffer we should do this with a char array. (char[])
	//Using String class the efficiency is O(n2), now with StringBuilder is O(n) (same for char[]) and the space ifficiency is also O(n)
	
	//================================================================
	
	/* Book soultion pag 189 (pdf) (73 printed)
	 * Given an image represented by an NxN matrix, where each pixel in the image is 4
		bytes, write a method to rotate the image by 90 degrees. Can you do this in place?
	
	 The easiest solution is to implement a matrix and rotate the layers 90 degrees
	 For example the left side to the top, the top to the right, the right to the bottom and the 
	 bottom to the left. In this case we go from the outer layer to the inner layer, in a for example
	 4x4 matrix, there are 2 layers. 4 elements array for side the outer and 2 elements array the 
	 inner one.   The function takes as a parameter the matrix and the lenght of the layer or 
	 dimensions of the array (for example a 4x4 array would be:  rotate(matrix[][], 4)
	 */		
	
	
	/* original
	 *   1   2   3   4
	 *   5   6   7   8
	 *   9   10  11  12
	 *   13  14  15  16
	 *   
	 *   Right solution is (rotated)
	 *   
	 *   13   9   5   1
	 *   14   10  6   2
	 *   15   11  7   3
	 *   16   12  8   4

	 *
	 *   
	 *   
	 *   In order to find te solution for this kind of problems ( matrix / multidimensional arrays), the best thing to 
	 *   do is:
	 *   First: Think how manually you would resolv the problem, (mecanically as a person) 
	 *   		(You rotate the the matrix step by step --> left to top, top to right, right to button, bottom to left)
	 *   Second: Start to write an example of a given case: For example a 4x4 Matrix, then write down the matrix and start
	 *   	to take the steps of the manual/mecanical solution. 
	 *   		(For example the movement from left to top)
	 *    let to top
	 *    it implies the top positions receives the left positions in the matrix
	 *    (00) <- (30)                2ND ITERATION
	 *    (01) <- (20)					(11) <- (21)
	 *    (02) <- (10)					(12) <- (11)
	 *    (03) <- (00)
	 *    bottom to the left
	 *    it implies left receive bottom
	 *    (00) <- (30)					(11)<-(21)
	 *    (10) <- (31)					(21)<-(22)
	 *    (20) <- (32)
	 *    (30) <- (33)
	 *    right to bottom
	 *    it implies bottom receives right
	 *    (30) <-(33)					(21)<-(22)
	 *    (31) <-(23)					(22)<-(12)
	 *    (32) <-(13)
	 *    (33) <-(03)
	 *    top to right
	 *    right receives top
	 *    (03) <- (00)					(12)<-(11)
	 *    (13) <- (01)					(22)<-(12)
	 *    (23) <- (02)
	 *    (33) <- (03)
	 *    
	 *    Third: knowing the loops that implies for example a bidimensional matrix (2 nested loops) for the example would 
		 *    be for 0 to 3 and inside another for 0 to 3 which implies 2 vbles from 0 to 3 initially. So now you need to convert
		 *    those variables and to add others in order to make the mecanically example to get to work. Study the relantionship 
		 *    with the first iteration which represent the outer arrays of the matrix and the second iteration which represent 
		 *    the inner of the matrix.  With this you need to infere the general case.
	 *    
	 *   The efficiency for a bidimensional array is at best O(n2) because unavoidable you need to access to all the
	 *   position which means 2 loops, (one nested) so it is n times n. (n al cuadrado)
	 *   
	 *   
	 *   
	 */  
	
	
	public void rotate(int[][] matrix, int n){
		//iterate layers (for example in a 4x4 there will be 2 layers to rotate..)
		for (int layer=0; layer < n/2 ; ++layer){
			int first=layer;
			//last element in the current layer. For example n=4, 0 to 3 (array start 0), first layer 0 to 3 element, nex layer 0 to 2
			int last=n - 1 - layer;
			//Rotate from the outer layer to the inner layer, first iteration changes the square positions,
			for (int i= first; i < last ; ++i){
				//this one, im not sure
				int offset= i - first;
				//save top
				int top = matrix[first][i];
				
				//letft->top (good)
				matrix[first][i]=matrix[last-offset][first];
				
				//bottom -> left (good)
				matrix[last-offset][first]=matrix[last][last-offset];
				
				//right ->buttom (good)
				matrix[last][last-offset]=matrix[i][last];
				
				//top ->right (good)
				matrix[i][last]=top;				
			}//for
		}//for		
	}//procedure
				
		
	
	public static void main (String args[]){
		
		//Array initialization, this is why the 2nd line is better.
		int[] testv = new int[5];
		int[] testv2= {0,0,0,0,0};
		
		
		
	// Algoritm compress section -------------------------------------
		//String test="aaabbbcdefffg"; //I want result:a3b3c1d1e1f3g1
		String test="aaabbbccccdefffgggg";
		String result=new ArraysStructures().compressed(test); //it needs at leas one Object of the present class.
		System.out.println("Exit: "+result);
	// Algoritm compress section -------------------------------------
		
	// Rotate array algoritm section----------------------------------
		int[][] matriz={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};		
		for (int i=0; i<4 ; i++)
			for(int j=0; j<4; j++)
				System.out.println("row: "+i+" column: "+j+" content:"+matriz[i][j]);
		
		new ArraysStructures().rotate(matriz,4);
		
		System.out.println("------------ after rotate the matrix ---------");
		for (int i=0; i<4 ; i++)
			for(int j=0; j<4; j++)
				System.out.println("row: "+i+" column: "+j+" content:"+matriz[i][j]);
		
	// Rotate array algoritm section----------------------------------		
		
	}
	
}
