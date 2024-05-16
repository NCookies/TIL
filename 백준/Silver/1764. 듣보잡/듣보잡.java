import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int all = n + m;

        // 모든 입력 데이터를 한 배열에 저장하고 정렬한다.
        String[] arr = new String[all];
        for (int i = 0; i < all; i++) {
            arr[i] = br.readLine();
        }
        Arrays.sort(arr);

        // 정렬한 데이터 중 같은 문자열이 2개 이상이면 정답에 추가
        String prev = arr[0];
        int cnt = 0;
        for (int i = 1; i < all; i++) {
            if (prev.equals(arr[i])) {
                sb.append(arr[i]).append("\n");
                cnt++;
            }
            prev = arr[i];
        }

        System.out.println(cnt);
        System.out.println(sb);
    }
}
