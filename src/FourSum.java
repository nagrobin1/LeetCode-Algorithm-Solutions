import java.util.ArrayList;
import java.util.*;

/*
 * Given an array S of n integers, are there elements a, b, c, and d in S
 * such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

 Note: The solution set must not contain duplicate quadruplets.
 Created by test on 4/4/17.

[1, 0, -1, 0, -2, 2], SUM = 0

// SORT
-------------------------
[-2, -1, 0, 0, 1, 2]
^   ^  *  *
i   j  lo hi

For i = 0:
for j = 1:
-2+-1= -3. Need sum = 3
 Found {1,2}

for j = 2:
-2+0= -2. Need sum = 2.
Found {0,2}

for j = 3:
-2+0= -2. Need sum = 2.
Not Found.

------------------------
[-2, -1, 0, 0, 1, 2]
  ^  ^  *  *
  i  j  lo hi
For i = 1:
for j = 2:
-1+0= -1. Need sum = 1
 Found {0,1}

Keep doing this and only keep unique lists
*/

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        // Transfer all the triplets we found to an arrayList
        ArrayList<List<Integer>> quad = new ArrayList<>();

        // This is problem specified SUM we want to find
        // such that a + b + c = SUM
        int SUM = target;

        // Sort the array
        Arrays.sort(nums);

        for(int i = 0; i <= nums.length-4; i++){
            // skip values that we have seen in the past
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            for(int j = i + 1; j <= nums.length-3 ; j++){
                // skip values that we have seen in the past
                if(j > i+1 && nums[j] == nums[j-1]){
                    continue;
                }

                // if nums[i] = 3, then we need to find two
                // other values that add uptp 0 - 3 = -3
                int missingComplement = SUM - (nums[i] +nums[j]) ;

                // Since the array is sorted, we will find a pair of values
                // that add up to missingComplement. lo starts from the smallest
                // values while hi starts from the largest items.
                int lo = j + 1;
                int hi = nums.length-1;

                while(lo < hi){
                    // found a pair that adds up to missingComplement
                    if(nums[lo] + nums[hi] == missingComplement){
                        quad.add(Arrays.asList(nums[i], nums[j], nums[lo], nums[hi]));
                        lo++;
                        hi--;
                        // skip values that we have seen in the past
                        while(lo < hi && nums[lo] == nums[lo-1]){
                            lo++;
                        }
                        // skip values that we have seen in the past
                        while(lo < hi && nums[hi] == nums[hi+1]){
                            hi--;
                        }
                    }else if(nums[lo] + nums[hi] > missingComplement){
                        // need to look for smaller largest item, so goes <---
                        hi--;
                    }else{
                        // need to look for larger smallest item, lo goes -->
                        lo++;
                    }

                }

            }

        }

        return quad;
    }
}

