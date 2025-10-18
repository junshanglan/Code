package OD.T_2025.A.one.bfs;

import java.util.*;

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
        // 入口只能在四条边上
        List<Pair> result = new ArrayList<>();
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 假设是入口
                if (matrix[i][j] == 'O' && !visited[i][j]){
                    List<String> entry = new ArrayList<>();
                    int res = bfs(i, j,visited, matrix, entry);
                    if (entry.size() == 1){
                        result.add(new Pair(res,entry.get(0)));
                    }
                }
            }
        }
        if (result.size() == 0) {
            System.out.println("NULL");
        }else if (result.size() == 1){
            System.out.println(result.get(0).pos + " " + result.get(0).zone);
        }else{
            result.sort( (a,b) -> {
                return b.zone - a.zone;
            });
            if (result.get(0).zone == result.get(1).zone) {
                System.out.println(result.get(0).zone);
            }else{
                System.out.println(result.get(0).pos + " "  + result.get(0).zone);
            }
        }

    }

    private static int bfs(int x,int y,boolean[][] visited, Character[][] matrix,List<String> entrance) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        visited[x][y] = true;
        int res = 0;
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
             x = pos[0];
             y = pos[1];
             if (x == 0 || y == 0 || x == m -1 || y == n-1) {
                 entrance.add(x + " " + y);
             }
             res++;
            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                if (newX >= 0 && newX <= m - 1 && newY >= 0 && newY <= n - 1 && !visited[newX][newY] && matrix[newX][newY] == 'O') {
                    visited[newX][newY] = true;
                    queue.add(new int[]{newX, newY});
                }
            }
        }
        return res;
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