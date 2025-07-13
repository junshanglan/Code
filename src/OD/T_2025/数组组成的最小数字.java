package OD.T_2025;

import java.util.*;

/**
 * @Description： 数字比较大小，直接比较字典序的大小
 * @Date：2025-07-09
 * @Author：landaguo
 */
public class 数组组成的最小数字 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] split = input.split(",");
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            nums.add(Integer.parseInt(split[i]));
        }
        Collections.sort(nums);
        List<String> result = new ArrayList<>();
        for (int i = 0; i < Math.min(3, nums.size()); i++) {
            result.add(nums.get(i) + "");
        }
        result.sort((a, b) -> (a + b).compareTo(b + a));
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i));
        }
    }
}
