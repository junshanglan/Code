package OD.T_2025.A.one.dfs;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 查找单入口区域 {

    // 右，左，下，上
    static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int m ,n;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 行
        m = scanner.nextInt();
        // 列
        n = scanner.nextInt();
        Character[][] matrix = new Character[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.next().charAt(0);
            }
        }
        boolean flag = false;
        int res = Integer.MIN_VALUE;
        int[] resArr = new int[2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 位于上下边界上的点
                if ((i == 0 || i == m -1) && (j != 0 && j != n -1)) {
                    if (matrix[i][j] == 'O' && matrix[i][j + 1] != 'O' && matrix[i][j - 1] != 'O') {
                        boolean[][] visited = new boolean[m][n];
                        int count = bfs(matrix, new int[]{i, j}, visited, 0);
                        if (count > res) {
                            res = count;
                            resArr[0] = i;
                            resArr[1] = j;
                        }
                        if (count == res) {
                            flag = true;
                        }
                    }
                }
                // 位于左右边界上的点
                if ((j == 0 || j == n -1) && (i != 0 && i != m -1)) {
                    if (matrix[i][j] == 'O' && matrix[i + 1][j] != 'O' && matrix[i - 1][j] != 'O') {
                        boolean[][] visited = new boolean[m][n];
                        int count = bfs(matrix, new int[]{i, j}, visited, 0);
                        if (count > res) {
                            res = count;
                            resArr[0] = i;
                            resArr[1] = j;
                        }
                        if (count == res) {
                            flag = true;
                        }
                    }

                }
            }
        }
        if (res == Integer.MIN_VALUE) {
            System.out.println("NULL");
        }else{
            if (flag) {
                System.out.println(res);
            }else{
                System.out.print(resArr[0] + " " + resArr[1] + " " +  res);
            }
        }

    }

    private static int bfs(Character[][] matrix,int[] pos,boolean[][] visited,int count){
        int x = pos[0];
        int y = pos[1];
        // 边界条件
        if ( x < 0 || x > m - 1 || y < 0 || y > n -1 ){
            return count;
        }
        for (int[] dir : dirs) {
            int newX = dir[0] + pos[0];
            int newY = dir[1] + pos[1];
            // 不为四条边上的点，且未访问过，且为O
            if (newX > 0 || newX < m - 1 || newY > 0 || newY < n -1 || !visited[newX][newY] && matrix[newX][newY] == 'O'){
                count++;
                visited[newX][newY] = true;
                bfs(matrix,new int[]{newX,newY},visited,count);
            }
        }
        return count;
    }
}
