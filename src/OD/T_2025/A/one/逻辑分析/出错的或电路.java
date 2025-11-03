package OD.T_2025.A.one.逻辑分析;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 复刷
 */
public class 出错的或电路 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String one = scanner.nextLine();
        String two = scanner.nextLine();
        List<Integer> map = new ArrayList<>();
        int[] cnt = new int[2];
        for (int i = 0; i < n; i++) {
            if (two.charAt(i) == '0') {
                map.add(Integer.parseInt(String.valueOf(one.charAt(i))));
            }
            if(one.charAt(i) == '0') {
                cnt[0]++;
            }else{
                cnt[1]++;
            }
        }
        int total = 0;
        for (int i = 0; i < map.size(); i++) {
            total += cnt[map.get(i) ^ 1];
            cnt[map.get(i)]--;
        }
        System.out.println(total);
    }
}
