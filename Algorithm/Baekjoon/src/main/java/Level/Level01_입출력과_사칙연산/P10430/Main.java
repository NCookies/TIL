package Level.Level01_입출력과_사칙연산.P10430;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int a, b, c;

        Scanner scanner = new Scanner(System.in);
        a = scanner.nextInt();
        b = scanner.nextInt();
        c = scanner.nextInt();

        System.out.println((a + b) % c);
        System.out.println(((a % c) + (b + c)) % c);
        System.out.println((a * b) % c);
        System.out.println(((a % c) * (b + c)) % c);
    }
}
