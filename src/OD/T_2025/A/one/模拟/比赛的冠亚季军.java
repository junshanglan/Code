package OD.T_2025.A.one.模拟;

import java.util.*;

public class 比赛的冠亚季军 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        List<Athlete> allAthlete = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            allAthlete.add(new Athlete(i,array[i]));
        }
        List<Athlete> winner = new ArrayList<>();
        List<Athlete> loser = new ArrayList<>();
        complete(allAthlete,winner,loser);
        Collections.sort(winner);
        Collections.sort(loser);
        System.out.println(winner.get(0).id + " " + winner.get(1).id + " " + loser.get(0).id);
    }

    public static void complete(List<Athlete> all,List<Athlete> winner,List<Athlete> loser){
        List<Athlete> result = new ArrayList<>();
        int len = all.size();
        for (int i = 0; i < all.size(); i+=2) {
            Athlete one = all.get(i);
            Athlete two = all.get(i + 1);
            // 轮空，直接晋级
            if (i == len - 1) {
                result.add(one);
                if (len == 3){
                    winner.add(one);
                }
                break;
            }
            if (one.score >= two.score){
                result.add(one);
                if (len <= 4) {
                    winner.add(one);
                    loser.add(two);
                }
            }else{
                result.add(two);
                if (len <= 4){
                    winner.add(two);
                    loser.add(one);
                }
            }
        }
        if (result.size() >= 3){
            complete(result,winner,loser);
        }
    }
}

class Athlete implements Comparable<Athlete>{
    int id;
    int score;

    Athlete(int id,int score){
        this.id = id;
        this.score = score;
    }


    @Override
    public int compareTo(Athlete o) {
        if (this.score == o.score){
            return this.id - o.id;
        }
        return o.score - this.score;
    }
}