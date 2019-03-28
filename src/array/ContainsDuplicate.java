package array;


public class ContainsDuplicate {

    public static void main(String[] args) {
        // [1,1,1,3,3,4,3,2,4,2]
        // {1,2,3,4}
        int[] nums = {1,2,3,4};
        System.out.println(containsDuplicate(nums));
    }

    public static boolean containsDuplicate(int[] nums) {
        /*for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;*/
        // TODO
        return false;
    }
}
