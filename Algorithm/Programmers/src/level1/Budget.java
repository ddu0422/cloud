package level1;

import java.util.Arrays;

public class Budget {
    public static void main(String[] args) {
        int[] d = {1, 1, 2, 3, 3, 3, 3, 1, 1};
        int budget = 9;

        System.out.println(solution(d, budget));
    }

    private static int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);

        for (int i : d) {
            if (budget - i < 0) {
                break;
            }
            budget -= i;
            answer++;
        }

        return answer;
    }
}
