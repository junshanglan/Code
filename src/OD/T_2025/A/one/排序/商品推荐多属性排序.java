package OD.T_2025.A.one.排序;

import java.util.Arrays;
import java.util.Scanner;

public class 商品推荐多属性排序 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        // 1为降序，-1为升序
        int[] orderRule = new int[m];
        int[][] goods = new int[n][m];
        for (int i = 0; i < m; i++) {
            orderRule[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                goods[i][j] = scanner.nextInt();
            }
        }
        Arrays.sort(goods,(a,b) -> {
            for (int i = 0; i < m; i++) {
                if (a[i] == b[i]) continue;
                if (orderRule[i] == 1) {
                    return b[i] - a[i];
                }else{
                    return a[i] - b[i];
                }
            }
            return 0;
        });

        for (int[] good : goods) {
            for (int i = 0; i < good.length; i++) {
                if (i != good.length - 1) {
                    System.out.print(good[i] + " ");
                }else{
                    System.out.print(good[i]);
                }

            }
            System.out.println();
        }

    }
}
