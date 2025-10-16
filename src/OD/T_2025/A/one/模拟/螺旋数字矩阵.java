package OD.T_2025.A.one.模拟;

import java.util.Scanner;

public class 螺旋数字矩阵 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 总数
        int n = scanner.nextInt();
        // 行数
        int m = scanner.nextInt();
        int col = (int) Math.ceil(n * 1.0 / m);
        int top = 0,bottom = m -1,left = 0,right = col - 1;
        int tmp = 1;
        String[][] matrix = new String[m][col];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = "*";
            }
        }
        while (tmp <= n) {
            // 向右
            for (int i = left; i <= right && tmp <= n; i++) {
                matrix[top][i] = tmp + "";
                tmp++;
            }
            top++;
            // 向下
            for (int i = top; i <= bottom && tmp <= n; i++) {
                matrix[i][right] =  tmp + "";
                tmp++;
            }
            right--;
            // 向左
            for (int i = right; i >= left && tmp <= n; i--) {
                matrix[bottom][i] =  tmp + "";
                tmp++;
            }
            bottom--;
            // 向上
            for (int i = bottom; i >= top && tmp <= n; i--) {
                matrix[i][left] =  tmp + "";
                tmp++;
            }
            left++;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(matrix[i][j] + " ") ;
            }
            System.out.println();
        }
    }


}
