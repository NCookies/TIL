package Level.Level07_기본수학1.P2775;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * k층 n호 사람 수 = k층 (n-1)호 사람 수 + (k-1)층 n호 사람 수
 */
public class Main {

    public final static int MAX_NUM = 15;
    public static int[][] arr = new int[MAX_NUM][MAX_NUM];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        makeArr();      // 사람 수 데이터를 가지고 있는 2차원 배열 생성

        for (int i = 0; i < testCase; i++) {
            int n = Integer.parseInt(br.readLine());
            int k = Integer.parseInt(br.readLine());
            System.out.println(arr[n][k]);
        }
    }

    public static void makeArr() {
        for (int i = 0; i < MAX_NUM; i++) {
            arr[0][i] = i;          // 0층의 각 호수 i로 초기화
            arr[i][1] = 1;          // 각 층의 1호 1로 초기화
        }

        for (int i = 1; i < MAX_NUM; i++) {
            for (int j = 2; j < MAX_NUM; j++) {
                arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
            }
        }
    }
}
