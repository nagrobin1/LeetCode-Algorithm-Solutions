/**
 * Created by test on 3/19/17.
 */
public class LongestCommonSubstring {

    public static String LongestCommonSubstring(String S, String T){
        // Substring means the common characters must be physically next to each other

        int C = S.length();
        int R = T.length();
        // length of the longest common substring
        int maxLen = 0;
        // keep the location of maxLen found in the 2-D array
        // in order to backtrack and output the sequence
        int Rmax = 0;
        int Cmax = 0;

        // rows x column
        // s+1 rows and t+1 columns
        int [][] LCS = new int[R+1][C+1];

        // fill in zero of first row
        for(int c = 0; c <= C; c++){
            LCS[0][c] = 0;
        }

        // fill in zero of first column
        for(int r = 0; r <= R; r++){
            LCS[r][0] = 0;
        }

        // Go row by row and fill in values
        // LCS[r][c] = LCS[r-1][c-1] + 1 if S[c] == T[r]
            // Look up diagonally in table
        // Else LCS[r][c] = 0, since we broke the contigous property
        for(int r = 1; r <= R; r++){
            for(int c = 1; c <= C; c++){
                if(T.charAt(r-1) == S.charAt(c-1)){
                    LCS[r][c] = LCS[r-1][c-1] + 1;
                    // update the maxlen if you see a newer value
                    if(LCS[r][c] > maxLen){
                        maxLen = LCS[r][c];
                        Rmax = r;
                        Cmax = c;
                    }
                }else{
                    LCS[r][c] = 0;
                }
            }
        }

        // Backtrack
        int lengthOfLongestCommonSubstring = maxLen;
        String resultString = "";
        while (lengthOfLongestCommonSubstring > 0){
            // Get the character where we found a match and +1
            // Can use wither string S or T
            if(LCS[Rmax][Cmax] == lengthOfLongestCommonSubstring){
                resultString = resultString + T.charAt(Rmax-1);
                Rmax--;
                Cmax--;
                lengthOfLongestCommonSubstring--;
            }

        }

        return reverseString(resultString);
    }


    public static String reverseString(String s){

        String output = "";
        for(int i = s.length()-1; i >= 0; i--){
            output = output + s.charAt(i);
        }

        return output;
    }

    public static void main(String[] args){

        String S = "aRxc";
        String T = "laxc";

        System.out.println("Longest Coommon Substring is: " + LongestCommonSubstring(S,T));

    }

}
