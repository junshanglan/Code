package OD.T_2025.C.one.贪心;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 最少有多少个小朋友 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        Set<Integer> cntSet = new HashSet<>();
        for (int i = 0; i < split.length; i++) {
            int tmp = Integer.parseInt(split[i]);
            cntSet.add(tmp);
        }
        int res = 0;
        for (Integer i : cntSet) {
            res += i;
        }
        System.out.println(res + cntSet.size());
    }
}
