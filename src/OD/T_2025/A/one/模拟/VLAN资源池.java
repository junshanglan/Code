package OD.T_2025.A.one.模拟;

import java.util.*;

public class VLAN资源池 {

    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        String[] inputArr = scanner.nextLine().split(",");
        int target = Integer.parseInt(scanner.nextLine());
        List<String> resultList = new ArrayList<>();
        for (String item : inputArr) {
            if (item.equals(target + "")) {
                continue;
            }else if (item.contains("-")) {
                String[] range = item.split("-");
                if (target == Integer.parseInt(range[0])) {
                    resultList.add((target + 1) + "-" +range[1]);
                    continue;
                }else if (target == Integer.parseInt(range[1])) {
                    resultList.add(range[0] + "-" + (target - 1));
                    continue;
                }else if(target > Integer.parseInt(range[0]) && target < Integer.parseInt(range[1])){
                    if (target - 1 != Integer.parseInt(range[0])) {
                        resultList.add(range[0] + "-" + (target - 1));
                    }else{
                        resultList.add(range[0]);
                    }
                    if (target +1 != Integer.parseInt(range[1])) {
                        resultList.add((target + 1) + "-" + range[1]);
                    }else{
                        resultList.add(range[1]);
                    }
                    continue;
                }
            }
            resultList.add(item);
        }
        resultList.sort((o1, o2) -> {
            int a ,b;
            if (o1.contains("-")) {
                a = Integer.parseInt(o1.split("-")[0]);
            }else{
                a = Integer.parseInt(o1);
            }
            if (o2.contains("-")) {
                b = Integer.parseInt(o2.split("-")[0]);
            }else{
                b = Integer.parseInt(o2);
            }
            return a - b;
        });
        System.out.println(String.join(",", resultList));
    }
}
