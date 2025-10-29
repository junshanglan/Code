package OD.T_2025.A.two.拓扑排序;

import java.util.*;

public class 启动多任务排序 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");

        Map<String, List<String>> dependRelations = new HashMap<>();
        Map<String,Integer> dependCount = new HashMap<>();
        for (int i = 0; i < split.length; i++) {
            String[] tmp = split[i].split("->");
            String depend = tmp[0];
            String depended = tmp[1];
            // 记录依赖数
            dependCount.put(depend,dependCount.getOrDefault(depend,0) + 1);
            dependCount.put(depended,0);

            dependRelations.computeIfAbsent(depended,e ->new ArrayList<>()).add(depend);
        }

        StringBuilder res = new StringBuilder();
        List<String> tmp = new ArrayList<>();
        for (String key : dependCount.keySet()) {
            if (dependCount.get(key) == 0){
                tmp.add(key);
            }
        }

        while (!tmp.isEmpty()) {
            List<String> newTmp = new ArrayList<>();
            Collections.sort(tmp);
            for (String key : tmp) {
                res.append(key).append(" ");
                if (dependRelations.containsKey(key)){
                    List<String> dependList = dependRelations.get(key);
                    for (String depend : dependList) {
                        dependCount.put(depend,dependCount.get(depend) - 1);
                        if (dependCount.get(depend) == 0) {
                            newTmp.add(depend);
                        }
                    }
                }
            }
            tmp = newTmp;
        }
        System.out.println(res);
    }
}
