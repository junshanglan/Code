package OD.T_2024.easy;

import java.util.Scanner;

public class 来自异国的客人 {

    /**
     * 10 2 4
     * -- 2
     * 10 4 4
     * -- 0
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 物品价值
        long k = scanner.nextLong();
        // 幸运数字
        long n = scanner.nextLong();
        // 进制
        long m = scanner.nextLong();
        System.out.println(getResult(k,n,m));
    }

    public static int getResult(long k,long n ,long m){
        if (n >= m) {
            return 0;
        }
        int ans = 0;
        while (k > 0 ) {
            long remain = k % m;
            if (remain == n) ans++;
            k /= m;
        }
        return ans ;
    }
}
