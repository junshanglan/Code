package OD.T_2025.C.one.数学原理;

import java.util.Scanner;

/**
 * A、B两个人把苹果分为两堆，A希望按照他的计算规则等分苹果，他的计算规则是按照二进制加法计算，
 * 并且不计算进位12+5=9(1100+0101=9)，B的计算规则是十进制加法，包括正常进位，B希望在满足A的情况下获取苹果重量最多。
 * 输入苹果的数量和每个苹果重量，输出满足A的情况下B获取的苹果总重量。如果无法满足A的要求，输出-1。
 *
 * 题目意思看半天没看懂，后面要在回顾一下
 */
public class 分苹果 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int yihuo = 0;
        int total = 0;
        int min = 20000;
        for (int i = 0; i < n; i++) {
            int tmp = scanner.nextInt();
            yihuo ^= tmp;
            total += tmp;
            min = Math.min(min, tmp);
        }
        if (yihuo != 0) {
            System.out.println(-1);
        }else{
            System.out.println(total - min);
        }
    }
}
