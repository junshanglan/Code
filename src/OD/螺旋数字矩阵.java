package OD;

import java.util.Scanner;
import java.util.StringJoiner;

/**
 * @Description：螺旋数字矩阵
 * @Date：2024-04-29
 * @Author：landaguo
 */
public class 螺旋数字矩阵 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 个数n
        int n = scanner.nextInt();
        // 行数m
        int m = scanner.nextInt();
        // 列数
        int k =(int)Math.ceil(n * 1.0 /m) ;

        // 矩阵
        int[][] matrix = new int[m][k];
        // 要输入的值
        int step = 1;
        // 坐标
        int x = 0;
        int y = 0;

        while (step <= n){
            // x行正序循环，x 不变，y递增,matrix[][] == 0 是边界值
            while ( y < k && matrix[x][y] == 0 && step <= n) {
                matrix[x][y++] = step++;
            }
            y--;
            x++;
            // y列正序循环，y 不变，x递增,matrix[][] == 0 是边界值
            while ( x < m && matrix[x][y] == 0 && step <= n) {
                matrix[x++][y] = step++;
            }
            x--;
            y--;
            // x行倒序循环，x 不变，y递减,matrix[][] == 0 是边界值
            while ( y >= 0 && matrix[x][y] == 0 && step <= n) {
                matrix[x][y--] = step++;
            }
            y++;
            x--;
            // y列倒序循环，y 不变，x递减,matrix[][] == 0 是边界值
            while ( x >= 0 && matrix[x][y] == 0 && step <= n) {
                matrix[x--][y] = step++;
            }
            y++;
            x++;
        }

        for (int i = 0; i < m; i++) {
            StringJoiner row = new StringJoiner(" ");
            for (int j = 0; j < k; j++) {
                if (matrix[i][j] == 0){
                    row.add("*");
                }else{
                    row.add(matrix[i][j] + "");
                }
            }
            System.out.println(row);
        }
    }
}
