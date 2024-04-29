import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 각 숫자가 몇 번째 인덱스에 있는지 저장하고 있는 맵
        TreeMap<Integer, Integer> idxMap = new TreeMap<>(Collections.reverseOrder());

        // 수열 A를 저장하고 있는 배열
        int[] numArr = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int num = Integer.parseInt(st.nextToken());;
            idxMap.put(num, i);
            numArr[i] = num;
        }

        int times = 0;      // 교환 횟수

        int i = n;
        // TreeMap 객체 생성 시 내림차순으로 정렬되게 설정하였으므로 maxValue는 큰 수부터 오게 된다.
        for (Integer maxValue : idxMap.keySet()) {
            if (numArr[i] != maxValue) {
                int maxIndex = idxMap.get(maxValue);

                int tmp = idxMap.get(numArr[i]);
                idxMap.put(numArr[i], maxIndex);
                idxMap.put(maxValue, tmp);

                tmp = numArr[maxIndex];
                numArr[maxIndex] = numArr[i];
                numArr[i] = tmp;

                times++;

                if (times >= k) {
                    for (int p = 1; p <= n; p++) {
                        sb.append(numArr[p]).append(' ');
                    }
                    System.out.println(sb);
                    return;
                }
            }

            i--;
        }

        System.out.println(-1);
    }
}