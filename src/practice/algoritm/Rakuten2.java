package practice.algoritm;

public class Rakuten2 {
	public int calcArea(int K, int L, int M, int N,
            int P, int Q, int R, int S) {

	if ( (P>=M) || (Q>= N) || (K>=R) || (L >= S) ){ //No rectangles intersection
		long res= computeArea(K,L,M,N)+computeArea(P,Q,R,S);
		if (res<Integer.MAX_VALUE)
			return (int)res;
		else
			return -1;
	}
	//Rectangles intersection	
	int bl_x = Math.max(K, P); 
	int bl_y = Math.max(L, Q);
	
	
	int tr_x = Math.min(M, R); 
	int tr_y = Math.min(N, S); 
	
	long res_un= computeArea(K,L,M,N)+computeArea(P,Q,R,S)-computeArea(bl_x,bl_y,tr_x,tr_y);
	if (res_un<Integer.MAX_VALUE)	
		return (int) res_un;
	else
		return -1;
		}
	
	public long computeArea(int K, int L, int M, int N) {
		//return Math.abs((M-K) * (N-L));//No negative Area just the value
		return (M-K) * (N-L);
}




public static void main(String[] args){
	
	
	//Positive X and Negative Y sector
	int result=new Rakuten2().calcArea(-4,1,2,6,0,-1,4,3);
	int result2=new Rakuten2().calcArea(20,6,-4,1,0,-1,4,3);
	System.out.println("Total Area Overlapped Negative Y ,positive X sector Area Result: "
	+result+", res2: "+result2);
}
}