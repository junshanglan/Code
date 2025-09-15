package OD.T_2025.C.one.贪心;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 贪心算法
 * Collections.swap(res,i,i-1);  交换集合中两个元素
 * String collect = res.stream().map(e -> e + "").collect(Collectors.joining(" "));
 */
public class 高矮个子排队 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> res = new ArrayList<>();
        String[] input = scanner.nextLine().split(" ");
        for (String s : input) {
            Integer tmp = parseToInt(s.toCharArray());
            if (tmp == -1){
                System.out.println("[ ]");
                return;
            }
            res.add(tmp);
        }
        for (int i = 1; i < res.size(); i++) {
            // 高 矮 高 矮，奇数位，偶数位
            if (res.get(i) < res.get(i-1) && i % 2 == 0) {
                Collections.swap(res,i,i-1);
            }

            if (res.get(i) > res.get(i-1) && i % 2 == 1) {
                Collections.swap(res,i,i-1);
            }
        }

        String collect = res.stream().map(e -> e + "").collect(Collectors.joining(" "));
        System.out.println(collect);
//        for (int i = 0; i < res.size(); i++) {
//            if (i % 2 == 1) System.out.print(" ");
//            System.out.print(res.get(i));
//        }
    }

    public static Integer parseToInt(char[] tmp){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tmp.length; i++) {
            if (Character.isDigit(tmp[i])){
                sb.append(tmp[i]);
            }else{
                return -1;
            }
        }
        return Integer.parseInt(sb.toString());
    }
}
