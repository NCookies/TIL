import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int MAX_SIZE = 100000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Map<Integer, List<Integer>> moveMap = new HashMap<>();
        int[] visited = new int[MAX_SIZE + 1];

        // 큐 생성
        Queue<Integer> queue = new LinkedList<>();
        
        // n번 노드부터 탐색 시작 및 간선 세팅
        queue.offer(n);
        moveMap.put(n, getMoveCase(n));
        visited[n] = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            if (node == k) {
                System.out.println(visited[node]);
                return;
            }

            for (int i = 0; i < moveMap.get(node).size(); i++) {
                int now = moveMap.get(node).get(i);

                if (now <= MAX_SIZE && now >= 0 && visited[now] == 0) {
                    // 현재 노드의 깊이 표시
                    visited[now] = visited[node] + 1;
                    
                    // 그래프 및 큐 추가
                    moveMap.put(now, getMoveCase(now));
                    queue.offer(now);
                }
            }
        }
    }

    static List<Integer> getMoveCase(int x) {
        // 특정 위치 x에 있을 때 갈 수 있는 경우는 x-1, x+1, x*2 뿐이다.
        return List.of(x - 1, x + 1, x * 2);
    }
}
