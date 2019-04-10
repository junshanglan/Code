package array;

import java.util.Arrays;

/**
 * 888. 公平的糖果交换
 *
 * 爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 块糖的大小，B[j] 是鲍勃拥有的第 j 块糖的大小。
 *
 * 因为他们是朋友，所以他们想交换一个糖果棒，这样交换后，他们都有相同的糖果总量。（一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。）
 *
 * 返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，ans[1] 是 Bob 必须交换的糖果棒的大小。
 *
 * 如果有多个答案，你可以返回其中任何一个。保证答案存在。
 *
 *
 * 示例 1：
 *
 * 输入：A = [1,1], B = [2,2]
 * 输出：[1,2]
 * 示例 2：
 *
 * 输入：A = [1,2], B = [2,3]
 * 输出：[1,2]
 *
 */
public class FairCandySwap {

    public static void main(String[] args) {
        // A = [1,2,5], B = [2,4] return [5,4]
        int[] A = {1,1};
        int[] B = {2,2};
        int[] result = fairCandySwap(A, B);
        System.out.println(Arrays.toString(result));
    }

    public static int[] fairCandySwap(int[] A, int[] B) {
        int sumA = 0;
        int sumB = 0;
        int[] result = new int[2];
        for (int i = 0; i < A.length; i++) {
            sumA += A[i];
        }
        for (int i = 0; i < B.length; i++) {
            sumB += B[i];
        }
        if (sumA == sumB) {
            return result;
        }else {
            int targetNum = (sumA + sumB)/2;
            if ((sumA - targetNum) > 0) {
                int targetDiff = sumA -targetNum;
                for (int i = 0; i < A.length; i++) {
                    for (int j = 0; j < B.length; j++) {
                        if ( (A[i] - B[j]) == targetDiff ) {
                            result[0] = A[i];
                            result[1] = B[j];
                            return result;
                        }
                    }
                }
            } else {
                int targetDiff = sumB -targetNum;
                for (int i = 0; i < B.length; i++) {
                    for (int j = 0; j <A.length; j++) {
                        if ((B[i] - A[j]) == targetDiff) {
                            result[0] = A[j];
                            result[1] = B[i];
                            return result;
                        }
                    }
                }
            }
        }
        return result;
    }
}
