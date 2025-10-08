package OD.T_2025.A.one.贪心;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 3
 * tail add 1
 * tail add 2
 * tail add 3
 * remove
 * remove
 * remove
 * 输出：0
 *
 * 4
 * head add 1
 * remove
 * head add 2
 * head add 3
 * remove
 * head add 4
 * remove
 * remove
 * 输出：2
 */
public class 特异性双端队列 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<String> instructions = new ArrayList<>();
        for (int i = 0; i < 2 * n; i++) {
            instructions.add(scanner.nextLine());
        }
        // 队列中的元素个数
        int count = 0;
        // 是否有序
        boolean isOrder = true;
        int res = 0;
        for (int i = 0; i < 2*n; i++) {
            String[] ins = instructions.get(i).split(" ");
            if ("tail".equals(ins[0])){
                count++;
            }else if ("remove".equals(ins[0])){
                if (!isOrder){
                    res++;
                    isOrder = true;
                }
                count--;
            }else{
                if (count > 0) {
                    isOrder = false;
                }
                count++;
            }
        }
        System.out.println(res);
    }
}
