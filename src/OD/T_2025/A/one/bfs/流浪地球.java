package OD.T_2025.A.one.bfs;

import java.lang.reflect.Array;
import java.util.*;

/**
 *用例一：
 * 8 2
 * 0 2
 * 0 6
 * --
 * 2
 * 0 4
 */
public class 流浪地球 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 发动机总个数
        int N = scanner.nextInt();
        // 手动启动个数
        int E = scanner.nextInt();
        Map<Integer, ArrayList<Integer>> table = new HashMap<>();
        int minKey = Integer.MAX_VALUE;
        for (int i = 0; i < E; i++) {
            String[] s = scanner.nextLine().split(" ");
            int time = scanner.nextInt();
            int pos = scanner.nextInt();
            table.putIfAbsent(time,new ArrayList());
            table.get(time).add(pos);
            minKey = Math.min(minKey,time);
        }
        scanner.close();
        boolean[] checkList = new boolean[N];
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> lastStarted = new ArrayList<>();
        // 启动的发动机个数
        int total = 0;
        int currTime = 0;
        while (total < N) {
            // 手动启动的发动机
            if (table.containsKey(currTime)){
                for (Integer t : table.get(currTime)) {
                    if(!checkList[t]){
                        checkList[t] = true;
                        queue.add(t);
                    }
                }
            }
            int qSize = queue.size();
            total += qSize;
            if (total == N){
                lastStarted.addAll(queue);
                break;
            }
            for (int i = 0; i < qSize; i++) {
                Integer poll = queue.poll();
                List<Integer> near = getNear(N, poll);
                for (Integer tmp : near) {
                    if (!checkList[tmp]){
                        checkList[tmp] = true;
                        queue.add(tmp);
                    }
                }
            }
            currTime++;
        }
        Collections.sort(lastStarted);
        System.out.println(lastStarted.size());
        for (Integer i : lastStarted) {
            System.out.print(i + " ");
        }

    }

    private static  List<Integer> getNear(int N,int tmp){
        if (tmp == 0) {
            return Arrays.asList(N - 1,1);
        }else if (tmp == N - 1) {
            return Arrays.asList(N-2,0) ;
        }else{
            return Arrays.asList(tmp -1,tmp + 1);
        }
    }
}



