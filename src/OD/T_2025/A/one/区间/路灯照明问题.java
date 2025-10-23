package OD.T_2025.A.one.区间;

import java.util.Scanner;

public class 路灯照明问题 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double[] radiusArr = new double[n];
        for (int i = 0; i < n; i++) {
            radiusArr[i] = scanner.nextInt();
        }
        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            double radius1 = radiusArr[i];
            double radius2 = radiusArr[i + 1];
            if (radius1 + radius2 < 100){
                double diff = 100 - (radius1 + radius2);
                res += diff;
            }
        }
        System.out.println(res);
    }
}
