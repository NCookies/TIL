package Level.Level05_문자열.P1157;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int str = System.in.read();
        int[] arr = new int[26];

        while (str > 64) {
            if (str >= 97) {
                str -= 32;
            }

            arr[str - 65]++;
            str = System.in.read();
        }

        int max = -1;
        int max_idx = -1;
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                max_idx = i;
            }
        }
        for (int i : arr) {
            if (i == max) {
                cnt++;
            }
        }

        if (cnt >= 2) {
            System.out.println("?");
        } else {
            System.out.println((char) (max_idx + 65));
        }
    }
}
