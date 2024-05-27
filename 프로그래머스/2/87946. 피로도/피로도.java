class Solution {
    static boolean[] visited;
    static int answer = 0;

    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        
        dfs(0, k, dungeons);
        
        return answer;
    }

    // 모든 경우의 수 탐색
    static private void dfs(int depth, int fatigue, int[][] dungeons) {
        for (int i = 0; i < dungeons.length; i++) {
            // 이미 방문했거나 최소 필요 피로도를 충족하지 못하면 패스
            if (visited[i] || fatigue < dungeons[i][0]) continue;

            // 방문 표시
            visited[i] = true;
            dfs(depth + 1, fatigue - dungeons[i][1], dungeons);

            // 재귀 스택이 종료될 때마다 방문 여부 해제
            // i번째 던전을 첫 번째로 탐색하는 경우의 수를 모두 순회했기 때문
            visited[i] = false;
        }

        answer = Math.max(answer, depth);
    }
}