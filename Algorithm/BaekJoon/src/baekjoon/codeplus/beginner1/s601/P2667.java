package baekjoon.codeplus.beginner1.s601;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P2667 {
    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static final int[] dx = {0, 0, 1, -1};
    private static final int[] dy = {1, -1, 0, 0};
    private static int[][] a;
    private static int[][] group;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();

        a = new int[n][n];
        group = new int[n][n];

        // 입력
        for (int i = 0; i < n; i++) {
            String s = scanner.nextLine();
            for (int j = 0; j < n; j++) {
                a[i][j] = s.charAt(j) - '0';
            }
        }

        // 그룹의 수
        int cnt = 0;

        // 전체 탐색
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 집이 있고 group에 속하지 않으면
                if (a[i][j] == 1 && group[i][j] == 0) {
                    bfs(i, j, ++cnt, n);
                }
            }
        }

        int[] answer = new int[cnt];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (group[i][j] != 0) {
                    // 각 group마다 집이 몇개 있는지 센다.
                    answer[group[i][j] - 1] += 1;
                }
            }
        }

        // 오름차순으로 정렬해서 출력해야한다.
        Arrays.sort(answer);
        System.out.println(cnt);

        for (int result : answer) {
            System.out.println(result);
        }
    }

    private static void bfs(int x, int y, int cnt, int n) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(x, y)); // 첫 번째 1을 넣는다.
        group[x][y] = cnt; // 해당 그룹을 1이라고 한다.

        while (!queue.isEmpty()) {
            Pair pair = queue.remove();
            x = pair.x;
            y = pair.y;

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                // 갈 수 있는 범위를 조사한다.
                if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                    // 해당이 1이고 group이 없으면 queue에 추가하고 해당 group을 cnt로 한다.
                    if (a[nx][ny] == 1 && group[nx][ny] == 0) {
                        queue.add(new Pair(nx, ny));
                        group[nx][ny] = cnt;
                    }
                }
            }
        }
    }
}
