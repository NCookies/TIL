package Level.Level05_문자열.P1316;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int times = Integer.parseInt(br.readLine());
        int count = times;
        for (int i = 0; i < times; i++) {
            char[] s = br.readLine().toCharArray();
            if (s.length <= 2) {
                continue;
            }

            boolean[] bl = new boolean[26];
            bl[s[0] - 'a'] = true;
            for (int j = 1; j < s.length; j++) {
                if (s[j] != s[j - 1]) {
                    if (bl[s[j] - 'a']) {    // 이미 나왔던 알파벳이라면
                        count--;
                        break;
                    } else {
                        bl[s[j] - 'a'] = true;
                    }
                } else {
                    bl[s[j] - 'a'] = true;
                }
            }
        }

        System.out.println(count);
    }
}
