package level1;

import java.util.Arrays;

public class NNumberWithAnIntervalOfX {
    public static void main(String[] args) {
        int x = 10_000_000;
        int n = 1_000;

        System.out.println(Arrays.toString(solution(x, n)));
    }

    private static long[] solution(int x, int n) {
        long[] answer = new long[n];

        for (int i = 0; i < n; i++) {
            answer[i] = (long)x * (i + 1);
        }

        return answer;
    }
}
