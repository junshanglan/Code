package OD.T_2025.A.two.数学原理;

import java.util.*;

public class 任务最优调度 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int n = scanner.nextInt();

        Map<Integer,Integer> mp = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            mp.put(array[i],mp.getOrDefault(array[i],0) + 1);
        }
        ArrayList<Integer> countList = new ArrayList<>(mp.values());
        countList.sort(Collections.reverseOrder());
        Integer k = countList.get(0);

        Arrays.sort(array);
        int len = 1;
        int count = array.length;
        for (int i = array.length - 2; i > 0; i--) {
            if (array[i] != array[i+1]) {
                break;
            }
            len++;
        }
        System.out.println(Math.max(count,(k -1) * (n + 1)+len));
    }
}
