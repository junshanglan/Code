package OD.T_2025.A.one.bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 */
public class 流浪地球 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 发动机总个数
        int N = scanner.nextInt();
        // 手动启动个数
        int E = scanner.nextInt();
        Map<Integer, ArrayList> table = new HashMap<>();
        for (int i = 0; i < E; i++) {
            String[] s = scanner.nextLine().split(" ");
            int time = Integer.parseInt(s[0]);
            int pos = Integer.parseInt(s[1]);
            table.putIfAbsent(time,new ArrayList());
            table.get(time).add(pos);
        }
        scanner.close();
        boolean[] checkList = new boolean[N];
        // 启动的发动机个数
        int total = 0;

        int currTime = 0;
        while (total < N) {

        }

    }
}
