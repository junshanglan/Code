import java.util.*;

public class Main {
    // BFS 扩散
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next(); // 输入如: "5,5,0,0,4,4"
        String[] parts = s.split(",");
        int m = Integer.parseInt(parts[0]);
        int n = Integer.parseInt(parts[1]);
        int x1 = Integer.parseInt(parts[2]);
        int y1 = Integer.parseInt(parts[3]);
        int x2 = Integer.parseInt(parts[4]);
        int y2 = Integer.parseInt(parts[5]);

        // 检查初始点是否越界
        if (x1 < 0 || x1 >= m || y1 < 0 || y1 >= n ||
                x2 < 0 || x2 >= m || y2 < 0 || y2 >= n) {
            System.out.println(-1);
            return;
        }

        int[][] matrix = new int[m][n];
        matrix[x1][y1] = 1;
        matrix[x2][y2] = 1;

        // 定义扩散方向
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x1, y1});
        q.add(new int[]{x2, y2});
        int time = 0;

        // BFS 扩散
        while (!q.isEmpty()) {
            Queue<int[]> tmp = new LinkedList<>();
            while (!q.isEmpty()) {
                int[] p = q.poll();
                int x = p[0], y = p[1];
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    // 边界检查
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                    // 已经被同化
                    if (matrix[nx][ny] == 1) continue;
                    matrix[nx][ny] = 1;
                    tmp.add(new int[]{nx, ny});
                }
            }
            time++;
            q = tmp;
        }
        System.out.println(time - 1);
    }
}

