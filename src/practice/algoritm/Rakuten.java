package practice.algoritm;

public class Rakuten {
	public int calcArea(int K, int L, int M, int N,
            int P, int Q, int R, int S) {

	if ( (P>=M) || (Q>= N) || (K>=R) || (L >= S) ){
		long res= computeArea(K,L,M,N)+computeArea(P,Q,R,S);
		if (res<Integer.MAX_VALUE)
			return (int)res;
		else
			return -1;
	}

	int bl_x = Math.max(K, P); 
	int bl_y = Math.max(L, Q);
	
	
	int tr_x = Math.min(M, R); 
	int tr_y = Math.min(N, S); 
	
	long res_un=computeArea(bl_x,bl_y,tr_x,tr_y);
	return (int) res_un;
		}
	
	public long computeArea(int K, int L, int M, int N) {
		return (M-K) * (N-L);
}




public static void main(String[] args){
	
	
	//Positive X and Negative Y sector
	long result3=new Rakuten().calcArea(-4,1,2,6,0,-1,4,3);
	System.out.println("Overlapped Negative Y ,positive X sector Area Result: "+result3);
}
}
