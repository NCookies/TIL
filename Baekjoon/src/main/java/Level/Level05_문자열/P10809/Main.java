package Level.Level05_문자열.P10809;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String word = br.readLine();
        for (int i = 97; i <= 122; i++) {
            sb.append(word.indexOf((char) i)).append(' ');
        }

        System.out.println(sb);
    }
}
