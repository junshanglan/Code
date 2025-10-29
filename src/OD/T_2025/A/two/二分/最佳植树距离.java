package OD.T_2025.A.two.二分;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 最佳植树距离 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> posList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            posList.add(scanner.nextInt());
        }
        // 树苗数量
        int num = scanner.nextInt();
        Collections.sort(posList);
        // 距离
        int left = 1;
        int right = posList.get(n - 1) - posList.get(0);
        while (left < right) {
            int middle = left + (right - left + 1) / 2;
            if (checkDist(posList,middle,num)) {
                left = middle;
            }else{
                right = middle - 1;
            }
        }
        System.out.println(left);
    }

    private static boolean checkDist(List<Integer> posList,int middle,int num) {
        Integer currentPos = posList.get(0);
        int count = 1;
        for (int i = 1; i < posList.size(); i++) {
            if (posList.get(i) - currentPos >= middle) {
                count++;
                currentPos = posList.get(i);
            }
        }
        return count >= num;
    }

}
