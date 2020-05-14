package baekjoon.codeplus.beginner2.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringJoiner;

// 요세푸스
// 1. 원순열은 큐를 이용한다.
// 2. 3번째 차례가 아닌 경우 맨 앞에서 꺼내어 맨 뒤로 넣는다.
// 3. 3번째 차례인 경우 꺼낸다.

public class P1158 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringJoiner stringJoiner = new StringJoiner(", ", "<", ">");

        Queue<Integer> queue = new LinkedList<>();
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int count = 1;
        int[] answer = new int[n];

        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        while (!queue.isEmpty()) {
            if (count % k == 0) {
                answer[count / k - 1] = queue.poll();
            } else {
                queue.offer(queue.poll());
            }

            count++;
        }

        for (int i : answer) {
            stringJoiner.add(String.valueOf(i));
        }

        System.out.println(stringJoiner.toString());
    }
}
