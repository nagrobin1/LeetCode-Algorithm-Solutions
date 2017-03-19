/**
 * Created by test on 3/19/17.
 * LCS Problem Statement: Given two sequences, find the length of longest subsequence present in both of them.
 * A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous.
 * For example, “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of “abcdefg”. So a string of length n
 * has 2^n different possible subsequences.
 * Examples:
 LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
 LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.

 // Runtime = O(S.length * T.length)
 // Method: Dynamic Programming
 */
public class LongestCommonSubsequence {

    public static int LongestCommonSubsequence(String S, String T) {

        // Substring means the common characters must be physically next to each other

        int C = S.length();
        int R = T.length();

        // rows x column
        // s+1 rows and t+1 columns
        int[][] LCS = new int[R + 1][C + 1];

        // fill in zero of first row
        for (int c = 0; c <= C; c++) {
            LCS[0][c] = 0;
        }

        // Go row by row and fill in values
        // LCS[r][c] = LCS[r-1][c-1] + 1 if S[c] == T[r]
        // Look up diagonally in table
        // Else LCS[r][c] = max(LCS[r-1][c] , LCS[r][c-1])
        for (int r = 1; r <= R; r++) {
            for (int c = 1; c <= C; c++) {
                if (T.charAt(r - 1) == S.charAt(c - 1)) {
                    LCS[r][c] = LCS[r - 1][c - 1] + 1;
                } else {
                    LCS[r][c] = Math.max(LCS[r-1][c] , LCS[r][c-1]);
                }
            }
        }
        return LCS[R][C];
    }


    public static void main(String [] args){
        String S = "AGGTAB";
        String T = "GXTXAYB";

        System.out.println("Longest Coommon Substring is: " + LongestCommonSubsequence(S,T));
    }

}
