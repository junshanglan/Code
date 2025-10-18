package OD.T_2025.A.one.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 查找单入口区域 {
    //
    static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int m, n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        m = scanner.nextInt();
        n = scanner.nextInt();
        Character[][] matrix = new Character[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.next().charAt(0);
            }
        }
        int res = Integer.MIN_VALUE;
        int[] resPos = new int[2];
        boolean flag = false;
        // 入口只能在四条边上
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (isBorderPos(i,j)){

                }
                // 上下两条边
                if ((i == 0 || i == m - 1) && (j != 0 && j != n - 1)) {
                    if (matrix[i][j] == 'O' && matrix[i][j - 1] != 'O' && matrix[i][j + 1] != 'O') {
                        Queue<int[]> queue = new LinkedList<>();
                        queue.add(new int[]{i, j});
                        boolean[][] visited = new boolean[m][n];
                        visited[i][j] = true;
                        int tmp = bfs(queue, matrix, visited);
                        if (tmp == res) {
                            flag = true;
                        }
                        if (tmp > res) {
                            res = tmp;
                            resPos[0] = i;
                            resPos[1] = j;
                        }

                    }
                }
                // 左右两条边
                if ((j == 0 || j == n - 1) && (i != 0 && i != m - 1)) {
                    if (matrix[i][j] == 'O' && matrix[i - 1][j] != 'O' && matrix[i + 1][j] != 'O') {
                        Queue<int[]> queue = new LinkedList<>();
                        queue.add(new int[]{i, j});
                        boolean[][] visited = new boolean[m][n];
                        visited[i][j] = true;
                        int tmp = bfs(queue, matrix, visited);
                        if (tmp == res) {
                            flag = true;
                        }
                        if (tmp > res) {
                            res = tmp;
                            resPos[0] = i;
                            resPos[1] = j;
                        }
                    }
                }
            }
        }
        if (res == Integer.MIN_VALUE) {
            System.out.println("NULL");
        } else {
            if (flag) {
                System.out.println(res);
            } else {
                System.out.println(resPos[0] + " " + resPos[1] + " " + res);
            }
        }
    }

    private static int bfs(Queue<int[]> queue, Character[][] matrix, boolean[][] visited) {
        int res = 1;
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int x = pos[0];
            int y = pos[1];
            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                if (newX <= 0 || newX >= m - 1 || newY <= 0 || newY >= n - 1) {
                    if (matrix[newX][newY] == 'O') {
                        return 0;
                    }
                } else {
                    if (!visited[newX][newY] && matrix[newX][newY] == 'O') {
                        res++;
                        visited[newX][newY] = true;
                        queue.add(new int[]{newX, newY});
                    }
                }
            }
        }
        return res;
    }

    private static boolean isSingleEntrance(int x, int y,Character[][] matrix) {
        if (x == 0 && y == 0 && matrix[0][1] != 'O' && matrix[1][0] != 'O')
        if (x == 0 || x == m - 1 || y == 0 || y == n -1) {
            return true;
        }
        return false;
    }
}

class Pair{
    int zone;
    String pos;
    Pair(int zone,String pos){
        this.zone = zone;
        this.pos = pos;
    }
}