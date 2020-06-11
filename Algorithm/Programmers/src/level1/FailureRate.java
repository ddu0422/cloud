package level1;

import java.util.*;

public class FailureRate {
    public static void main(String[] args) {
        int n = 4;
        int[] stages = {1, 2, 3, 3, 3};

        System.out.println(Arrays.toString(solution(n, stages)));
    }

    private static int[] solution(int n, int[] stages) {
        int[] answer = new int[n];
        Map<Integer, Integer> clearedStages = new HashMap<>();
        Map<Integer, Double> average = new HashMap<>();

        for (int stage : stages) {
            clearedStages.put(stage - 1, clearedStages.getOrDefault(stage - 1, 0) + 1);
        }

        for (int i = 1; i <= n; i++) {
            double challenge = stages.length - totalClearedStage(clearedStages, i - 1);

            if (challenge != 0) {
                average.put(i, clearedStages.getOrDefault(i - 1, 0) / challenge);
            } else {
                average.put(i, 0.0);
            }
        }

        List<Integer> keys = new ArrayList<>(average.keySet());

        keys.sort((o1, o2) -> {
            Double compare1 = average.get(o1);
            Double compare2 = average.get(o2);
            return ((Comparable<Double>) compare2).compareTo(compare1);
        });

        for (int i = 0; i < n; i++) {
            answer[i] = keys.get(i);
        }

        return answer;
    }

    private static double totalClearedStage(Map<Integer, Integer> maps, int n) {
        double sum = 0;

        for (int i = 0; i < n; i++) {
            sum += maps.getOrDefault(i, 0);
        }

        return sum;
    }
}
