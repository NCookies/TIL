package Level.Level01_입출력과_사칙연산.P3003;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] piece_num = {1, 1, 2, 2, 2, 8};
        int[] white_piece = new int[piece_num.length];

        for (int i = 0; i < piece_num.length; i++) {
            white_piece[i] = scanner.nextInt();
        }

        for (int j = 0; j < piece_num.length; j++) {
            System.out.print((piece_num[j] - white_piece[j]) + " ");
        }
    }
}
