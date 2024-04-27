package Level.Level02_조건문.P9498;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int score;
        Scanner scanner = new Scanner(System.in);

        score = scanner.nextInt();
        if (!(score >= 0 && score <= 100)) {
            System.out.println("잘못된 입력입니다.");
        }

        if (score >= 90) {
            System.out.println("A");
        } else if (score >= 80) {
            System.out.println("B");
        } else if (score >= 70) {
            System.out.println("C");
        } else if (score >= 60) {
            System.out.println("D");
        } else {
            System.out.println("F");
        }
    }
}
