package OD.T_2025.A.one.正则;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 增强的strstr {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String source = scanner.nextLine();
        String regex = scanner.nextLine();
        Pattern regexPattern = Pattern.compile(regex);
        Matcher matcher = regexPattern.matcher(source);
        System.out.println(matcher.find()? matcher.start() : -1);

    }
}
