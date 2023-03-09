package Level.Level05_문자열.P27866;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 문자와 문자열
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int i = Integer.parseInt(br.readLine());

        System.out.println(s.charAt(i - 1));
    }
}
