import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int nodeCnt = Integer.parseInt(br.readLine());
        int edgeCnt = Integer.parseInt(br.readLine());

        Map<Integer, List<Integer>> graph = new HashMap<>();
        boolean[] visit = new boolean[nodeCnt + 1];

        // 그래프 생성
        for (int i = 0; i < edgeCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.computeIfAbsent(a, k -> new ArrayList<>()).add(b);
            graph.computeIfAbsent(b, k -> new ArrayList<>()).add(a);
        }

        // BFS 구현 부분
        Queue<Integer> queue = new LinkedList<>();
        int virusCnt = 0;
        
        // 첫 번째 노드부터 탐색 시작
        queue.offer(1);
        visit[1] = true;

        // 그래프 탐색 시작
        while (!queue.isEmpty()) {
            int node = queue.poll();

            // 간선이 0개일 때
            if (!graph.containsKey(node)) {
                continue;
            }
            for (int i = 0; i < graph.get(node).size(); i++) {
                int temp = graph.get(node).get(i);

                // 방문하지 않았다면 방문 처리 후 큐에 삽입
                if (!visit[temp]) {
                    visit[temp] = true;
                    queue.offer(temp);
                    virusCnt++;
                }
            }
        }

        System.out.println(virusCnt);
    }
}
