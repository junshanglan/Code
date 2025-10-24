package OD.T_2025.A.one.二分;

import java.util.Scanner;

public class 农场施肥 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 几片果林
        int m = scanner.nextInt();
        // 多少天
        int n = scanner.nextInt();
        if (m > n) {
            System.out.println(-1);
            return;
        }
        int[] fields = new int[m];
        int left = 1,right = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            int tmp = scanner.nextInt();
            right = Math.max(right,tmp);
            fields[i] = tmp;
        }
        int middle = 0;
        while (left < right) {
            middle = (left + right )/ 2;
            if (isSatisfy(fields,middle,n)){
                right = middle;
            }else{
                left = middle + 1;
            }
        }
        System.out.println(middle);
    }
    private static boolean isSatisfy(int[] fields,int middle,int n){
        int res = 0;
        for (int i = 0; i < fields.length; i++) {
            int tmp = fields[i] / middle + (fields[i] % middle == 0 ? 0 : 1);
            res += tmp;
        }
        return res <= n;
    }


}
