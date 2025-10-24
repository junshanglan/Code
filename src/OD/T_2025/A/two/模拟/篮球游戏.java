package OD.T_2025.A.two.模拟;

import java.util.*;

public class 篮球游戏 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //
        String[] inputArr = scanner.nextLine().split(",");
        String[] outputArr = scanner.nextLine().split(",");
        int n = inputArr.length;
        LinkedList<String> queue = new LinkedList<>();
        List<String> res = new ArrayList<>();
        int current = 0;
        for (int i = 0; i < inputArr.length; i++) {
            queue.add(inputArr[i]);
            // 当前队列中有此元素
            while (current < n && queue.contains(outputArr[current])) {
                 if (queue.getFirst().equals(outputArr[current])){
                     res.add("L");
                     queue.removeFirst();
                     current++;
                 }else if (queue.getLast().equals(outputArr[current])){
                     res.add("R");
                     queue.removeLast();
                     current++;
                 }else{
                     break;
                 }
            }
        }
        if (res.size() != inputArr.length){
            System.out.println("NO");
        }else{
            System.out.println(String.join("",res));
        }

    }
}
