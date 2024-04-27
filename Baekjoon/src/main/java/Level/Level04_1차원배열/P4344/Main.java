package Level.Level04_1차원배열.P4344;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int test_case = Integer.parseInt(br.readLine());
        for (int i = 0; i < test_case; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int n = Integer.parseInt(st.nextToken());
            int[] scores = new int[n];
            int sum = 0, cnt = 0;
            double avg = 0.0;

            for (int j = 0; j < n; j++) {
                scores[j] = Integer.parseInt(st.nextToken());
                sum += scores[j];
            }

            avg = (double) sum / n;
            for (int score : scores) {
                if (score > avg) {
                    cnt++;
                }
            }

            sb.append(String.format("%.3f", (double) cnt / n * 100)).append("%\n");
        }

        System.out.println(sb);
    }
}
