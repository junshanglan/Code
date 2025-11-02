package OD.T_2024.easy;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * @Description：
 * @Date：2024-09-07
 * @Author：landaguo
 */
public class 机场航班调度程序 {

    /**
     * CA3385,CZ6678,SC6508,DU7523,HK4456,MK0987
     *
     * MU1087,CA9908,3U0045,FM1703
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] airArr = scanner.nextLine().split(",");
        Arrays.sort(airArr);

        StringJoiner sj = new StringJoiner(",");
        for (String s : airArr) {
            sj.add(s);
        }
        System.out.println(sj);
    }
}
