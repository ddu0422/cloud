package baekjoon.codeplus.beginner2.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P1707 {
    private static List<List<Integer>> adjacency;
    private static int[] color;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int k = scanner.nextInt();

        while (k-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            adjacency = new ArrayList<>();

            for (int i = 0; i <= n; i++) {
                adjacency.add(new ArrayList<>());
            }
            color = new int[n + 1];

            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();

                adjacency.get(u).add(v);
                adjacency.get(v).add(u);
            }

            boolean ok = true;

            for (int i = 1; i <= n; i++) {
                if (color[i] == 0) {
                    if (!dfs(i, 1)) {
                        ok = false;
                        break;
                    }
                }
            }

            if (ok) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static boolean dfs(int vertex, int c) {
        color[vertex] = c;

        for (int next : adjacency.get(vertex)) {
            if (color[next] == 0) {
                if (!dfs(next, 3 - c)) {
                    return false;
                }
            } else if (color[next] == color[vertex]) {
                return false;
            }
        }

        return true;
    }
}
