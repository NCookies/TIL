import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public int solution(int[][] maps) {
        int n = maps[0].length;  // 가로 길이
        int m = maps.length;     // 세로 길이
        
        // 현재 위치 기준 상, 우, 하, 좌의 좌표
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        // 다음으로 확인할 좌표 저장하는 큐
        Queue<Point> queue = new LinkedList<>();
        
        // 이동 거리를 저장하는 배열
        int[][] distance = new int[m][n];

        // 초기 설정
        queue.offer(new Point(0, 0));
        maps[0][0] = 0;
        distance[0][0] = 1;

        while (!queue.isEmpty()) {
            Point node = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nowX = node.x + dx[i];
                int nowY = node.y + dy[i];

                // 다음 칸으로 이동할 수 있을 때
                if (nowX >= 0 && nowX < m
                        && nowY >= 0 && nowY < n
                        && maps[nowX][nowY] == 1) {
                    // 현재 좌표로 다시 오지 않도록 0으로 설정
                    maps[nowX][nowY] = 0;
                    
                    // 이동 거리 1 추가
                    distance[nowX][nowY] = distance[node.x][node.y] + 1;
                    
                    // 현재 좌표를 큐에 추가
                    queue.offer(new Point(nowX, nowY));
                }
            }
        }

        int answer = distance[m - 1][n - 1];
        return answer != 0 ? answer : -1;
    }
}