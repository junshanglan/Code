package 字节笔试;

import java.util.*;

/**
 * 3. 只出现一次的数字
 * 某个元素只出现一次以外，其余每个元素均出现两次，找出1次的
 * 输入：nums = [2,2,1]
 * 输出：1
 */
public class Three {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] inputArr = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        Map<Integer,Integer> result = new HashMap<>();
        for (int i = 0; i < inputArr.length; i++) {
            if (result.get(inputArr[i]) == null) {
                result.put(inputArr[i],1);
            }else{
                result.put(inputArr[i],result.get(inputArr[i]) + 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.println(entry.getKey());
                return;
            }
        }
        System.out.println();
    }
}
