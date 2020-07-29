package baekjoon.codeplus.beginner2.graph;

import java.util.Arrays;
import java.util.Scanner;

public class P2667 {
    private static int[] dx = {1, 0 , -1 , 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int n;
    private static int[][] map;
    private static int[][] group;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        scanner.nextLine();
        map = new int[n][n];
        group = new int[n][n];

        for (int i = 0; i < n; i++) {
            char[] inputText = scanner.nextLine().toCharArray();
            for (int j = 0; j < n; j++) {
                map[i][j] = inputText[j] - '0';
            }
        }

        int groupNumber = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && group[i][j] == 0) {
                    dfs(i, j, ++groupNumber);
                }
            }
        }

        int[] answer = new int[groupNumber];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (group[i][j] != 0) {
                    answer[group[i][j] - 1] += 1;
                }
            }
        }

        Arrays.sort(answer);

        System.out.println(groupNumber);
        for (int i : answer) {
            System.out.println(i);
        }
    }

    private static void dfs(int x, int y, int groupNumber) {
        group[x][y] = groupNumber;

        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if ((0 <= nx && nx < n) && (0 <= ny && ny < n)) {
                if (map[nx][ny] == 1 && group[nx][ny] == 0) {
                    dfs(nx, ny, groupNumber);
                }
            }
        }
    }
}
