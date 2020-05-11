package baekjoon.codeplus.beginner1.s601;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P4963 {
    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static final int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static final int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    private static int[][] map;
    private static int[][] group;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // 입력
            int w = scanner.nextInt();
            int h = scanner.nextInt();

            if (w == 0 && h == 0) break;

            map = new int[w][h];
            group = new int[w][h];

            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    map[j][i] = scanner.nextInt();
                }
            }

            // group의 번호
            int cnt = 0;

            // 전체 탐색
            for (int i = 0; i < w; i++) {
                for (int j = 0; j < h; j++) {
                    if (map[i][j] == 1 && group[i][j] == 0) {
                        bfs(i, j, ++cnt, w, h);
                    }
                }
            }

            System.out.println(cnt);
        }
    }

    private static void bfs(int x, int y, int cnt, int w, int h) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(x, y));
        group[x][y] = cnt;

        while (!queue.isEmpty()) {
            Pair pair = queue.remove();
            int a = pair.x;
            int b = pair.y;

            for (int k = 0; k < 8; k++) {
                int nx = a + dx[k];
                int ny = b + dy[k];

                if (0 <= nx && nx < w && 0 <= ny && ny < h) {
                    if (map[nx][ny] == 1 && group[nx][ny] == 0) {
                        queue.add(new Pair(nx, ny));
                        group[nx][ny] = cnt;
                    }
                }
            }
        }
    }
}
