package baekjoon.codeplus.beginner2.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P7576 {
    private static Scanner scanner = new Scanner(System.in);
    private static int n;
    private static int m;
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int[][] map;
    private static int[][] days;

    public static void main(String[] args) {
        m = scanner.nextInt();
        n = scanner.nextInt();
        map = new int[n][m];
        days = new int[n][m];

        bfs();
        result();
    }

    private static void bfs() {
        Queue<Pair> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = scanner.nextInt();
                days[i][j] = -1;
                if (map[i][j] == 1) {
                    queue.offer(new Pair(i, j));
                    days[i][j] = 0;
                }
            }
        }

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int x = pair.x;
            int y = pair.y;

            for (int i = 0; i < dx.length; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if ((0 <= nx && nx < n) && (0 <= ny && ny < m)) {
                    if (map[nx][ny] == 0 && days[nx][ny] == -1) {
                        queue.offer(new Pair(nx, ny));
                        days[nx][ny] = days[x][y] + 1;
                    }
                }
            }
        }
    }

    private static void result() {
        int answer = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                answer = Math.max(answer, days[i][j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0 && days[i][j] == -1) {
                    answer = -1;
                    break;
                }
            }
        }

        System.out.println(answer);
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
