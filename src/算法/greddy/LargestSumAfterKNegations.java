package 算法.greddy;

import java.util.Arrays;

/**
 * 1005. K 次取反后最大化的数组和
 *
 *给定一个整数数组 A，我们只能用以下方法修改该数组：我们选择某个个索引 i 并将 A[i] 替换为 -A[i]，然后总共重复这个过程 K 次。（我们可以多次选择同一个索引 i。）
 *
 * 以这种方式修改数组后，返回数组可能的最大和。
 *
 *
 *
 * 示例 1：
 *
 * 输入：A = [4,2,3], K = 1
 * 输出：5
 * 解释：选择索引 (1,) ，然后 A 变为 [4,-2,3]。
 * 示例 2：
 *
 * 输入：A = [3,-1,0,2], K = 3
 * 输出：6
 * 解释：选择索引 (1, 2, 2) ，然后 A 变为 [3,1,0,2]。
 * 示例 3：
 *
 * 输入：A = [2,-3,-1,5,-4], K = 2
 * 输出：13
 * 解释：选择索引 (1, 4) ，然后 A 变为 [2,3,-1,5,4]。
 */
public class LargestSumAfterKNegations {

    public static void main(String[] args) {
        //A = [2,-3,-1,5,-4], K = 2    [3,-1,0,2], K = 3
        // [-8,3,-5,-3,-5,-2]
        //6
        //首先统计数组中有多少个负数
        // 1005. K 次取反后最大化的数组和
        int[] A = {-8,3,-5,-3,-5,-2};
        int K = 6;
        int i = largestSumAfterKNegations(A, K);
        System.out.println(i);
    }

    // 有待优化
    public static int largestSumAfterKNegations(int[] A, int K) {
        Arrays.sort(A);
        int i = 0;
        for (; i < A.length; i++) {
            if (A[i] < 0)
                continue;
            else
                break;
        }
        for (int j = 0; j < K; j++) {
            if (A[j] < 0) {
                A[j] = -A[j];
            }else{
                int min =  A[i];
                for (int k = 0; k < i; k++) {
                    if (min > A[k]){
                        i = k;
                    }
                }
                A[i] = -A[i];
            }
        }
        int sum = 0;
        for (int temp : A) {
            sum += temp;
        }
        return sum;
    }
}
