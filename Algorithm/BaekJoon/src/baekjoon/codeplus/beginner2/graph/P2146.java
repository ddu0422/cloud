package baekjoon.codeplus.beginner2.graph;

import java.util.*;

public class P2146 {
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int n;
    private static int[][] map;
    private static int[][] group;
    private static int[][] distance;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        map = new int[n][n];
        group = new int[n][n];
        distance = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = scanner.nextInt();
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

        bfs();

        System.out.println(result());
     }

    private static void dfs(int x, int y, int groupNumber) {
        group[x][y] = groupNumber;

        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if ((0 <= nx && nx < n) && (0 <= ny && ny < n)) {
                if (map[nx][ny] == 1 && group[nx][ny] != groupNumber) {
                    dfs(nx, ny, groupNumber);
                }
            }
        }
    }

    private static void bfs() {
        Queue<Pair> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) {
                    queue.add(new Pair(i, j));
                } else {
                    distance[i][j] = -1;
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

                if ((0 <= nx && nx < n) && (0 <= ny && ny < n)) {
                    if (distance[nx][ny] == -1) {
                        queue.offer(new Pair(nx, ny));
                        distance[nx][ny] = distance[x][y] + 1;
                        // 핵심
                        group[nx][ny] = group[x][y];
                    }
                }
            }
        }
    }

    private static int result() {
        int answer = -1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < dx.length; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if ((0 <= nx && nx < n) && (0 <= ny && ny < n)) {
                        if (group[i][j] != group[nx][ny]) {
                            int calculate = distance[i][j] + distance[nx][ny];

                            if (answer == -1 || answer > calculate) {
                                answer = calculate;
                            }
                        }
                    }
                }
            }
        }

        return answer;
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
