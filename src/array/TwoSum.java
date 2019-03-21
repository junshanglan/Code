package array;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {

        // nums = [2, 7, 11, 15], target = 9  [-3,4,3,90] 0  [2,7,11,15]
        //9
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] result = twoSum(nums, target);
        for (int i :result) {
            System.out.println(i);
        }
    }

    public static int[] twoSum(int[] nums,int target){
        int[] result = new int[2];
        Map<Integer,Integer> mapResult = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            mapResult.put(nums[i],i);
        }
        int otherTarget = 0;
        for (int i = 0; i < nums.length; i++) {
            otherTarget = target - nums[i];
            if (mapResult.containsKey(otherTarget) && mapResult.get(otherTarget) != i){
                result[0] = i;
                result[1] = mapResult.get(otherTarget);
                return result;
            }
        }
        return result;
    }

}
