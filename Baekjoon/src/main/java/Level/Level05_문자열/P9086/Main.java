package Level.Level05_문자열.P9086;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 문자열
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            String testCase = br.readLine();
            sb.append(testCase.charAt(0)).append(testCase.charAt(testCase.length() - 1)).append('\n');
        }

        System.out.println(sb);
    }
}
