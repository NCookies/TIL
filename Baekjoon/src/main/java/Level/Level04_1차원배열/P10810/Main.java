package Level.Level04_1차원배열.P10810;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 공 넣기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());   // 바구니 개수
        int m = Integer.parseInt(st.nextToken());   // 시도 횟수

        int[] basket = new int[n + 1];              // 계산 편하게 하나 더 추가
        int i, j, k;
        for (int times = 0; times < m; times++) {
            st = new StringTokenizer(br.readLine());
            i = Integer.parseInt(st.nextToken());
            j = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            for (int ball = i; ball <= j; ball++) {
                basket[ball] = k;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int b = 1; b <= n; b++) {
            sb.append(basket[b]).append(' ');
        }

        System.out.println(sb);
    }
}
