package baekjoon.codeplus.beginner1.s701;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P14226 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[][] d = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(d[i], -1);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1); // 이모티콘
        queue.add(0); // 클립보드
        d[1][0] = 0;

        while (!queue.isEmpty()) {
            int s = queue.remove();
            int c = queue.remove();

            // 화면에 있는 이모티콘을 모두 복사해서 클립보드에 저장
            if (d[s][s] == -1) {
                d[s][s] = d[s][c] + 1;
                queue.add(s);
                queue.add(s);
            }

            // 클립보드에 있는 모든 이모티콘을 화면에 붙여넣기
            if (s + c <= n && d[s + c][c] == -1) {
                d[s + c][c] = d[s][c] + 1;
                queue.add(s + c);
                queue.add(c);
            }

            // 화면에 있는 이모티콘 중 하나를 삭제
            if (s - 1 >= 0 && d[s - 1][c] == -1) {
                d[s - 1][c] = d[s][c] + 1;
                queue.add(s - 1);
                queue.add(c);
            }
        }

        int answer = -1;

        for (int i = 0; i <= n; i++) {
            if (d[n][i] != -1) {
                if (answer == -1 || answer > d[n][i]) {
                    answer = d[n][i];
                }
            }
        }

        System.out.println(answer);

    }
}
