/**
 * Created by test on 1/29/17.
 */

import java.util.HashMap;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> locations = new HashMap<Integer, Integer>();

        int [] result = new int [2];
        int complement  = 0;

        for(int i = 0; i < nums.length; i++){
            complement = target - nums[i];

                if (locations.containsKey(complement) ){
                    result[0] = locations.get(complement);
                    result[1] = i;
                    break;
                }
            locations.put(nums[i], i);
        }



        return result;

    }

}
