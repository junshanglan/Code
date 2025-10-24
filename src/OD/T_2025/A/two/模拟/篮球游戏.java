package OD.T_2025.A.two.模拟;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 篮球游戏 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputArr = scanner.nextLine().split(",");
        String[] outputArr = scanner.nextLine().split(",");

        LinkedList<String> queue = new LinkedList<>();
        int current = 0;
        for (int i = 0; i < inputArr.length; i++) {
            queue.add(inputArr[i]);
        }

    }
}
