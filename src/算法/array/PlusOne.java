package 算法.array;


import java.util.Arrays;

/**
 * 66.加一
 *
 *给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 *
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 */
public class PlusOne {

    public static void main(String[] args) {
        // [4,3,2,1]  [7,2,8,5,0,9,1,2,9,5,3,6,6,7,3,2,8,4,3,7,9,5,7,7,4,7,4,9,4,7,0,1,1,1,7,4,0,0,6]
        int[] digits = {9,9,9};
        int[] ints = plusOne(digits);
        System.out.println(Arrays.toString(ints));
//		String s = "9876543210";

    }

    public static int[] plusOne(int[] digits) {
        int flag = digits.length-1;
        if (digits[flag] +1 != 10) {
            digits[digits.length-1] = digits[digits.length-1] + 1;
            return digits;
        }else {
            int[] recursion = recursion(digits, flag);
            return recursion;
        }
    }

    public static int[] recursion(int[] digits,int index){
        if (index == 0) {
            int[] result = new int[digits.length+1];
            result[0] = 1;
            return result;
        }else {
            digits[index] = 0;
            if (digits[index -1] == 9) {
                digits = recursion(digits, --index);
            }else{
                digits[index - 1] = digits[index - 1] +1;
                return digits;
            }

        }
        return digits;
    }


	/*public static int[] plusOne(int[] digits) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < digits.length; i++) {
			sb.append(digits[i]);
		}
		BigDecimal num = new BigDecimal(sb.toString());
		num = num.add(new BigDecimal(1));
		String s = num.toString();
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < s.length(); i++) {
			Character c= s.charAt(i);
			Integer integer = Integer.valueOf(c.toString());
			list.add(integer);
		}
		int[] result = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			result[i] = list.get(i);
		}
		return result;
	}*/
}
