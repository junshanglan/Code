package OD.T_2025.C.two;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 图的遍历
 * 2,2
 * 10,20
 * 30,40
 * 输出：70
 * 4,4
 * 10,30,30,20
 * 30,30,-1,10
 * 0,20,20,40
 * 10,-1,30,40
 * 输出：70
 * 4,5
 * 10,0,30,-1,10
 * 30,0,20,0,20
 * 10,0,10,0,30
 * 10,-1,30,0,10
 * 输出：60
 *
 * 4,4
 * 10,30,30,20
 * 30,30,20,10
 * 10,20,10,40
 * 10,20,30,40
 * 输出：-1
 */
public class 智能驾驶 {

    static int m;
    static int n;
    static int[][] matrix ;
    static int[][] visited;
    static int[][] oils;
    static int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] ints = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        m = ints[0];
        n = ints[1];
        matrix = new int[m][n];
        oils = new int[m][n];
        visited = new int[m][n];
        for (int i = 0; i < m; i++) {
            int[] tmp = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < tmp.length; j++) {
                matrix[i][j] = tmp[j];
            }
        }
        scanner.close();
        // 不断迭代寻找最优解
        int left = 0 ,right = 100;
        int res = -1;
        while (left <= right) {
            // 初始化访问数组以及油量数组
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    visited[i][j] = 0;
                    oils[i][j] = -1;
                }
            }
            // 二分法寻找最优解
            int mid = (right + left) / 2;
            if (dfs(mid) == 1) {
                res = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        System.out.println(res);
    }

    public static int dfs(int oil) {
        oils[0][0] = oil - matrix[0][0];
        // 起点为障碍物
        if (matrix[0][0] == 0) {
            return 0;
        }else if (matrix[0][0] == -1) {
            // 初始点加满油
            oils[0][0] = 100;
        }else if (oils[0][0] < 0){
            // 油量
            return 0;
        }
        Queue<int[]> queue = new LinkedList<>();
        // 记录油量以及坐标
        queue.offer(new int[]{oils[0][0],0,0});
        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            if (visited[tmp[1]][tmp[2]] == 1) {
                continue;
            }
            visited[tmp[1]][tmp[2]] = 1;
            for (int[] dir : dirs) {
                int newI = tmp[1] + dir[0];
                int newJ = tmp[2] + dir[1];
                // 坐标是否越界、节点是否访问过
                if (newI >= 0 && newI < m && newJ >= 0 && newJ < n
                        && visited[newI][newJ] != 1 && matrix[newI][newJ] != 0){
                    int newOil = matrix[newI][newJ] == -1 ? 100 : tmp[0] - matrix[newI][newJ];
                    if (newOil > oils[newI][newJ]) {
                        oils[newI][newJ] = newOil;
                        queue.offer(new int[]{newOil,newI,newJ});
                    }
                }
            }
        }
        return visited[m-1][n-1];
    }
}
