package baekjoon.codeplus.beginner2.bruteforce.bitmask;

import java.util.Scanner;

public class P14391 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] paper = new int[n][m];
        int answer = 0;

        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            String text = scanner.nextLine();
            for (int j = 0; j < m; j++) {
                paper[i][j] = text.charAt(j) - '0';
            }
        }

        for (int s = 0; s < (1 << n * m); s++) {
            int sum = 0;

            // 가로
            for (int i = 0; i < n; i++) {
                int row = 0;

                for (int j = 0; j < m; j++) {
                    int k = i * m + j;

                    if ((s & (1 << k)) == 0) {
                        row = row * 10 + paper[i][j];
                    } else {
                        sum += row;
                        row = 0;
                    }
                }

                sum += row;
            }

            // 세로
            for (int j = 0; j < m; j++) {
                int column = 0;

                for (int i = 0; i < n; i++) {
                    int k = i * m + j;

                    if ((s & (1 << k)) != 0) {
                        column = column * 10 + paper[i][j];
                    } else {
                        sum += column;
                        column = 0;
                    }
                }

                sum += column;
            }

            answer = Math.max(answer, sum);
        }

        System.out.println(answer);
    }
}
