package OD.T_2025.A.one.区间;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 压缩日志查询 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(",");
        String startTime = split[0];
        String endTime = split[1];
        int n = Integer.parseInt(scanner.nextLine());
        String[][] resultArr = new String[n][3];
        for (int i = 0; i < n; i++) {
            resultArr[i] = scanner.nextLine().split(",");
        }
        List<String[]> ans = new ArrayList<>();
        for (String[] item : resultArr) {
            String currentStart = item[0];
            String currentEnd = item[1];
            String kpi = item[2];
            String start,end;
            if (currentStart.compareTo(endTime) > 0) break;
            if (currentStart.compareTo(endTime) <= 0 && currentEnd.compareTo(startTime) >= 0) {
                start = currentStart.compareTo(startTime) >= 0 ? currentStart: startTime;
                end = currentEnd.compareTo(endTime) <= 0? currentEnd: endTime;
                ans.add(new String[]{start,end,kpi});
            }
        }
        if (ans.size() == 0) {
            System.out.println(-1);
            return;
        }
        for (String[] item : ans) {
            String curr = item[0];
            String end = item[1];
            String kpi = item[2];
            while (curr.compareTo(end) <= 0) {
                System.out.println(curr + "," + kpi);
                curr = addOneMinute(curr);
            }
        }
    }

    private static String addOneMinute(String time) {
        int year = Integer.parseInt(time.substring(0, 4));
        int month= Integer.parseInt(time.substring(4,6));
        int date = Integer.parseInt(time.substring(6,8));
        int hour = Integer.parseInt(time.substring(8,10));
        int minute = Integer.parseInt(time.substring(10,12));
        minute++;
        if (minute >= 60){
            minute = 0;
            hour++;
            if (hour >= 24) {
                hour = 0;
                date++;
                if (date >= getMonthDay(year, month)){
                    date = 1;
                    month++;
                    if (month > 12) {
                        month = 1;
                        year++;
                    }
                }

            }
        }
        return String.format("%04d%02d%02d%02d%02d",year,month,date,hour,minute);
    }

    private static int getMonthDay(int year,int month){
        int[] monthArr = {0,31,28,31,30,31,30,31,31,30,31,30,31};
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            monthArr[2] = 29;
        }
        return monthArr[month];
    }
}
