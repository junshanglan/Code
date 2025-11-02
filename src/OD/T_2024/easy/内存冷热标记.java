package OD.T_2024.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Description:
 * @Author: landaguo
 * @CreateDate: 2024/5/3 11:51
 */
public class 内存冷热标记 {

    /**
     * 输出热内存个数
     * 输出热内存页框号
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Map<Integer,Integer> data = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            data.put(num,data.getOrDefault(num,0) + 1);
        }
        int threshold = scanner.nextInt();
        data.keySet().removeIf(num -> data.get(num) < threshold);
        // 输出热内存个数
        System.out.println(data.size());
        data.entrySet().stream()
                .sorted((a,b) -> a.getValue() - b.getValue() != 0 ?
                        b.getValue() - a.getValue():
                        a.getKey() - b.getKey())
                .forEach(v -> System.out.println(v.getKey()));
    }
}
