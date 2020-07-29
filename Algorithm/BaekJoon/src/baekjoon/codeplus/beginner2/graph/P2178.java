package baekjoon.codeplus.beginner2.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P2178 {
    private static int[] dx = {1, 0 , -1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int n;
    private static int m;
    private static int[][] map;
    private static int[][] step;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();
        map = new int[n][m];
        step = new int[n][m];
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            char[] inputText = scanner.nextLine().toCharArray();
            for (int j = 0; j < m; j++) {
                map[i][j] = inputText[j] - '0';
            }
        }

        bfs(0, 0);

        System.out.println(step[n - 1][m - 1]);
    }

    private static void bfs(int i, int j) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(i, j));
        step[i][j] = 1;

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int x = pair.x;
            int y = pair.y;

            for (int k = 0; k < dx.length; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if ((0 <= nx && nx < n) && (0 <= ny && ny < m)) {
                    if (map[nx][ny] == 1 && step[nx][ny] == 0) {
                        queue.offer(new Pair(nx, ny));
                        step[nx][ny] = step[x][y] + 1;
                    }
                }
            }
        }
    }

    static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
