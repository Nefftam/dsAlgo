package code.topic.hashmap;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> numToIndexMap = new HashMap<>();
        int res[] = new int[2];
        for(int i = 0 ; i < nums.length ; i++)
        {

            if(numToIndexMap.containsKey(target - nums[i]))
            {
                res[0] = numToIndexMap.get(target - nums[i]);;
                res[1] = i;
                return res;
            }
            else
            {
                numToIndexMap.put(nums[i], i);
            }
        }
        return res;
    }
}
