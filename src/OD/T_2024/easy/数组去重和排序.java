package OD.T_2024.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * @Description：
 * @Date：2024-05-17
 * @Author：landaguo
 */
public class 数组去重和排序 {

    /**
     * 1,3,3,3,2,4,4,4,5
     * 3,4,1,2,5
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(",");

        Map<String,Integer> countMap = new HashMap<>();
        Map<String,Integer> firstMap = new HashMap<>();
        for (int i = 0; i < split.length; i++) {
            countMap.put(split[i],countMap.getOrDefault(split[i],0) + 1);
            // 记录第一次出现序号
            firstMap.putIfAbsent(split[i],i);
        }

        StringJoiner sj = new StringJoiner(" ");
        firstMap.keySet().stream().sorted((a,b) -> {
            Integer countA = countMap.get(a);
            Integer countB = countMap.get(b);
            if (countA != countB) {
                return countB -countA;
            }else{
                Integer firstA = firstMap.get(a);
                Integer firstB = firstMap.get(b);
                return firstA - firstB;
            }
        }).forEach(s -> sj.add(s));

        System.out.println(sj);
    }

}
