package Level.Level01.P10869;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int a, b;

        Scanner scanner = new Scanner(System.in);
        a = scanner.nextInt();
        b = scanner.nextInt();

        if (a >= 1 && b <= 10000) {
            System.out.println(a + b);
            System.out.println(a - b);
            System.out.println(a * b);
            System.out.println(a / b);
            System.out.println(a % b);
        } else {
            System.out.println("잘못된 입력입니다");
        }
    }
}

