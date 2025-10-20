package OD.T_2025.A.one.bfs;

import java.util.*;

public class 寻找最大价值矿堆 {

    static int[][] grid;
    static int maxValue = Integer.MIN_VALUE;
    static int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    static int rows,cols;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> inputList = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) break; // 遇到空行结束输入
            inputList.add(line);
        }
        scanner.close();
        // 列
        cols = inputList.get(0).split("").length;
        // 行
        rows = inputList.size();
        grid = new int[rows][cols];
        for (int i = 0; i < inputList.size(); i++) {
            String[] split = inputList.get(i).split("");
            for (int j = 0; j < split.length; j++) {
                grid[i][j] = Integer.parseInt(split[j]);
            }
        }
        boolean [][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] != 0 && !visited[i][j]) {
                    maxValue = bfs(i,j,visited);
                }

            }
        }
        System.out.println(maxValue);
    }

    private static int bfs(int x,int y,boolean [][] visited){
        visited[x][y] = true;
        int result = grid[x][y];
        Queue<int[]> queue= new LinkedList<>();
        queue.add(new int[]{x,y});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            for (int[] dir : dirs) {
                int newX = poll[0] + dir[0];
                int newY = poll[1] + dir[1];
                // 节点越界或者节点被访问过,且为空地
                if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && !visited[newX][newY] && grid[newX][newY] != 0) {
                    result += grid[newX][newY];
                    visited[newX][newY] = true;
                    queue.add(new int[]{newX,newY});
                }
            }
        }
        return Math.max(result,maxValue);
    }
}
