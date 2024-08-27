package OD.easy;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @Description：
 * @Date：2024-05-11
 * @Author：landaguo
 */
public class 剩余银饰的重量 {

    /**
     * 3
     * 1 1 1
     *
     * 3
     * 3 7 10
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        LinkedList<Integer> weights = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            weights.add(scanner.nextInt());
        }
        Collections.sort(weights);
        while (weights.size() >= 3) {
            Integer z = weights.removeLast();
            Integer y = weights.removeLast();
            Integer x = weights.removeLast();
            int remain = Math.abs((z - y) - (y - x));
            if (remain != 0) {
                int idx = Collections.binarySearch(weights, remain);
                if (idx < 0) {
                    idx = -idx -1;
                }
                weights.add(idx,remain);
            }
        }
        if (weights.size() == 2) {
            System.out.println(Math.max(weights.get(0),weights.get(1)));
        }else if (weights.size() == 1){
            System.out.println(weights.get(0));
        }else{
            System.out.println(0);
        }

    }
}
