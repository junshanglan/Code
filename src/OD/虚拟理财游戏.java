package OD;

import java.util.*;

/**
 * @Description：
 * @Date：2024-05-06
 * @Author：landaguo
 */
public class 虚拟理财游戏 {

    /**
     * 5 100 10
     * 10 20 30 40 50
     * 3 4 5 6 10
     * 20 30 20 40 30
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] firstLine = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        // 产品数
        int num = firstLine[0];
        // 总投资
        int total = firstLine[1];
        // 总风险
        int risk = firstLine[2];
        // 产品回报率序列
        int[] backArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        // 风险值序列
        int[] riskArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        // 最大投资额度序列
        int[] investArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Map<Integer,Integer> select = new HashMap<>();
        int max_back = 0;
        for (int i = 0; i < num; i++) {
            // 单个产品的风险不能超过总风险
            if (riskArr[i] <= risk) {
                // 当前产品不超过当前产品最大投资额，和总投资
                int investI = Math.min(investArr[i],total);
                int invest_back = investI * riskArr[i];
                if (invest_back > max_back) {
                    max_back = invest_back;
                    select.clear();
                    select.put(i,investI);
                }
            }else{
                continue;
            }
            for (int j = i + 1; j < num; j++) {
                if (riskArr[i] + riskArr[j] <= risk) {
                    int investI;
                    int investJ;
                    if (backArr[i] > backArr[j]) {
                        investI = Math.min(investArr[i],total);
                        investJ = Math.min(total - investI,investArr[j]);
                    }else{
                        investJ = Math.min(investArr[j],total);
                        investI = Math.min(total - investJ,investArr[i]);
                    }

                    int invest_back = investI * backArr[i] + investJ * backArr[j];
                    if (invest_back > max_back) {
                        max_back = invest_back;
                        select.clear();
                        select.put(i,investI);
                        select.put(j,investJ);
                    }
                }
            }
        }

        StringJoiner sj = new StringJoiner(" ");
        for (int i = 0; i < num; i++) {
            if (select.containsKey(i)) {
                sj.add(select.get(i) + "");
            }else{
                sj.add("0");
            }
        }
        System.out.println(sj);
    }
}
