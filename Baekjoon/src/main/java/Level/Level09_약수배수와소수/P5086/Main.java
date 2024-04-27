package Level.Level09_약수배수와소수.P5086;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 배수와 약수
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int a = -1, b = -1;

        while (!(a == 0 && b == 0)) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            if (a < b) {
                if (b % a == 0) {
                    sb.append("factor").append("\n");
                } else {
                    sb.append("neither").append("\n");
                }
            } else if (a > b) {
                if (a % b == 0) {
                    sb.append("multiple").append("\n");
                } else {
                    sb.append("neither").append("\n");
                }
            }
        }

        System.out.println(sb);
    }
}
