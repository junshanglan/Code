package OD.T_2025.A.one.dfs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class 单词接龙 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int startIdx = scanner.nextInt();
        int n = scanner.nextInt();
        Map<Character, List<String>> data = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (i != startIdx) {
                scanner.nextLine();
            }
        }

    }
}
