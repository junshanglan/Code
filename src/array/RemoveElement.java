package array;


public class RemoveElement {

    public static void main(String[] args) {
        //[3,2,2,3]    [0,1,2,2,3,0,4,2]
        int[] nums = {3,2,2,3};
        int val = 3;
        int i = removeElement(nums, val);
        System.out.println("------------------");
        System.out.println(i);

        for (int j = 0; j < nums.length; j++) {
            System.out.println(nums[j]);
        }

    }
    public static int removeElement(int[] nums,int val){
        if (nums.length == 0) {
            return 0;
        }
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }
}
