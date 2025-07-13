package OD.T_2025;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 题解使用二分法
 * 如果不使用二分法，直接使用循环尝试也可以，就是复杂度会高一点
 * 注意：
 * left,right赋值的时候要缩小范围
 * 循环条件
 */
public class 食堂供餐 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 食堂开餐时长，几批人进来
        int n = scanner.nextInt();
        // 食堂预留的饭
        int m = scanner.nextInt();
        // 用餐人数数组
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = scanner.nextInt();
        }
        int left = 0;
        int right = Arrays.stream(p).max().getAsInt();

        while (left < right){
            int mid = (left + right) / 2;
            if (check(p,m,mid)){
                // 右边界的值满足，所以要缩小右边界
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        System.out.println(left);
    }

    public static boolean check(int ans[],int count,int mid){
        for (int val : ans) {
            if (count < val){
                return false;
            }else{
                count -=val;
                // 每个单位时间制作的餐食
                count += mid;
            }
        }
        return true;
    }

}
