package baekjoon.codeplus.beginner2.graph;

import java.util.Scanner;

public class P4963 {
    private static int[] dx = {1, 1, 0, -1, -1, -1, 0, 1};
    private static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    private static int n;
    private static int m;
    private static int[][] map;
    private static int[][] group;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            m = scanner.nextInt();
            n = scanner.nextInt();

            if (n == 0 && m == 0) {
                break;
            }

            map = new int[n][m];
            group = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    map[i][j] = scanner.nextInt();
                }
            }

            int groupNumber = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == 1 && group[i][j] == 0) {
                        dfs(i, j, ++groupNumber);
                    }
                }
            }

            System.out.println(groupNumber);
        }
    }

    private static void dfs(int x, int y, int groupNumber) {
        group[x][y] = groupNumber;

        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if ((0 <= nx && nx < n) && (0 <= ny && ny < m)) {
                if (map[nx][ny] == 1 && group[nx][ny] == 0) {
                    dfs(nx, ny, groupNumber);
                }
            }
        }
    }
}
