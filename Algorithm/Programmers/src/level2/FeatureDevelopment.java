package level2;

import java.util.*;

public class FeatureDevelopment {
    private static final int COMPLETE = 100;

    public static void main(String[] args) {
        int[] progresses = {99, 99, 99, 50, 50, 10, 10, 5};
        int[] speeds = {40, 40, 40, 40, 40, 40, 40, 20};

        System.out.println(Arrays.toString(solution(progresses, speeds)));
    }

    private static int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> days = new LinkedList<>();
        List<Integer> distributed = new ArrayList<>();
        int count = 1;

        for (int i = 0; i < progresses.length; i++) {
            days.offer((int) Math.ceil((COMPLETE - progresses[i]) / (speeds[i] * 1.0)));
        }

        while (!days.isEmpty()) {
            int first = days.poll();

            while (!days.isEmpty()) {
                if (first >= days.peek()) {
                    days.poll();
                    count++;
                } else {
                    distributed.add(count);
                    count = 1;
                    break;
                }
            }
        }

        distributed.add(count);

        int[] answer = new int[distributed.size()];

        for (int i = 0; i < distributed.size(); i++) {
            answer[i] = distributed.get(i);
        }

        return answer;
    }
}
