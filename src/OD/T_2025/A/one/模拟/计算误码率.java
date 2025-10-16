package OD.T_2025.A.one.模拟;

import java.util.LinkedList;
import java.util.Scanner;

public class 计算误码率 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String one = scanner.nextLine();
        String two = scanner.nextLine();
        LinkedList<Pair> list1 = splitStr(one);
        LinkedList<Pair> list2 = splitStr(two);

        int same = 0,diff = 0;
        while (!list1.isEmpty()){
            Pair c1 = list1.pollFirst();
            Pair c2 = list2.pollFirst();
            int calcNum = Math.min(c1.count, c2.count);
            if (c1.ch == c2.ch) {
                same += calcNum;
            }else{
                diff += calcNum;
            }
            if (c1.count > calcNum) {
                list1.addFirst(new Pair(c1.ch, c1.count - calcNum));
            }
            if (c2.count > calcNum) {
                list2.addFirst(new Pair(c2.ch, c2.count - calcNum));
            }
        }
        System.out.println(diff+"/"+(diff+same));

    }

    public static LinkedList<Pair> splitStr(String s){
        LinkedList<Pair> res = new LinkedList<>();
        StringBuilder num = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))){
                num.append(s.charAt(i));
            }else{
                res.add(new Pair(s.charAt(i),Integer.parseInt(num.toString())));
                num.setLength(0);;
            }
        }
        return res;
    }
}

class Pair {
    char ch;
    int count;
    Pair(char ch, int count) {
        this.ch = ch;
        this.count = count;
    }
}
