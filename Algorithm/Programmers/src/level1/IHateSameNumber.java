package level1;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class IHateSameNumber {
    public static void main(String[] args) {
        int[] arr = {1, 1, 3, 3, 0, 1, 1};

        System.out.println(Arrays.toString(solution(arr)));
    }

    private static int[] solution(int[] arr) {
        Deque<Integer> deque = new LinkedList<>();

        for (int value : arr) {
            if (!deque.isEmpty() && deque.peekLast() == value) {
                continue;
            }
            deque.add(value);
        }

        int[] answer = new int[deque.size()];

        // steam 사용
        // int[] answer1 = deque.stream()
        //        .mapToInt(Integer::intValue)
        //        .toArray();

        for (int i = 0; i < answer.length; i++) {
            if (!deque.isEmpty()) {
                answer[i] = deque.pollFirst();
            }
        }

        return answer;
    }
}
