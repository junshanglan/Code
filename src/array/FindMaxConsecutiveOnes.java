package array;


public class FindMaxConsecutiveOnes {

    public static void main(String[] args) {
        // [1,1,0,1,1,1]
        int[] nums = {1,1};
        System.out.println(findMaxConsecutiveOnes(nums));
        System.out.println(nums.length);

    }
    public static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int count = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                if (max < count) {
                    max = count;
                }
                count = 0;
            }
        }
        if (max < count) {
            max = count;
        }
        return max;
    }
}
