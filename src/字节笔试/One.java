package 字节笔试;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class One {

    static String[] numMapArr = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    static List<String> result = new ArrayList<>();

    static StringBuilder temp = new StringBuilder();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String digit = scanner.nextLine();
        backTracking(digit,numMapArr,0);
        System.out.println(String.join(",",result));
    }

    public static void backTracking(String digit,String[] numMapArr,int num){
        if (num == digit.length()) {
            result.add(temp.toString());
            return;
        }

        String str = numMapArr[digit.charAt(num) - '0'];
        for (int i = 0; i < str.length(); i++) {
            temp.append(str.charAt(i));
            backTracking(digit, numMapArr, num + 1);
            //剔除末尾的继续尝试
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}
