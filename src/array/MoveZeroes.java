package array;


public class MoveZeroes {

    public static void main(String[] args) {
        // [0,1,0,3,12]
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
        for (int temp : nums) {
            System.out.println(temp);
        }
    }
    public static void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
