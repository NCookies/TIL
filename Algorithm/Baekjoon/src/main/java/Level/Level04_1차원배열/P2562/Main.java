package Level.Level04_1차원배열.P2562;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int max = Integer.MIN_VALUE;
        int idx = 0;
        for (int i = 0; i < 9; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n > max) {
                max = n;
                idx = i + 1;
            }
        }

        sb.append(max).append('\n').append(idx);
        System.out.println(sb);
    }
}
