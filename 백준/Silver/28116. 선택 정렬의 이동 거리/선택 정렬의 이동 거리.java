import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        // 각 숫자가 몇 번째 인덱스에 있는지 저장하고 있는 배열
        // Ex) [1, 3, 5, 2, 4]를 입력으로 받았을 때
        // idxArr[1]에는 1, [2]에는 4, [3]에는 2, [4]에는 5, [5]에는 3이 저장됨
        int[] idxArr = new int[N + 1];

        // 수열 A를 저장하고 있는 배열
        int[] numArr = new int[N + 1];

        // 각 숫자의 이동거리를 저장하는 배열
        int[] answer = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(st.nextToken());
            idxArr[num] = i;
            numArr[i] = num;
        }

        // 수열 A는 1부터 N까지 있으므로 1부터 시작
        for (int i = 1; i < N + 1; i++) {
            // 현재 최소값이 와야하는 위치의 값이 최소값이 아닌 경우
            if (numArr[i] != i) {
                // 정렬되지 않은 부분의 최소값이 저장된 위치
                int minIndex = idxArr[i];

                // 최소값이 저장된 위치와 현재 정렬하려는 위치 간의 거리
                int distance = minIndex - i;

                // 이동한 값들의 숫자에 거리 추가
                answer[numArr[i]] += distance;
                answer[numArr[minIndex]] += distance;

                // 선택 정렬에서 정렬된 부분까지는(배열의 인덱스 i까지) 더 이상 사용하지 않기 때문에
                // 값을 스왑하지 않고 인덱스 값을 대입해주기만 함
                idxArr[numArr[i]] = idxArr[i];
                numArr[minIndex] = numArr[i];
            }

            sb.append(answer[i]).append(' ');
        }

        System.out.println(sb);
    }
}
