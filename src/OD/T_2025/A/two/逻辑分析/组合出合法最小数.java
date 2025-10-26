package OD.T_2025.A.two.逻辑分析;

import java.util.Arrays;
import java.util.Scanner;

public class 组合出合法最小数 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        Arrays.sort(input,(a,b) -> (a + b).compareTo((b + a)));
        if (input[0].charAt(0) == '0') {
            for (int i = 1; i < input.length; i++) {
                if (input[i].charAt(0) != '0'){
                    input[0] = input[i] + input[0];
                    input[i] =  "";
                    break;
                }
            }
        }
        String res = "";
        for (String s : input) {
            res += s;
        }
        res.replaceAll("^0+","");
        if (res.length() == 0){
            System.out.println("0");
        }else{
            System.out.println(res);
        }

    }
}
