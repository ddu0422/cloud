package baekjoon.codeplus.beginner2.graph;

import java.util.Scanner;

public class P16929 {
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int n;
    private static int m;
    private static char[][] map;
    private static boolean[][] check;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();

        map = new char[n][m];
        check = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            map[i] = scanner.next().toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (check[i][j]) {
                    continue;
                }

                if (dfs(-1, -1, i, j, map[i][j])) {
                    System.out.println("Yes");
                    System.exit(0);
                }
            }
        }

        System.out.println("No");
    }

    private static boolean dfs(int px, int py, int x, int y, char color) {
        if (check[x][y]) {
            return true;
        }

        check[x][y] = true;

        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if ((0 <= nx && nx < n) && (0 <= ny && ny < m)) {
                if (!(px == nx && py == ny) && map[nx][ny] == color) {
                    if (dfs(x, y, nx, ny, color)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
