import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class Solution {
    public int solution(String begin, String target, String[] words) {
        // 방문 여부 및 변환 횟수 저장
        Map<String, Integer> visitedMap = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        
        // 초기 설정
        queue.offer(begin);
        visitedMap.put(begin, 1);

        while (!queue.isEmpty()) {
            String poll = queue.poll();

            for (String now : words) {
                int diff = 0;

                // 이미 변환했던 단어라면 탐색하지 않음
                if (visitedMap.containsKey(now)) {
                    continue;
                }

                // 단어 비교. 알파벳이 하나 다를 때마다 diff++
                for (int j = 0; j < poll.length(); j++) {
                    if (poll.charAt(j) != now.charAt(j)) {
                        diff++;
                    }
                }

                // 알파벳 하나만 다를 경우
                if (diff == 1) {
                    if (now.equals(target)) {
                        return visitedMap.get(poll);
                    }
                    visitedMap.put(now, visitedMap.get(poll) + 1);
                    queue.offer(now);
                }
            }
        }

        return 0;
    }
}