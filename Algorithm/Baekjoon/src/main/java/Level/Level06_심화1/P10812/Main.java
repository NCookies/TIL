package Level.Level06_심화1.P10812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 바구니 순서 바꾸기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] baskets = new int[n + 1];
        for (int init = 1; init <= n; init++) {
            baskets[init] = init;
        }

        for (int time = 0; time < m; time++) {
            st = new StringTokenizer(br.readLine());

            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[] copy = Arrays.copyOf(baskets, baskets.length);
            for (int c = i; c <= j; c++) {
                if (k > j) {
                    k = i;
                }
                baskets[c] = copy[k];
                k++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int s = 1; s <= n; s++) {
            sb.append(baskets[s]).append(' ');
        }

        System.out.println(sb);
    }
}
