import java.util.HashSet;
import java.util.Set;


class Solution {
    static boolean[] visited;
    static char[] charArray;
    static Set<Integer> result = new HashSet<>();

    static public int solution(String numbers) {
        charArray = numbers.toCharArray();
        visited = new boolean[charArray.length];

        for (int i = 0; i < charArray.length; i++) {
            dfs(0, i + 1, "");
        }

        return result.size();
    }

    static private void dfs(int depth, int digits, String num) {
        // N자리수 숫자가 완성되면 소수 판별
        if (depth == digits) {
            if (isPrime(Integer.parseInt(num))) {
                result.add(Integer.parseInt(num));
            }
            return;
        }
        
        for (int i = 0; i < charArray.length; i++) {
            // 정수의 첫째 자리가 0이면 생략
            if (depth == 0 && charArray[i] == '0') {
                continue;
            }

            if (!visited[i]) {
                visited[i] = true;
                dfs(depth + 1, digits, num + charArray[i]);
                visited[i] = false;
            }
        }
    }

    // 소수 판별 함수
    static public boolean isPrime(int number) {
        // 1보다 작거나 같은 경우 소수가 아님
        if (number <= 1) {
            return false;
        }
        // 2와 3은 소수
        if (number == 2 || number == 3) {
            return true;
        }
        // 짝수이거나 3으로 나누어 떨어지면 소수가 아님
        if (number % 2 == 0 || number % 3 == 0) {
            return false;
        }
        // 5부터 루트 number까지 홀수에 대해 나눠보며 검사
        for (int i = 5; i * i <= number; i += 6) {
            if (number % i == 0 || number % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}