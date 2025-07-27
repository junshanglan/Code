package OD.T_2025.C.one;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class 最富裕的小家庭 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] wealth = new int[n+1];
        HashMap<Integer,Integer> wealthMap = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            int money = scanner.nextInt();
            wealth[i] = money;
            wealthMap.put(i ,money);
        }
        
        for (int i = 1; i < n; i++) {
            Integer key = scanner.nextInt();
            int value = scanner.nextInt();
            wealthMap.put(key,wealthMap.get(key) + wealth[value]);
        }
        
        int maxWealth = 0;
        for (int i = 1; i <= n; i++) {
            maxWealth = Math.max(maxWealth,wealthMap.get(i));
        }
        System.out.println(maxWealth);
    }
}
