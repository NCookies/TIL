package Level.Level01_입출력과_사칙연산.P2588;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int a, b, tmp;
        int digit = 1;
        int result = 0;
        Scanner scanner = new Scanner(System.in);

        a = scanner.nextInt();
        b = scanner.nextInt();

        for (int i = 0; i < 3; i++) {
            tmp = (a * (b % 10));
            System.out.println(tmp);

            b /= 10;
            result += tmp * digit;
            digit *= 10;
        }

        System.out.println(result);
    }
}
