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
 * Complete problem description:
 * 
 * You want to spend your next vacation in Poland. Despite its not being a very big country, Poland has a highly diverse natural environment ranging from the Baltic Sea in the north to the Tatra Mountains in the south. As you enjoy swimming in the sea as well as trekking up mountains, you would like to spend some time in both of those locations. However, the weather in Poland can sometimes be very capricious, so you also need to take that into account when planning your vacation.

In the summer you are free for N consecutive days. You can start and finish your vacation on any of these days. You want to spend the first part of your vacation at the seaside and the remaining part in the mountains. These parts can each be of any positive length, and you want to maximize the total length of the vacation.

You have obtained a weather forecast for all N days when you are free. By curious coincidence, the weather on every day is expected to be either perfect for spending the day at the seaside but not in the mountains, or vice versa (perfect for trekking but not for swimming). Obviously, you want the best possible weather during each part of your vacation, so you require the weather to be perfect for swimming for more than half of the days in the first part of your vacation, and perfect for trekking for more than half of the days in the second part of your vacation.

The weather forecast is described in a zero-indexed array A: for each K (0 ≤ K < N), A[K] is equal to 0 if the weather during day K favors the seaside, or 1 if the weather during that day favors the mountains.

Write a function:

class Solution { public int solution(int[] A); }

that, given a zero-indexed array A of N integers, returns the length of the longest vacation consistent with your requirements.

For example, consider array A such that:

    A[0] = 1
    A[1] = 1
    A[2] = 0
    A[3] = 1
    A[4] = 0
    A[5] = 0
    A[6] = 1
    A[7] = 1
You are free for eight days. The weather during days 2, 4 and 5 will be better for swimming, and better for trekking during the remaining days. You can start your vacation on day 1, spend five days at the seaside (three days will have perfect weather, which is more than half) and then spend two days in the mountains (both days will have perfect weather). That results in a vacation length of seven days, which is the longest possible vacation that meets your criteria, so the function should return 7.

For array A such that:

    A[0] = 1
    A[1] = 0
there is no vacation that satisfies your requirements, so the function should return 0.

Assume that:

N is an integer within the range [2..100,000];
each element of array A is an integer that can have one of the following values: 0, 1.
Complexity:

expected worst-case time complexity is O(N);
expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
Elements of input arrays can be modified.
 * 
 * 
 * 
 * solution: http://stackoverflow.com/questions/29826705/longest-slice-of-a-binary-array-that-can-be-split-into-two-parts
 */


//Supposedly bad solution O(n^3)??? I see O(n) I dunno?? anyway the best
//solution a guy coded in C, here is the code:

/*
 * 
 * 
 * 
 * 
 * 
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
 * 
 * 
 * 
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
