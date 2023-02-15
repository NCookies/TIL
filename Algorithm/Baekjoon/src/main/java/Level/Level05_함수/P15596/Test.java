package Level.Level05_함수.P15596;

public class Test {
    long sum(int[] a) {
        long ans = 0;

        for (int num : a) {
            ans += num;
        }

        return ans;
    }
}
