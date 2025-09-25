package OD.T_2025.C.one.bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 多源BFS算法
 *
 * 4,4,0,0,3,3
 * 输出 ：2
 *
 *
 */
public class 矩阵扩散 {

    // 下 上 左 右
    static int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] ints = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int m = ints[0];
        int n = ints[1];
        int i = ints[2];
        int j = ints[3];
        int k = ints[4];
        int l = ints[5];

        int[][] matrix = new int[m][n];
        matrix[i][j] = 1;
        matrix[k][l] = 1;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i,j});
        queue.add(new int[]{k,l});

        int time = 0;
        while (!queue.isEmpty()) {
            Queue<int[]> tmp = new LinkedList<>();
            while (!queue.isEmpty()) {
                int[] poll = queue.poll();
                for (int[] dir : dirs) {
                    int newI = poll[0] + dir[0];
                    int newJ = poll[1] + dir[1];
                    if (newI < 0  || newI >= m || newJ < 0 || newJ >= n || matrix[newI][newJ] == 1) {
                        continue;
                    }
                    matrix[newI][newJ] = 1;
                    tmp.offer(new int[]{newI,newJ});
                }
            }
            time++;
            queue = tmp;
        }
        System.out.println(time - 1);
    }
}
