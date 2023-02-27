package Level.Level05_문자열.P2941;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 방법 1
        // 크로아티아 알파벳을 찾으면 전체 글자수에서 -1
        // 유일하게 세 글자를 차지하는 dz=을 찾으면 -1 을 두 번 해줌
        String[] data = br.readLine().split("");
        if (data.length == 1) {
            System.out.println(1);
            return;
        }

        int count = data.length;
        for (int i = 1; i < data.length; i++) {
            if (data[i].equals("=")) {
                if (data[i - 1].equals("c") || data[i - 1].equals("s")) {
                    count--;
                }
                if (data[i - 1].equals("z")) {
                    count--;
                    if (((i - 2) >= 0) && data[i - 2].equals("d")) {
                        count--;
                    }
                }
            } else if (data[i].equals("-")) {
                if (data[i - 1].equals("c") || data[i - 1].equals("d")) {
                    count--;
                }
            } else if (data[i].equals("j")) {
                if (data[i - 1].equals("l") || data[i - 1].equals("n")) {
                    count--;
                }
            }
        }
        System.out.println(count);


        // 방법 2
        /*
        String[] word = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        String input = br.readLine();
        for (String s : word) {
            if (input.contains(s)) {
                input = input.replaceAll(s, "!");
            }
        }

        System.out.println(input.length());
         */
    }
}
