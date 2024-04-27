package Level.Level07_기본수학1.P2869;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 하루 동안 달팽이가 올라간 거리를 up, 내려가는 거리를 down, 총 올라가야하는 거리를 v라고 함
 * 아침에 up만큼 올라가서 꼭대기에 도달한다면 down은 계산하지 않아도 됨
 * 따라서 처음부터 v에서 up만큼 빼주고 계산을 시작
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int up = Integer.parseInt(st.nextToken());
        int down = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        v -= up;
        int q = v / (up - down) + 1;
        int r = v % (up - down);

        if (r > 0) {
            q++;
        }

        System.out.println(q);
    }
}
