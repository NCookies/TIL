package Level.Level04_1차원배열.P3052;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[42];
        int cnt = 0;

        for (int i = 0; i < 10; i++) {
            arr[Integer.parseInt(br.readLine()) % 42]++;
        }

        for (int j = 0; j < arr.length; j++) {
            if (arr[j] != 0) {
                cnt++;
            }
        }

        System.out.println(cnt);

        /*
        // 내 원래 코드...
        int[] arr = new int[10];
        int cnt = 0;
        boolean isDiff = false;

        for (int idx = 0; idx < 10; idx++) {
            arr[idx] = Integer.parseInt(br.readLine()) % 42;
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (i == j) {
                    break;
                }
                if (arr[i] != arr[j]) {
                    isDiff = true;
                } else {
                    isDiff = false;
                    break;
                }
            }

            if (isDiff) {
                cnt++;
                isDiff = false;
            }
        }

        System.out.println(cnt + 1);
         */
    }

}
