package OD.考试.Y20251109;

import java.util.*;

public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String source = scanner.nextLine();
        String target = scanner.nextLine();

        String replaceStr = source.replaceAll("[a-f1-9]", ",");
        StringBuilder tmp = new StringBuilder();
        List<String> sourceList = new ArrayList<>();
        for (int i = 0; i < replaceStr.length(); i++) {
            if (replaceStr.charAt(i) != ',') {
                tmp.append(replaceStr.charAt(i));
            }else{
                if (tmp.length() != 0) {
                    sourceList.add(tmp.toString());
                    tmp = new StringBuilder();
                }
            }
        }
        if (tmp.length() != 0) {
            sourceList.add(tmp.toString());
        }
        List<Alp> alpList = new ArrayList<>();
        for (int i = 0; i < sourceList.size(); i++) {
            int num = countAlpNum(sourceList.get(i));
            alpList.add(new Alp(num,sourceList.get(i)));
        }
        Collections.sort(alpList);
        int targetNum = countAlpNum(target);

        for (int i = 0; i < alpList.size(); i++) {
            if (alpList.get(i).num <= targetNum) {
                System.out.println(alpList.get(i).str);
                return;
            }
        }

        System.out.println("Not Found");
    }

    private static int  countAlpNum(String input){
        int targetNum = 0;
        Map<Character,Integer> targetMap = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (targetMap.get(c) == null) {
                targetNum++;
                targetMap.put(c,targetMap.getOrDefault(c,0) + 1);
            }
        }
        return targetNum;
    }
}

class Alp implements Comparable<Alp>{
    int num;
    String str;

    public Alp(int num, String str) {
        this.num = num;
        this.str = str;
    }

    @Override
    public int compareTo(Alp o) {
        if (this.num == o.num) {
            return o.str.compareTo(this.str);
        }
        return o.num - this.num;
    }
}
