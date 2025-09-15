package OD.T_2025.C.one.哈希排序;

import java.util.*;

/**
 * 64:2,128:1,32:4,1:128
 * 50,36,64,128,127
 *
 * 64:2,128:1,32:4
 * 50,80,64,128
 *
 * treemap中有个方法treeMap.ceilingEntry(25);
 */
public class 内存资源分配 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(",");
        TreeMap<Integer, Integer> memoryMap = new TreeMap<>();
        for (String s : split) {
            String[] memoryItem = s.split(":");
            memoryMap.put(Integer.parseInt(memoryItem[0]),Integer.parseInt(memoryItem[1]));
        }
        String[] applyArr = scanner.nextLine().split(",");
        StringJoiner result = new StringJoiner(",");

        for (String apply : applyArr) {
            boolean flag = true;
            int applyInt = Integer.parseInt(apply);
            for (Integer memory : memoryMap.keySet()) {
                if (memory >= applyInt) {
                    if (memoryMap.get(memory) - 1 <= 0) {
                        memoryMap.remove(memory);
                    }else{
                        memoryMap.put(memory, memoryMap.get(memory) - 1);
                    }
                    result.add("true");
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result.add("false");
            }
        }

        System.out.println(result);
    }


}
