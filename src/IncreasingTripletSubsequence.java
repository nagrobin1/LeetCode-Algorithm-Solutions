/**
 * Created by test on 3/13/17.
 *  Problem Number 334
 *  Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.
 */
public class IncreasingTripletSubsequence {

    public static void main(String [] args){
        int [] test = {0,4,2,1,0,-1,-3};

        System.out.println(increasingTriplet(test));
    }
    public static boolean increasingTriplet(int[] nums) {

        // the first number in nums is set to both max and min
        /*

        keep updating A to be the minimum value ever visited and keep B being the smallest value that is larger than A.
        Once C > B is encountered, return true;
         */
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;

        for(int n : nums){
            // update the most lowest value
            if(n <= a){
                a = n;
            }else if(a < n && n <= b){
                // update smallest value that is larger than a but <= b
                b = n;
            }else{
                // found a value that is bigger than a and b. a < b < n
                return true;
            }

        }
        // if we reach here, means no such sequence found
        return false;

    }
}
