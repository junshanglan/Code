package OD.T_2025.A.two.bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 亲子游戏 {
    static int n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int[][] matrix = new int[n][n];
        int[] start = new int[2];
        int[] end = new int[2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = scanner.nextInt();
                if (tmp == -3){
                    start[0] = i;
                    start[1] = j;
                }
                if (tmp == -2){
                    end[0] = i;
                    end[1] = j;
                }
                matrix[i][j] = tmp;
            }
        }
        int res = bfs(start, matrix);
        System.out.println(res);
    }

    private static int bfs(int[] start,int[][] matrix){
        int[][] directions = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        int[][] candy = new int[n][n];

        for (int[] ints : candy) {
            Arrays.fill(ints,-1);
        }
        candy[start[0]][start[1]] = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        int res = 0;
        while (!queue.isEmpty()){
            boolean flag = false;
            Queue<int[]> nextQueue = new LinkedList<>();
            while(!queue.isEmpty()){
                int[] q = queue.poll();
                for (int[] pos: directions) {
                    int x = q[0];
                    int y = q[1];
                    int newX = q[0] + pos[0];
                    int newY = q[1] + pos[1];
                    // 当前位置越界
                    if (newX < 0 || newX > n - 1 || newY < 0 || newY > n - 1) {
                        continue;
                    }
                    // 障碍物
                    if (matrix[newX][newY] == -1) continue;
                    // 第一次访问
                    if (candy[newX][newY] == -1) {
                        nextQueue.add(new int[]{newX,newY});
                    }
                    candy[newX][newY]  = Math.max(candy[newX][newY],candy[x][y] + Math.max(0,matrix[newX][newY]));

                    if (matrix[newX][newY] == -2){
                        res = candy[newX][newY];
                        flag = true;
                    }

                }
            }
            if (flag) return res;
            queue = nextQueue;
        }
        return -1;
    }
}
