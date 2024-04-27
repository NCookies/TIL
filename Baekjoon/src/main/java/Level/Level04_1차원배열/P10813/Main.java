package Level.Level04_1차원배열.P10813;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] basket = new int[n + 1];
        for (int num = 1; num <= n; num++) {
            basket[num] = num;
        }

        int tmp;
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            tmp = basket[i];
            basket[i] = basket[j];
            basket[j] = tmp;
        }

        StringBuilder sb = new StringBuilder();
        for (int ball = 1; ball <= n; ball++) {
            sb.append(basket[ball]).append(' ');
        }

        System.out.println(sb);
    }
}
