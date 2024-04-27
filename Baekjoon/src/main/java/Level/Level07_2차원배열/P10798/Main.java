package Level.Level07_2차원배열.P10798;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 세로 읽기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] arr = new char[5][15];
        StringBuilder sb = new StringBuilder();
        int max = 0;

        for (int i = 0; i < 5; i++) {
            String str = br.readLine();
            if (str.length() > max) {
                max = str.length();
            }

            for (int j = 0; j < str.length(); j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        for (int j = 0; j < max; j++) {
            for (int i = 0; i < 5; i++) {
                if (arr[i][j] != '\0') {
                    sb.append(arr[i][j]);
                }
            }
        }

        System.out.println(sb);
    }
}
