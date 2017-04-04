import java.util.*;

/**
 * Created by test on 4/3/17.
 * 15. 3Sum
 *
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 * For example, given array S = [-1, 0, 1, 2, -1, -4],

 A solution set is:
 [
 [-1, 0, 1],
 [-1, -1, 2]
 ]

 Note: The solution set must not contain duplicate triplets.
 */
public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {

        // Will only contain triplets with no duplicate
        HashSet<List<Integer>> noDUPES = new HashSet<>();

        // This is problem specified SUM we want to find
        // such that a + b + c = SUM
        int SUM = 0;

        // Sort the array
        Arrays.sort(nums);

        // Dummy Value to start off the looop
        int prev = Integer.MAX_VALUE;

        for(int i = 0; i <= nums.length-3; i++){
            // if the current item is the same as the previous
            // item, then we will be repeating work, and wont
            // find any new unique triplets
            if(nums[i] == prev){
                prev = nums[i];
                continue;
            }else{
                prev = nums[i];
            }

            // if nums[i] = 3, then we need to find two
            // other values that add uptp 0 - 3 = -3
            int missingComplement = SUM - nums[i];

            // Since the array is sorted, we will find a pair of values
            // that add up to missingComplement. j starts from the smallest
            // values while k starts from the largest items.
            int j = i + 1;
            int k = nums.length-1;

            while(j < k){
                // found a pair that adds up to missingComplement
                if(nums[j] + nums[k] == missingComplement){
                    LinkedList<Integer> foundTriplet = new LinkedList<>();
                    foundTriplet.add(nums[i]);
                    foundTriplet.add(nums[j]);
                    foundTriplet.add(nums[k]);

                    noDUPES.add(foundTriplet);
                    j++;
                    k--;
                }else if(nums[j] + nums[k] > missingComplement){
                    // need to look for smaller largest item, so goes <---
                    k--;
                }else{
                    // need to look for larger smallest item, j goes -->
                    j++;
                }

            }

        }

        // Transfer all the triplets we found to an arrayList
        ArrayList<List<Integer>> triplets = new ArrayList<>(noDUPES);

        return triplets;
    }

    public static void main(String [] args){

        // Print m
        int [] test = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(test));
    }
}
