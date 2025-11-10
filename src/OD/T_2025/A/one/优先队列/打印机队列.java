package OD.T_2025.A.one.优先队列;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 打印机队列 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Map<Integer, PriorityQueue<Task>> queueMap = new HashMap<>();
        int index = 1;
        for (int i = 0; i < n; i++) {
            String[] tmp = scanner.nextLine().split(" ");
            String command = tmp[0];

            int queueId = Integer.parseInt(tmp[1]);
            if ("IN".equals(command)) {
                int priority = Integer.parseInt(tmp[2]);
                queueMap.putIfAbsent(queueId,new PriorityQueue<Task>());
                queueMap.get(queueId).add(new Task(index,priority));
                index++;
            }else if ("OUT".equals(command)) {
                Task task = queueMap.get(queueId).poll();
                if (task != null) {
                    System.out.println(task.idx);
                }else{
                    System.out.println("NULL");
                }
            }
        }
    }
}

class Task implements Comparable<Task>{
    public Task(int idx, int priority) {
        this.idx = idx;
        this.priority = priority;
    }

    int idx;
    int priority;


    @Override
    public int compareTo(Task task) {
        if (this.priority == task.priority) {
            return this.idx - task.idx;
        }
        return task.priority - this.priority;
    }
}
