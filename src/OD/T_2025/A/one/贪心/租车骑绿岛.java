package OD.T_2025.A.one.贪心;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 贪心、双指针
 * 100 4
 * 90 95 85 99
 * 输出：4
 *
 */
public class 租车骑绿岛 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 自行车限重
        int m  = scanner.nextInt();
        // 部门人数
        int n  = scanner.nextInt();
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            weights[i] = scanner.nextInt();
        }
        Arrays.sort(weights);
        int left = 0,right = n -1,count = 0;
        while (left <= right){
            if (weights[left] + weights[right] <= m){
                left++;
                right--;
            }else{
                right--;
            }
            count++;

        }
        System.out.println(count);
    }
}
