package practice.algoritm;


/*
 * 1. TrekAndSwim (Argon 2015, codility)
Find a longest slice of a binary array that can be split into 
two parts: in the left part, 0 should be the leader; in the right 
part, 1 should be the leader.

For array ={1,0}  should return 0.

N is an integer within the range [2..100,000];
each element of array A is an integer that can have one of the 
following values: 0, 1.
 * 
 * expected worst-case time complexity is O(N);
expected worst-case space complexity is O(N), 
beyond input storage (not counting the storage required for input
 arguments).
 * 
 * solution: http://stackoverflow.com/questions/29826705/longest-slice-of-a-binary-array-that-can-be-split-into-two-parts
 */


//Supposedly bad solution O(n^3)??? I see O(n) I dunno?? anyway the best
//solution a guy coded in C, here is the code:

/*
 * int f4(int* src,int n)
{
    int i;
    int sum;
    int min;
    int sta;
    int mid;
    int end;

    // Find middle
    sum = 0;
    mid = -1;
    for (i=0 ; i<n-1 ; i++)
    {
        if (src[i]) sum++;
        else sum--;

        if (src[i]==0 && src[i+1]==1)
        {
            if (mid==-1 || sum<min)
            {
                min=sum;
                mid=i+1;
            }
        }
    }
    if (mid==-1) return 0;

    // Find start
    sum=0;
    for (i=mid-1 ; i>=0 ; i--)
    {
        if (src[i]) sum++;
        else sum--;

        if (sum<0) sta=i; 
    }

    // Find end
    sum=0;
    for (i=mid ; i<n ; i++)
    {
        if (src[i]) sum++;
        else sum--;

        if (sum>0) end=i+1; 
    }

    return end-sta;
}
 * 
 */
public class LongVacation {

	public static int solution(int[] A)
    {
        int length = A.length;
        if (length <2|| length>100000)
            return 0;
        if (length == 2 && A[0] != A[1])
            return 0;
        if (length == 2 && A[0] == A[1])
            return 2;
        int zerosCount = 0;
        int OnesCount = 0;
        int start = 0;
        int end = 0;
        int count=0;

        //left hand side
        for (int i = 0; i < length; i++)
        {
            end = i;
            if (A[i] == 0)
                zerosCount++;
            if (A[i] == 1)
                OnesCount++;
            count = i;
            if (zerosCount == OnesCount )
            {
                start++;
                break;
            }

        }

        int zeros = 0;
        int ones = 0;

        //right hand side
        for (int j = end+1; j < length; j++)
        {
            count++;
            if (A[j] == 0)
                zeros++;
            if (A[j] == 1)
                ones++;
            if (zeros == ones)
            {
                end--;
                break;
            }
        }
        return count;
    }
	
	public static void main(String[] args){
		int[] A={1,1,0,1,0,0,1,1};
		int sol=solution(A);
		System.out.println("Solution: "+sol);
	}
	
}
