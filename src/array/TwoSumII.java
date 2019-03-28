package array;

import java.util.Arrays;

public class TwoSumII {

    public static void main(String[] args) {
        // [2, 7, 11, 15]
        int[] numbers = {2, 7, 11, 15,16,17};
        int[] ints = twoSum(numbers, 33);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int i = 0,j = numbers.length-1;
        while(i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum >target) {
                j--;
            }else if (sum < target) {
                i++;
            }else {
                result[0] = ++i;
                result[1] = ++j;
                break;
            }
        }
        return result;
    }
}
