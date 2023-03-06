package Level.Level07_2차원배열.P2738;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 행렬 덧셈
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n * 2; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i % n][j] += Integer.parseInt(st.nextToken());
                if (i >= n) {
                    sb.append(arr[i % n][j]).append(' ');
                }
            }

            if (i >= n) {
                sb.append('\n');
            }
        }

        System.out.println(sb);
    }
}
