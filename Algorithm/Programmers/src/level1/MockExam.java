package level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MockExam {
    public static void main(String[] args) {
        int[] answers = {1, 3, 2, 4, 2};

        System.out.println(Arrays.toString(solution(answers)));
    }

    private static int[] solution(int[] answers) {
        List<Integer> results = new ArrayList<>();

        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] scores = new int[3];

        for (int i = 0; i < answers.length; i++) {
            int answer = answers[i];

            if (one[i % one.length] == answer) {
                scores[0] += 1;
            }

            if (two[i % two.length] == answer) {
                scores[1] += 1;
            }

            if (three[i % three.length] == answer) {
                scores[2] += 1;
            }
        }

        int max = Math.max(scores[0], Math.max(scores[1], scores[2]));

        for (int i = 0; i < scores.length; i++) {
            if (max == scores[i]) {
                results.add(i + 1);
            }
        }

        int[] answer = new int[results.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = results.get(i);
        }

        return answer;
    }
}
