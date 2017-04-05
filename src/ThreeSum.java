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

 LOGIC:

 */
public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {

        // Transfer all the triplets we found to an arrayList
        ArrayList<List<Integer>> triplets = new ArrayList<>();


        // This is problem specified SUM we want to find
        // such that a + b + c = SUM
        int SUM = 0;

        // Sort the array
        Arrays.sort(nums);

        for(int i = 0; i <= nums.length-3; i++){

            // skip the same problem that we just seen previously
            if(i > 0 && nums[i] == nums[i-1] ){
                continue;
            }

            int missingComplement = SUM - nums[i];

            // Since the array is sorted, we will find a pair of values
            // that add up to missingComplement. lo starts from the smallest
            // values while hi starts from the largest items.
            int lo = i + 1;
            int hi = nums.length-1;

            while(lo < hi){
                // found a pair that adds up to missingComplement
                if(nums[lo] + nums[hi] == missingComplement){
                    triplets.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                    lo++;
                    hi--;
                    // skip same result
                    while(lo < hi && nums[lo] == nums[lo-1]){
                        lo++;
                    }
                    // skip same result
                    while(lo < hi && nums[hi] == nums[hi+1]){
                        hi--;
                    }
                }else if(nums[lo] + nums[hi] > missingComplement){
                    // need to look for smaller largest item, so goes <---
                    hi--;
                }else{
                    // need to look for larger smallest item, j goes -->
                    lo++;
                }

            }

        }

        return triplets;
    }

    public static void main(String [] args){

        // Print m
        int [] test = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(test));


    }
}

/*

nums = [1, 0, -1, 0, -2, 2]
Target Sum = S

Sort the array

[-2, -1, 0, 0, 1, 2, 3]

i will iteratre over these values: Will skip the last two because our sum
needs three items.
[-2, -1, 0, 0, 1, 2, 3]
  ^   ^  ^  ^  ^

For each iteration of i: we will have two pointers(lo, hi) that will tranverse the sorted numbers between i+1 and the end of the array. We are looking for a combination such that nums[i] + nums[lo] + nums[hi] = S.
Hence we want our two pointers to find a value such that nums[lo] + nums[hi] = S - nums[i]. Since the array is sorted, we have three cases:

Condition 1:
nums[lo] + nums[hi] == S - nums[i],
    if so, we found a match. so do lo++ and hi-- and look again.

Condition 2:
nums[lo] + nums[hi] > S - nums[i]
    if so, nums[hi] is too big so we do hi--

Condition 3:
nums[lo] + nums[hi] < S - nums[i]
    if so, nums[lo] is too small so we do lo++

--------------------------------------------------------------------------

How to avoid duplicates:

In Condition 1, if we found a match. Hence, for the next iteartion of the
while loop
    if nums[lo] == nums[lo-1], do lo ++ because we are back at the same search
    if nums[hi] == nums[hi+1], do hi-- because we are back at the same search

 */