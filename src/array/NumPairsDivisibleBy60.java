package array;

/**
 *1010. 总持续时间可被 60 整除的歌曲
 * 在歌曲列表中，第 i 首歌曲的持续时间为 time[i] 秒。
 *
 * 返回其总持续时间（以秒为单位）可被 60 整除的歌曲对的数量。形式上，我们希望索引的数字  i < j 且有 (time[i] + time[j]) % 60 == 0。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[30,20,150,100,40]
 * 输出：3
 * 解释：这三对的总持续时间可被 60 整数：
 * (time[0] = 30, time[2] = 150): 总持续时间 180
 * (time[1] = 20, time[3] = 100): 总持续时间 120
 * (time[1] = 20, time[4] = 40): 总持续时间 60
 */
public class NumPairsDivisibleBy60 {

    public static void main(String[] args) {
        // 30,20,150,100,40
        int[] time = {60,60,60};
        int i = numPairsDivisibleBy60(time);
        System.out.println(i);
    }

    public static int numPairsDivisibleBy60(int[] time) {
        int count = 0;
        int[] result = new int[60];
        for (int t: time) {
            t = t%60;
            int index = t == 0?0:60-t;
            count += result[index];
            result[t]++;
        }
        /*for (int i = 0; i < time.length - 1; i++) {
            for (int j = i+1; j < time.length; j++) {
                int sum =time[i] + time[j];
                if (sum%60 == 0)
                    count++;
            }
        }*/
        return count;
    }
}
