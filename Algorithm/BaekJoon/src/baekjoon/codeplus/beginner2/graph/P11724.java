package baekjoon.codeplus.beginner2.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P11724 {
    private static List<List<Integer>> adjacency = new ArrayList<>();
    private static boolean[] check;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        for (int i = 0; i <= n; i++) {
            adjacency.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();

            adjacency.get(u).add(v);
            adjacency.get(v).add(u);
        }

        check = new boolean[n + 1];

        int answer = 0;

        for (int i = 1; i <= n; i++) {
            if (!check[i]) {
                dfs(i);
                answer++;
            }
        }

        System.out.println(answer);
    }

    private static void dfs(int vertex) {
        if (check[vertex]) {
            return;
        }
        check[vertex] = true;

        for (int v : adjacency.get(vertex)) {
            if (!check[v]) {
                dfs(v);
            }
        }
    }
}
