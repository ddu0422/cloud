package level2;

import java.util.LinkedList;
import java.util.Queue;

public class Printer {
    public static void main(String[] args) {
        int[] priorities = {2, 2, 2, 1, 3, 4};
        int location = 3;

        System.out.println(solution(priorities, location));
    }

    private static int solution(int[] priorities, int location) {
        Queue<Paper> queue = new LinkedList<>();
        int answer = 1;

        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new Paper(priorities[i], i));
        }

        while (!queue.isEmpty()) {
            Paper paper = queue.peek();

            if (paper.priority < findMax(queue, paper)) {
                queue.offer(queue.poll());
                continue;
            }

            if (queue.poll().location == location) {
                break;
            }

            answer++;
        }

        return answer;
    }

    private static int findMax(Queue<Paper> queue, Paper paper) {
        int max = paper.priority;

        for (Paper value : queue) {
            max = Math.max(value.priority, max);
        }

        return max;
    }

    private static class Paper {
        int priority;
        int location;

        Paper(int priority, int location) {
            this.priority = priority;
            this.location = location;
        }
    }
}
