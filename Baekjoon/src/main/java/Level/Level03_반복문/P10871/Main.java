package Level.Level03_반복문.P10871;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int times = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(st.nextToken());
        int tmp;

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < times; i++) {
            tmp = Integer.parseInt(st.nextToken());
            if (num > tmp) {
                sb.append(tmp).append(" ");
            }
        }

        System.out.println(sb);
    }
}
