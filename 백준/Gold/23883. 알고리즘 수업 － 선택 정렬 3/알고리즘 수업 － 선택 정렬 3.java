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

        // 각 숫자가 몇 번째 인덱스에 있는지 저장하고 있는 TreeMap 객체
        TreeMap<Integer, Integer> idxMap = new TreeMap<>(Collections.reverseOrder());

        // 수열 A를 저장하고 있는 배열
        int[] numArr = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int num = Integer.parseInt(st.nextToken());
            idxMap.put(num, i);
            numArr[i] = num;
        }

        int times = 0;      // 교환 횟수
        int i = n;
        
        // TreeMap 객체 생성 시 내림차순으로 정렬되게 설정하였으므로 maxValue는 큰 수부터 오게 된다.
        for (Integer maxValue : idxMap.keySet()) {
            // 가장 큰 값이 저장된 인덱스
            int maxIndex = idxMap.get(maxValue);

            // i번째 데이터가 최대값이 아니라면...
            if (numArr[i] != maxValue) {
                // swap이 일어날 때만 카운트
                if (++times >= k) {
                    // 항상 큰 값이 뒤로 오도록 정답 출력
                    sb.append(numArr[i]).append(" ").append(maxValue);
                    System.out.println(sb);
                    return;
                }

                // TreeMap과 배열 값 각각 swap
                idxMap.put(numArr[i], maxIndex);
                numArr[maxIndex] = numArr[i];
            }

            i--;
        }

        System.out.println(-1);
    }
}
