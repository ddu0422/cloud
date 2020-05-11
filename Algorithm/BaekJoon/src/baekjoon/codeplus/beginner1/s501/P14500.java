package baekjoon.codeplus.beginner1.s501;

import java.util.Scanner;

public class P14500 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = scanner.nextInt();
            }
        }


    }
}
