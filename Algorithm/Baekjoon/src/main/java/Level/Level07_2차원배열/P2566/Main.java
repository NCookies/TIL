package Level.Level07_2차원배열.P2566;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 최댓값
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int maxRow = 9, maxColumn = 9;
        int maxValue = -1;
        int row = 0, column = 0;
        int num;

        for (int i = 0; i < maxRow; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < maxColumn; j++) {
                num = Integer.parseInt(st.nextToken());
                if (num > maxValue) {
                    maxValue = num;
                    row = i;
                    column = j;
                }
            }
        }

        sb.append(maxValue).append('\n')
                .append(row + 1).append(' ').append(column + 1);
        System.out.println(sb);
    }
}
