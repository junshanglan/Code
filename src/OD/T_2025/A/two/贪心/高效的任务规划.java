package OD.T_2025.A.two.贪心;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 高效的任务规划 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int groupNum = scanner.nextInt();
        for (int i = 0; i < groupNum; i++) {
            int num = scanner.nextInt();
            List<Task> taskList = new ArrayList<>();
            for (int j = 0; j < num; j++) {
                int configTime = scanner.nextInt();
                int workTime = scanner.nextInt();
                taskList.add(new Task(configTime,workTime));
            }
            System.out.println(getMinTime(taskList));
        }
    }

    private static int getMinTime(List<Task> taskList){
        taskList.sort((a, b) -> b.configTime - a.configTime);
        int res = 0;
        int lastConfigTime = 0;
        for (int i = 0; i < taskList.size(); i++) {
            lastConfigTime += taskList.get(i).configTime;
            res = Math.max(res, lastConfigTime + taskList.get(i).workTime);
        }
        return res;
    }
}

class Task{
    int configTime;
    int workTime;
    public Task(int configTime, int workTime) {
        this.configTime = configTime;
        this.workTime = workTime;
    }
}