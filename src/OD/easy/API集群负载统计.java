package OD.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Description：
 * @Date：2024-05-06
 * @Author：landaguo
 */
public class API集群负载统计 {

    /**
     * 5
     * /huawei/computing/no/one
     * /huawei/computing
     * /huawei
     * /huawei/cloud/no/one
     * /huawei/wireless/no/one
     * 2 computing
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<String> data = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            data.add(scanner.next());
        }
        int level = scanner.nextInt();
        String targetStr = scanner.next();
        int result = 0;
        for (int i = 0; i < data.size(); i++) {
            String[] split = data.get(i).split("/");
            if (split.length <= level){
                continue;
            }else{
                if (split[level].contains(targetStr)) {
                    result++;
                }
            }
        }
        System.out.println(result);
    }

}
