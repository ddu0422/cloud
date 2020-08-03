package baekjoon.codeplus.beginner2.graph;

import java.util.*;

// -2 : 조사 o, 순환선에 속하지 않음
// -1 : 조사 x, 순환선에 속하지 않음
// 1 : 조사 o, 순환선의 첫 시작
// 2 : 조사 o, 순환선의 속함
// 1. 순환선 찾기 (dfs)
// 2. 거리계산하기 (bfs)

public class P16947 {
    private static int n;
    private static List<List<Integer>> adjacency = new ArrayList<>();
    private static int[] check;
    private static int[] distance;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();

        for (int i = 0; i <= n; i++) {
            adjacency.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();

            adjacency.get(u).add(v);
            adjacency.get(v).add(u);
        }

        check = new int[n + 1];
        distance = new int[n + 1];

        dfs(-1, 1);
        bfs();

        for (int i = 1; i <= n; i++) {
            System.out.print(distance[i] + " ");
        }
    }

    private static int dfs(int pv, int cv) {
        // 현재 정점이 시작점이라면 현재 정점을 반환 (1 ~ n)
        if (check[cv] == 1) {
            return cv;
        }

        // 현재 정점이 기준
        check[cv] = 1;

        for (int nv : adjacency.get(cv)) {
            // 바로 이전에 연결된 걸로 돌아가는 걸 순환에서 제외
            if (pv == nv) {
                continue;
            }

            // 경로탐색 결과
            int result = dfs(cv, nv);

            if (result == -2) {
                return -2;
            }

            // 싸이클이 존재한다면
            if (result >= 0) {
                // 싸이클에 포함되니깐 2를 넣어준다.
                check[cv] = 2;
                // 싸이클의 시작점
                if (cv == result) {
                    return -2;
                } else {
                    // 싸이클에 포함되는 정점
                    return result;
                }
            }
        }

        // 순환선을 찾을 수 없음
        return -1;
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if (check[i] == 2) {
                distance[i] = 0;
                queue.offer(i);
            } else {
                distance[i] = -1;
            }
        }

        while (!queue.isEmpty()) {
            int x = queue.poll();

            for (int v : adjacency.get(x)) {
                if (distance[v] == -1) {
                    queue.offer(v);
                    distance[v] = distance[x] + 1;
                }
            }
        }
    }
}