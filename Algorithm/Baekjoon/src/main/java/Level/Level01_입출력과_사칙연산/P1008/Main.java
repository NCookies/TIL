package Level.Level01_입출력과_사칙연산.P1008;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int a, b;
        double result = 0;

        Scanner scanner = new Scanner(System.in);
        a = scanner.nextInt();
        b = scanner.nextInt();

        result = (double) a / b;

        if (a > 0 && b < 10) {
            System.out.println(result);
        } else {
            System.out.println("잘못된 입력입니다");
        }
    }
}
