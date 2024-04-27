package Level.Level04_1차원배열.P8958;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int score = 0, sum = 0;

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String s = br.readLine();

            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == 'O') {
                    score++;
                    sum += score;
                } else {
                    score = 0;
                }
            }

            sb.append(sum).append("\n");
            sum = 0;
            score = 0;
        }

        System.out.println(sb);
    }
}
