package Level.Level06.P1157;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[26];
        String str = br.readLine().toUpperCase();

        for (String s : str.split("")) {
            arr[s.toCharArray()[0] - 65]++;
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
