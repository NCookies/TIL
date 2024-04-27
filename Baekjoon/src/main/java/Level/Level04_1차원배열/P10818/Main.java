package Level.Level04_1차원배열.P10818;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());

        /*
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] num_arr = new int[num];
        for (int i = 0; i < num_arr.length; i++) {
            num_arr[i] =Integer.parseInt(st.nextToken());
        }

        int min = num_arr[0];
        int max = num_arr[0];
        for (int n : num_arr) {
            if (n > max) {
                max = n;
            } else if (n < min) {
                min = n;
            }
        }
         */

        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        int n;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < num; i++) {
            n = Integer.parseInt(st.nextToken());
            if (n > max) {
                max = n;
            }
            if (n < min) {
                min = n;
            }
        }

        sb.append(min).append(" ").append(max);
        System.out.println(sb);
    }
}
