package baekjoon.codeplus.beginner1.s601;

import java.util.*;

public class P1260 {
    private static List<Integer>[] a;
    private static boolean[] check;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // 정점의 수
        int m = scanner.nextInt(); // 간선의 수
        int v = scanner.nextInt(); // 탐색을 시작할 정점의 번호

        // LinkedList 배열 -> 간선을 저장
        a = (LinkedList<Integer>[]) new LinkedList[n + 1];

        // 정점의 번호에 LinkedList 객체 생성
        for (int i = 1; i <= n; i++) {
            a[i] = new LinkedList<>();
        }

        // 정점에 간선을 추가
        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            a[x].add(y);
            a[y].add(x);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(a[i]);
        }

        check = new boolean[n + 1];
        dfs(v);
        System.out.println();

        check = new boolean[n + 1];
        bfs(v);
        System.out.println();
    }

    private static void dfs(int x) {
        // 지났으면 갈 수 없다.
        if (check[x]) return;
        // 들어온 순간 true
        check[x] = true;
        System.out.print(x + " ");

        for (int number: a[x]) {
            if (!check[number]) {
                dfs(number);
            }
        }
    }

    private static void bfs(int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        check[x] = true;

        while (!queue.isEmpty()) {
            int n = queue.remove();
            System.out.print(n + " ");
            for (int m : a[n]) {
                if (!check[m]) {
                    check[m] = true;
                    queue.add(m);
                }
            }
        }
    }
}
