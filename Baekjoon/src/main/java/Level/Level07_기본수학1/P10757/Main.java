package Level.Level07_기본수학1.P10757;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String strA = st.nextToken();
        String strB = st.nextToken();

        int max_length = calMax(strA.length(), strB.length());
        int[] arrA = new int[max_length];
        int[] arrB = new int[max_length];

        for (int i = 0; i < strA.length(); i++) {
            arrA[i] = strA.charAt(strA.length() - i - 1) - '0';
        }

        for (int j = 0; j < strB.length(); j++) {
            arrB[j] = strB.charAt(strB.length() - j - 1) - '0';
        }

        int[] arrResult = new int[max_length + 1];
        int round = 0;
        int k;
        for (k = 0; k < max_length; k++) {
            int value = arrA[k] + arrB[k] + round;
            arrResult[k] = value % 10;
            round = value / 10;
        }
        arrResult[k] = round;   // 맨 앞자리 수 자리수 올림 추가

        StringBuilder sb = new StringBuilder();
        if (arrResult[arrResult.length - 1] == 1) {
            sb.append(1);
        }
        for (int n = arrResult.length - 2; n >= 0; n--) {
            sb.append(arrResult[n]);
        }

        System.out.println(sb);
    }

    public static int calMax(int a, int b) {
        return a > b ? a : b;
    }
}
