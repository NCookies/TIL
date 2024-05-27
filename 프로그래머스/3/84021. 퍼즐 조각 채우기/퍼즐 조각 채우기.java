import java.util.*;

class Solution {
    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Point)) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }
    
    static public int solution(int[][] gameBoard, int[][] table) {
        int answer = 0;

        List<List<Point>> emptyBlocks = extractBlocks(gameBoard, 0);
        List<List<Point>> puzzleBlocks = extractBlocks(table, 1);

        // 빈 블럭 순회
        for (List<Point> emptyBlock : emptyBlocks) {
            // 비교를 위해 정규화 수행
            List<Point> normalized = normarlize(emptyBlock);

            for (List<Point> puzzleBlock : puzzleBlocks) {
                if (emptyBlock.size() != puzzleBlock.size()) {
                    continue;
                }

                if (compareBlocks(normalized, puzzleBlock)) {
                    answer += emptyBlock.size();
                    puzzleBlocks.remove(puzzleBlock);

                    break;
                }
            }
        }

        return answer;
    }

    static private boolean compareBlocks(List<Point> emptyBlock, List<Point> puzzleBlock) {
        List<List<Point>> rotated = List.of(
                normarlize(puzzleBlock),
                normarlize(rotate90(puzzleBlock)),
                normarlize(rotate180(puzzleBlock)),
                normarlize(rotate270(puzzleBlock))
        );

        for (List<Point> rotatedBlock : rotated) {
            if (emptyBlock.equals(rotatedBlock)) {
                return true;
            }
        }

        return false;
    }


    // 추출한 블럭 저장
    static private List<List<Point>> blocks = new ArrayList<>();
    static boolean[][] visited;

    // 현재 위치 기준 상, 우, 하, 좌의 좌표
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};


    // 테이블에서 블럭 추출하기
    static private List<List<Point>> extractBlocks(int[][] table, int extractNum) {
        blocks = new ArrayList<>();
        visited = new boolean[table.length][table[0].length];

        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {

                // 방문했던 좌표이거나 추출하지 않을 블럭이라면 패스
                if (visited[i][j] || table[i][j] != extractNum) {
                    continue;
                }
                // DFS 구현
                List<Point> block = new ArrayList<>();
                dfs(table, i, j, extractNum, block);
                blocks.add(block);
                
                // BFS 구현
//                bfs(table, i, j, extractNum);
            }
        }

        return blocks;
    }

    private static void bfs(int[][] table, int i, int j, int extractNum) {
        // BFS 구현 시 사용
        Queue<Point> queue = new LinkedList<>();

        // 추출한 하나의 블럭 저장
        List<Point> block = new ArrayList<>();

        queue.offer(new Point(i, j));
        visited[i][j] = true;

        // 블럭 추출
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            block.add(point);

            for (int dir = 0; dir < 4; dir++) {
                int nowX = point.x + dx[dir];
                int nowY = point.y + dy[dir];

                // 현재 위치 기준 상하좌우 좌표가 유효하면서 방문하지 않은 경우
                if (nowX >= 0 && nowX < table.length
                        && nowY >= 0 && nowY < table[0].length
                        && !visited[nowX][nowY]
                        && table[nowX][nowY] == extractNum) {
                    // 방문 여부 표시
                    visited[nowX][nowY] = true;

                    // 해당 좌표를 큐에 추가
                    queue.offer(new Point(nowX, nowY));
                }
            }
        }

        blocks.add(block);
    }

    private static void dfs(int[][] table, int i, int j, int extractNum, List<Point> block) {
        block.add(new Point(i, j));
        visited[i][j] = true;

        for (int dir = 0; dir < 4; dir++) {
            int nowX = i + dx[dir];
            int nowY = j + dy[dir];

            // 현재 위치 기준 상하좌우 좌표가 유효하면서 방문하지 않은 경우
            if (nowX >= 0 && nowX < table.length
                    && nowY >= 0 && nowY < table[0].length
                    && !visited[nowX][nowY]
                    && table[nowX][nowY] == extractNum) {
                dfs(table, nowX, nowY, extractNum, block);
            }
        }
    }

    private static List<Point> normarlize(List<Point> block) {
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;

        for (Point p : block) {
            if (p.x < minX) minX = p.x;
            if (p.y < minY) minY = p.y;
        }

        List<Point> normalized = new ArrayList<>();
        for (Point p : block) {
            normalized.add(new Point(p.x - minX, p.y - minY));
        }

        // 정규화된 좌표 데이터를 정렬
        normalized.sort(Comparator.comparingInt((Point p) -> p.x).thenComparingInt(p -> p.y));
        return normalized;
    }

    private static List<Point> rotate90(List<Point> block) {
        List<Point> rotated = new ArrayList<>();
        for (Point p : block) {
            rotated.add(new Point(-p.y, p.x));
        }
        return rotated;
    }

    private static List<Point> rotate180(List<Point> block) {
        List<Point> rotated = new ArrayList<>();
        for (Point p : block) {
            rotated.add(new Point(-p.x, -p.y));
        }
        return rotated;
    }

    private static List<Point> rotate270(List<Point> block) {
        List<Point> rotated = new ArrayList<>();
        for (Point p : block) {
            rotated.add(new Point(p.y, -p.x));
        }
        return rotated;
    }
}