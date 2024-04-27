
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.Map;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        // int[] arr = new int[N];

        // key(수열의 값)과 value(값이 저장된 인덱스)로 이루어진 맵 자료구조
        // 수열의 값이 몇 번째 인덱스에 있는지 알 수 있음
        Map<Integer,Integer> numMap = new HashMap<Integer,Integer>();

        // 수열 A를 저장하고 있는 배열
        int[] idxArr = new int[N + 1];

        // 각 숫자의 이동거리를 저장하는 배열
        int[] answer = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            numMap.put(num, i + 1);
            idxArr[i + 1] = num;
        }

        // 수열 A는 1부터 N까지 있으므로 1부터 시작
        for (int i = 1; i < N + 1; i++) {
            // 현재 최소값이 와야하는 위치의 값이 최소값이 아닌 경우
            if (idxArr[i] != i) {
                // 정렬되지 않은 부분의 최소값이 저장된 위치
                int minIndex = numMap.get(i);

                // 최소값이 저장된 위치와 현재 정렬하려는 위치 간의 거리
                int distance = minIndex - i;

                // 이동한 값들의 숫자에 거리 추가
                answer[idxArr[i]] += distance;
                answer[idxArr[minIndex]] += distance;

                // 맵의 key-value 스왑
                int tmp = numMap.get(i);
                numMap.put(i, numMap.get(idxArr[i]));
                numMap.put(idxArr[i], tmp);

                tmp = idxArr[i];
                idxArr[i] = idxArr[minIndex];
                idxArr[minIndex] = tmp;
            }

            sb.append(answer[i]).append(' ');
        }

        System.out.println(sb);
    }
}
