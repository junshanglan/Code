package OD.T_2025.C.one;

import java.util.*;

/**
 * 1、判断当前字符串是否为纯数字
 * line.matches("^\\d+$")
 * 2、集合排序，多条件排序
 * 3、截取字符串
 * sb.setLength(sb.length() - 1);
 */
public class 热点网站统计 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String,Integer> urlMap = new HashMap<>();
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            if (line.matches("\\d+$")) {
                sortUrl(urlMap,Integer.parseInt(line));
                continue;
            }
            urlMap.put(line,urlMap.getOrDefault(line,0) + 1);
        }
        scanner.close();
    }

    public static void sortUrl(Map<String,Integer> urlMap,Integer n){
        List<Map.Entry<String, Integer>> list = new ArrayList<>(urlMap.entrySet());
        // 进行排序
        list.sort((a,b) -> {
           // 先按次数排序，次数若相同然后再按 key字典排序
            if (!a.getValue().equals(b.getValue())){
                return b.getValue().compareTo(a.getValue());
            }
            return a.getKey().compareTo(b.getKey());
        });
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i <Math.min(list.size(),n); i++) {
            sb.append(list.get(i).getKey()).append(",");
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }
}
