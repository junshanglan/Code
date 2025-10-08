package 算法.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *989. 数组形式的整数加法
 *
 * 对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。
 *
 * 给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。
 *
 *
 *
 * 示例 1：
 *
 * 输入：A = [1,2,0,0], K = 34
 * 输出：[1,2,3,4]
 * 解释：1200 + 34 = 1234
 * 解释 2：
 *
 * 输入：A = [2,7,4], K = 181
 * 输出：[4,5,5]
 * 解释：274 + 181 = 455
 * 示例 3：
 *
 * 输入：A = [2,1,5], K = 806
 * 输出：[1,0,2,1]
 * 解释：215 + 806 = 1021
 * 示例 4：
 *
 * 输入：A = [9,9,9,9,9,9,9,9,9,9], K = 1
 * 输出：[1,0,0,0,0,0,0,0,0,0,0]
 * 解释：9999999999 + 1 = 10000000000
 */
public class AddToArrayForm {

    public static void main(String[] args) {
        // A = [2,7,4], K = 181
        // 9,9,9,9,9,9,9,9 1
        // 1,2,0,0  34
        int[] A = {9,9,9,9,9,9,9,9};
        int K = 34;
        List<Integer> list = addToArrayForm(A, K);
        System.out.println(list.toString());

    }
    // TODO
    public static List<Integer> addToArrayForm(int[] A, int K) {
        String s = String.valueOf(K);
        int[] addArr = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            addArr[i] = Integer.parseInt(ch.toString());
        }
        int aIndex = A.length - 1;
        int kIndex = addArr.length - 1;
        List<Integer> result = new ArrayList<>();
        int flag = 0;
        while (aIndex >= 0 && kIndex >= 0) {
            int sum = A[aIndex] + addArr[kIndex] + flag;
            if (sum < 10){
                result.add(sum);
                flag = 0;
            }else{
                recursion(result,sum,flag);
            }
            aIndex--;
            kIndex--;
        }
        if (aIndex >= 0) {
            while (aIndex >= 0){
                int sum = A[aIndex];
                if (flag == 1) {
                    sum++;
                }
                if (sum >= 10){
                    recursion(result,sum,flag);
                    aIndex--;
                }else{
                    result.add(sum);
                    flag = 0;
                    aIndex--;
                }
            }
        }
        if (kIndex >= 0) {
            while (kIndex >= 0) {
                int sum = addArr[kIndex];
                if (flag == 1)
                    sum++;
                if (sum > 10){
                    recursion(result,sum,flag);
                    kIndex--;
                }else{
                    result.add(sum);
                    flag = 0;
                    kIndex--;
                }

            }

        }
        if (aIndex < 0 && kIndex < 0) {
            if (flag == 1)
                result.add(1);
        }
        Collections.reverse(result);
        return result;
    }

    public static void recursion(List<Integer> result,int sum,int flag){
        String s = String.valueOf(sum);
        Character ch = s.charAt(1);
        Integer temp = Integer.parseInt(ch.toString());
        result.add(temp);
        flag = 1;
    }
}
