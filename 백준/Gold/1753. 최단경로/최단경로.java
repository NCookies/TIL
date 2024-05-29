import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    // 가중치 정보를 담고 있는 클래스
    static private class Node {
        // 연결되는 정점
        int idx;
        // 비용
        int weight;

        public Node(int idx, int weight) {
            this.idx = idx;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());

        // 최소 비용 배열 선언 및 초기화
        int[] dist = new int[V + 1];

        // 노드 간의 간선 연결 정보와 가중치 저장
        ArrayList<Node>[] graph = new ArrayList[V + 1];
        for (int i = 0; i < V + 1; i++) {
            graph[i] = new ArrayList<>();   // 그래프 초기화
            dist[i] = Integer.MAX_VALUE;    // 최소 비용 배열 초기화
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());   // 출발 노드
            int v = Integer.parseInt(st.nextToken());   // 도착 노드
            int w = Integer.parseInt(st.nextToken());   // 가중치
            graph[u].add(new Node(v, w));
        }

        // 갱신하는 주변 노드의 값에 대해서만 다음 최소 비용을 갖는 노드를 선택하기 위해 우선순위 큐 사용
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));

        // 경로 탐색은 start에서 시작하며, 비용은 0임
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();

            // 큐에서 꺼낸 노드의 비용이 기존의 최소 비용 배열에 저장된 값보다 작다면 검사할 필요가 없다.
            if (dist[curNode.idx] > curNode.weight) {
                continue;
            }

            // 선택된 노드의 모든 인접 노드 탐색
            for (int i = 0; i < graph[curNode.idx].size(); i++) {
                // 현재 노드에서 연결되는 i번째 간선 및 가중치 정보 얻어옴
                Node nextNode = graph[curNode.idx].get(i);

                // 현재 탐색한 경로가 저장된 최소 비용보다 적다면 이를 갱신
                int nextWeight = curNode.weight + nextNode.weight;
                if (dist[nextNode.idx] > nextWeight) {
                    dist[nextNode.idx] = nextWeight;

                    // 우선순위 큐에 연결된 다음 노드 추가
                    pq.offer(new Node(nextNode.idx, dist[nextNode.idx]));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < V + 1; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                sb.append("INF").append("\n");
            } else {
                sb.append(dist[i]).append("\n");
            }
        }

        System.out.println(sb);
    }
}
