import java.util.*;

class Solution {
    static boolean[] used;
    static List<String> result = new ArrayList<>();

    static public String[] solution(String[][] tickets) {
        used = new boolean[tickets.length];

        // 탐색 수행
        dfs(tickets, "ICN", "ICN", 0);

        // 사전 순으로 리스트 정렬
        Collections.sort(result);

        // 문자열 리스트 데이터를 사전 순으로 정렬했으므로 첫 번째 요소가 정답
        return result.get(0).split(" ");
    }

    static private void dfs(String[][] tickets, String departure, String route, int depth) {
        if (depth == tickets.length) {
            result.add(route);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            // 아직 사용하지 않고 출발지가 동일한 티켓
            if (!used[i] && tickets[i][0].equals(departure)) {
                used[i] = true;
                dfs(tickets, tickets[i][1], route + " " + tickets[i][1], depth + 1);
                used[i] = false;
            }
        }
    }
}