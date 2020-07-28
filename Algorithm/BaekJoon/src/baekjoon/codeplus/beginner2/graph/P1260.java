package baekjoon.codeplus.beginner2.graph;

import java.util.*;

public class P1260 {
    private static List<List<Integer>> adjacencyList = new ArrayList<>();
    private static boolean[] check;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int start = scanner.nextInt();

        for (int i = 0; i <= n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();

            adjacencyList.get(u).add(v);
            adjacencyList.get(v).add(u);
        }

        for (int i = 0; i <= n; i++) {
            Collections.sort(adjacencyList.get(i));
        }

        check = new boolean[n + 1];
        dfs(start);
        System.out.println();

        check = new boolean[n + 1];
        bfs(start);
    }

    private static void dfs(int vertex) {
        if (check[vertex]) {
            return;
        }

        check[vertex] = true;
        System.out.print(vertex + " ");

        for (int v : adjacencyList.get(vertex)) {
            if (!check[v]) {
                dfs(v);
            }
        }
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        check[start] = true;

        while (!queue.isEmpty()) {
            int x = queue.poll();
            System.out.print(x + " ");

            for (int v : adjacencyList.get(x)) {
                if (!check[v]) {
                    check[v] = true;
                    queue.offer(v);
                }
            }
        }
    }
}
