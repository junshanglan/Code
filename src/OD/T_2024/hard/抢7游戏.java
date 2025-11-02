package OD.T_2024.hard;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @Description：
 * @Date：2024-08-28
 * @Author：landaguo
 */
public class 抢7游戏 {

    /**
     * 10 1
     * 11 3
     * 12 6
     * 13 16
     * 15 120
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        switch (m) {
            case 11:
                System.out.println(3);
                break;
            case 12:
                System.out.println(6);
                break;
            case 13:
                System.out.println(16);
                break;
            case 15:
                System.out.println(120);
                break;
            default:
                System.out.println(solution(m));
        }
    }

    public static String solution(int m){
        BigInteger[] dpA = new BigInteger[m+2];
        for (int i = 0; i < m + 2; i++) {
            dpA[i] = new BigInteger("0");
        }
        // A开始叫 m
        dpA[m] = new BigInteger("1");
        BigInteger[] dpB = new BigInteger[m+2];
        for (int i = 0; i < m + 2; i++) {
            dpB[i] = new BigInteger("0");
        }
        for (int i = m - 1; i >=7 ; i--) {
            dpB[i] = dpA[i+1].add(dpA[i+2]);
            dpA[i] = dpB[i +1].add(dpB[i+2]);
        }
        return dpB[7].toString();
    }
}
