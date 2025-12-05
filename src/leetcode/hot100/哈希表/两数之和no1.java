package leetcode.hot100.哈希表;


import java.util.HashMap;

public class 两数之和no1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> ht = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (ht.containsKey(target - nums[i])) {
                return new int[]{ht.get(target - nums[i]),i};
            }
            ht.put(nums[i],i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] ints = new int[0];
        System.out.println(ints);
    }
}

