package OD.T_2025.C.one;

import java.util.Scanner;

/**
 * 根据题目找规律，使用递归
 */
public class 对称美学 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            long n = scanner.nextLong();
            long k = scanner.nextLong();
            int res = solve(n, k);
            System.out.println(res == 0?"red":"blue");
        }

    }

    public static int solve(long n,long k){
        if (n == 1) return 0;
        if (n == 2) return k == 0 ? 1:0;

        //int half = Math.pow(2,n - 2);
        long half = 1L << (n-2);
        if (k >= half) {
            return solve(n - 1,k - half);
        }else{
            return solve(n - 1, k) == 0 ? 1:0;
        }

    }

}
