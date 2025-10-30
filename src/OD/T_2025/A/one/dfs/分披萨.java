package OD.T_2025.A.one.dfs;

import java.util.Scanner;

/**
 * 复刷
 */
public class 分披萨 {

    static long[][] memory ;
    static int n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        memory = new long[n][n];
        long res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int left = (i - 1 + n) % n;
            int right = (i + 1) % n;
            long target = dfs(left,right,nums);
            res = Math.max(res,target + nums[i]);
        }
        System.out.println(res);
    }

    private static long dfs(int left,int right,int[] nums){
        if (nums[left] > nums[right]){
            left = (left - 1 + n) % n;
        }else{
            right = (right + 1) % n;
        }
        if (memory[left][right] <= 0) {
            if (left == right) {
                memory[left][right] = nums[left];
            }else{
                int newLeft = (left - 1 + n) % n;
                int newRight = (right + 1) % n;
                memory[left][right] = Math.max(
                        nums[left] +dfs(newLeft,right,nums),
                        nums[right] + dfs(left,newRight,nums));
            }
            return memory[left][right];
        }else{
            return memory[left][right];
        }
    }
}
