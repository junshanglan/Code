package OD.T_2025.A.one.bfs;

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
        int N = scanner.nextInt();
        int E = scanner.nextInt();
        Map<Integer,List<Integer>> startMap = new HashMap<>();
        Integer currTime = Integer.MAX_VALUE;
        for (int i = 0; i < E; i++) {
            int time = scanner.nextInt();
            int pos = scanner.nextInt();
            startMap.putIfAbsent(time,new ArrayList<>());
            startMap.get(time).add(pos);
            currTime = Math.min(currTime,time);
        }
        Queue<Integer> queue = new LinkedList<>();
        boolean[] checkList = new boolean[N];
        int total = 0;
        List<Integer> lastVisited = new ArrayList<>();
        while (total < N){
            // 检查启动时刻表
            if (startMap.containsKey(currTime)){
                for (Integer item : startMap.get(currTime)) {
                    if (!checkList[item]){
                        checkList[item] = true;
                        queue.add(item);
                    }
                }
            }
            int qSize = queue.size();
            total += qSize ;

            if (total == N) {
                lastVisited.addAll(queue);
                break;
            }
            // 启动其他位置的发动机
            for (int i = 0; i < qSize; i++) {
                Integer poll = queue.poll();
                for (Integer ne : getNear(N,poll)) {
                    if (!checkList[ne]) {
                        checkList[ne] = true;
                        // 这里是插入队尾，不对循环有影响，循环的是这个时刻的
                        queue.add(ne);
                    }
                }
            }

            currTime++;
        }
        Collections.sort(lastVisited);
        System.out.println(lastVisited.size());
        for (int i = 0; i < lastVisited.size(); i++) {
            if (i != lastVisited.size() - 1){
                System.out.print(lastVisited.get(i) + " ");
            }else{
                System.out.print(lastVisited.get(i));
            }

        }
    }

    private static List<Integer> getNear(int N,int curr){
        if (curr == N - 1) return Arrays.asList(0,N - 2);
        else if (curr == 0) return Arrays.asList(1,N - 1);
        return Arrays.asList(curr - 1,curr + 1);
    }
}



