package baekjoon.codeplus.beginner2.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P7562 {
    private static int[] dx = {2, 1, -1, -2, -2, -1, 1, 2};
    private static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
    private static int[][] map;
    private static int n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        while (t-- > 0) {
            n = scanner.nextInt();
            map = new int[n][n];

            bfs(scanner.nextInt(), scanner.nextInt());

            System.out.println(map[scanner.nextInt()][scanner.nextInt()] - 1);
        }
    }

    private static void bfs(int i, int j) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(i, j));
        map[i][j] = 1;

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int x = pair.x;
            int y = pair.y;

            for (int k = 0; k < dx.length; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if ((0 <= nx && nx < n) && (0 <= ny && ny < n)) {
                    if (map[nx][ny] == 0) {
                        queue.offer(new Pair(nx, ny));
                        map[nx][ny] = map[x][y] + 1;
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
