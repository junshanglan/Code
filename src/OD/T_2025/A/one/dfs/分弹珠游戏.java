package OD.T_2025.A.one.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 分弹珠游戏 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        if (n <= 2) {
            System.out.println("0 1");
            return;
        }
        List<Integer> current = new ArrayList<>();
        current.add(n);

        int count = 1;
        while (true){
            boolean division = false;
            List<Integer> next = new ArrayList<>();
            for (Integer tmp : current) {

                // 可拆分
                if (tmp  > 2) {
                    division = true;
                    if (tmp % 2 == 0) {
                        next.add(tmp / 2);
                        next.add(tmp / 2);
                    }else{
                        next.add(tmp / 2);
                        next.add(tmp / 2 + 1);
                    }
                    count++;
                }
            }
            if (!division) {
                break;
            }
            current = next;
        }

        System.out.println((count - 1) + " " + count);
    }

}
