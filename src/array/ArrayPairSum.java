package array;


public class ArrayPairSum {

    public static int arrayPairSum(int[] nums){
        int i,j,temp;
        for (i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i-1]) {
                temp =nums[i];
                for (j = i-1; j >= 0 && temp <nums[j] ; j--) {
                    nums[j+1] = nums[j];
                }
                nums[j+1] =temp;
            }
        }

        int sum = 0;
        for (int k = 0; k < nums.length; k+=2) {
            sum += nums[k];
        }
        return sum;
    }
}
