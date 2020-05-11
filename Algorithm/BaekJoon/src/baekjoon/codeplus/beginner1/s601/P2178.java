package baekjoon.codeplus.beginner1.s601;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P2178 {
    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static final int[] dx = {0, -1, 0, 1};
    private static final int[] dy = {-1, 0, 1, 0};
    private static int[][] map;
    private static int[][] a;
    private static boolean[][] check;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();

        map = new int[n][m];
        a = new int[n][m];
        check = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String s = scanner.nextLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        bfs(n, m);

        System.out.println(a[n -1][m - 1]);
    }

    private static void bfs(int n, int m) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, 0));
        check[0][0] = true;
        a[0][0] = 1;

        while (!queue.isEmpty()) {
            Pair pair = queue.remove();
            int x = pair.x;
            int y = pair.y;

            for (int k = 0; k < dx.length; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (!check[nx][ny] && map[nx][ny] == 1) {
                        queue.add(new Pair(nx, ny));
                        a[nx][ny] = a[x][y] + 1;
                        check[nx][ny] = true;
                    }
                }
            }
        }
    }
}
