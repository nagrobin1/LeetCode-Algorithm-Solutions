import java.util.HashMap;

/**
 * Created by test on 2/17/17.
 */
public class lengthOfLongestSubstring {

    public static void main(String [] args){

        System.out.println(lengthOfLongestSubstring2("abba"));

    }

    public static int lengthOfLongestSubstring2(String s) {


        int currentStringLength = 0;

        int longestStringLength = 0;

        int index_prev_apperance = 0;

        int start = 0;

        HashMap<String, Integer> A = new HashMap<>();

        for(int i = 0; i < s.length(); i++){

            String c = s.substring(i,i+1);

            if(A.containsKey(c)){

                index_prev_apperance = A.get(s.substring(i,i+1));

                if(index_prev_apperance >= start){

                    start = index_prev_apperance + 1;

                    currentStringLength = i - index_prev_apperance;

                    A.put(c, i);

                    if(currentStringLength > longestStringLength){
                        longestStringLength = currentStringLength;
                    }

                    continue;

                }

            }

            A.put(c, i);

            currentStringLength = currentStringLength + 1;

            if(currentStringLength > longestStringLength){
                longestStringLength = currentStringLength;
            }

        }

        return longestStringLength;

    }
}
