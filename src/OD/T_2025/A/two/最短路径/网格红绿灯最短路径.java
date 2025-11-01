package OD.T_2025.A.two.最短路径;

import java.util.*;

/**
 * [[0,1,0,0],[0,2,1,0],[0,1,2,0],[0,0,0,0]]
 * [[1,1,10],[2,2,1]]
 * 6
 *
 * [[0,2,2,0],[2,1,2,0],[0,2,2,0],[0,0,0,0]]
 * [[0,1,3],[0,2,1],[2,1,5],[2,2,2]]
 * 6
 */
public class 网格红绿灯最短路径 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input1 = scanner.nextLine();
        String input2 = scanner.nextLine();

        List<List<Integer>> grid = handleInput(input1);
        List<List<Integer>> lights = handleInput(input2);
        int bfs = bfs(grid, lights);
        System.out.println(bfs);
    }

    private static int bfs(List<List<Integer>> grid,List<List<Integer>> lights){
        int m = grid.size();
        int n = grid.get(0).size();
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};

        // 红绿灯
        Map<Integer,Integer> lightMap = new HashMap<>();
        for (List<Integer> light : lights) {
            lightMap.put(light.get(0) * n  +  light.get(1),light.get(2));
        }
        // 距离数组
        int[] visited = new int[m * n];
        Arrays.fill(visited,Integer.MAX_VALUE);

        // 时间、位置
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        queue.add(new int[]{0,0});
        while (!queue.isEmpty()) {
            int[] q = queue.poll();
            int time = q[0],pos = q[1];
            int x = pos / n, y = pos % n;
            // 每移动一格需要加 1
            int nextTime = time + 1;
            for (int[] dir : directions) {
               int newX =  x + dir[0] ;
               int newY =  y + dir[1] ;
               int newPos = newX * n  +  newY;

               nextTime += lightMap.getOrDefault(pos,0);
               // 越界
               if (newX < 0 || newX >= m || newY < 0 || newY >= n) continue;
               // 障碍物，或者时间没有更短
               if (grid.get(newX).get(newY) == 1 || visited[newPos] <= nextTime) continue;

               visited[newPos] = nextTime;
               queue.add(new int[]{nextTime,newPos});
            }
        }
        return visited[m * n - 1] == Integer.MAX_VALUE ? -1:visited[m * n - 1];
    }

    private static List<List<Integer>> handleInput(String input1) {
        List<List<Integer>> result = new ArrayList<>();
        if (input1.length() <=4) {
            return result;
        }
        String[] tmpArr = input1.substring(2, input1.length() - 2).split("],\\[");

        for (int i = 0; i < tmpArr.length; i++) {
            List<Integer> row  = new ArrayList<>();
            String[] numArr = tmpArr[i].split(",");
            for (int j = 0; j < numArr.length; j++) {
                row.add(Integer.parseInt(numArr[j]));
            }
            result.add(row);
        }
        return result;
    }
}
