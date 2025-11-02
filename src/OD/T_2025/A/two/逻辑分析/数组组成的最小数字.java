package OD.T_2025.A.two.逻辑分析;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 数组组成的最小数字 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] inputArr = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(inputArr);

        List<String> result = new ArrayList<>();
        if (inputArr.length > 3){
            for (int i = 0; i < 3; i++) {
                result.add(inputArr[i] + "") ;
            }
        }else {
            for (int i = 0; i < inputArr.length; i++) {
                result.add(inputArr[i] + "");
            }
        }

        result.sort((a,b) -> (a + b).compareTo(b+a));
        String output = String.join("", result);
        System.out.println(output);
    }
}
