import AuxFunctions.PrintArray;
/**
 * Created by test on 3/12/17.
 * DYNAMIC PROGRAMMING
 * The Longest Increasing Subsequence (LIS) problem is to find the length of the longest subsequence of a
 * given sequence such that all elements of the subsequence are sorted in increasing order.
 * For example, the length of LIS for {10, 22, 9, 33, 21, 50, 41, 60, 80} is 6 and LIS is {10, 22, 33, 50, 60, 80}.
 *
 * Let arr[0..n-1] be the input array and L(i) be the length of the LIS ending at index i such that arr[i] is the last element of the LIS.
 Then, L(i) can be recursively written as:
 L(i) = 1 + max( L(j) ) where 0 < j < i and arr[j] < arr[i]; or
 L(i) = 1, if no such j exists.
 To find the LIS for a given array, we need to return max(L(i)) where 0 < i < n.
 Thus, we see the LIS problem satisfies the optimal substructure property as the main problem can be solved using solutions to subproblems.
 */

public class LongestIncreasingSubsequence {

    public static void main (String[] args) {

        int[] B = {10, 9, 2, 5, 3, 7, 101, 18};
        LISresult(B);
    }

    public static void LISresult(int[] A) {
        // create an auxillary LIS array, where LIS[k] represents the
        // longest increasing subsequence upto index k, including the value
        // at index k

        int len = A.length;
        int[] LIS = new int[len];

        // Fill in the LIS array with all 1s because we are assuming that there
        // are no LIS and each element is the best LIS
        for (int k = 0; k < len; k++) {
            LIS[k] = 1;
        }

        // Process LIS
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                // +1 because we just found that A[j] < A[i]
                if ((A[j] < A[i]) && (LIS[i] < LIS[j] + 1)) {
                    // LIS[i] now must include the best LIS that is seen up to index i,
                    // which now includes LIS[j] as an optimal subsolution
                    LIS[i] = LIS[j] + 1;
                }
            }
        }

        // Find the maximum value in LIS and the index where that is
        int maxLIS = 0;
        int indexOfMax = 0;

        for (int i = 0; i < len; i++) {
            if (LIS[i] > maxLIS) {
                maxLIS = LIS[i];
                indexOfMax = i;
            }
        }

        System.out.println("Length of Longest Increasing Subsequence is  " + maxLIS);

        // Find the actual sequence of LIS
        // Go to LIS array and find the largest value, say LARGE. Store its index.
        // Then do LARGE = LARGE - 1, and look for the new LARGE value and store its index
        // Keep doing until LARGE > 0
        // Using these saved indexes, we go and extract the values at these indexes in the original array A

        // this array will hold the items of the longest increasing subsquence
        int [] final_result = new int[maxLIS];
        // we will fill the array from back to front
        int p = maxLIS - 1;

        for (int k = indexOfMax; k >= 0 && maxLIS > 0; k--) {

            if (LIS[k] == maxLIS) {
                final_result[p] = A[k];
                p--;
                maxLIS--;
            }
        }

        PrintArray.print_array(final_result);
    }
}