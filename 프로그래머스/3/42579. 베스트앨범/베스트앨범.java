import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genrePlayCntMap = new HashMap<>();
        Map<String, Map<Integer, Integer>> songPlayMap = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            // 장르별 재생수 카운트
            int oldScore = genrePlayCntMap.getOrDefault(genres[i], 0);
            genrePlayCntMap.put(genres[i], oldScore + plays[i]);

            // 해당 장르의 첫 번째 곡이라면 빈 HashMap 데이터 새로 할당
            // key: 인덱스, value: 해당 곡의 재생수를 가지는 Map 데이터 추가
            songPlayMap.computeIfAbsent(genres[i], k -> new HashMap<>()).put(i, plays[i]);
        }

        // 노래들의 재생수가 가장 많은 장르부터 내림차순 정렬
        ArrayList<String> keySet = new ArrayList<>(genrePlayCntMap.keySet());
        keySet.sort(((o1, o2) -> genrePlayCntMap.get(o2).compareTo(genrePlayCntMap.get(o1))));

        List<Integer> answerList = new ArrayList<>();
        int answerIndex = 0;
        for (String s : keySet) {
            // 인기 장르 순으로 추출
            Map<Integer, Integer> map = songPlayMap.get(s);

            ArrayList<Integer> integers = new ArrayList<>(map.keySet());
            integers.sort(((o1, o2) -> map.get(o2).compareTo(map.get(o1))));
            for (int playCnt : integers) {
                answerList.add(playCnt);
                if (answerIndex++ == 1)   break;    // 장르별 두 곡까지만 수록
            }
            answerIndex = 0;
        }

        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }
}