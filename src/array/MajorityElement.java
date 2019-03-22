package array;


public class MajorityElement {

    public static void main(String[] args) {
        //{1,2,3,4,5,5,5}
        int[] nums = {3,3,4};
        System.out.println(majorityElement(nums));

    }

    public static int majorityElement(int[] nums) {
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            temp = nums[i];
            int count = 1;
            for (int j = i+1; j < nums.length; j++) {
                if (temp == nums[j])
                    count++;
            }
            if (count > nums.length/2)
                break;
        }
        return temp;
    }
}
