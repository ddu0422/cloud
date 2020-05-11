package baekjoon.codeplus.beginner1.s601;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P1707 {
    private static List<Integer>[] a;
    private static int[] color; // 0 방문하지않음 1 그룹 1, 2 그룹 2

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int k = scanner.nextInt();

        while (k-- > 0) {
            int v = scanner.nextInt();
            int e = scanner.nextInt();

            a = (ArrayList<Integer>[]) new ArrayList[v + 1];
            color = new int[v + 1];

            for (int i = 1; i <= v; i++) {
                a[i] = new ArrayList<>();
            }

            for (int i = 0; i < e; i++) {
                int n = scanner.nextInt();
                int m = scanner.nextInt();
                a[n].add(m);
                a[m].add(n);
            }

            for (int i = 1; i <= v; i++) {
                if (color[i] == 0) {
                    dfs(i, 1);
                }
            }

            boolean ok = true;

            for (int i = 1; i <= v; i++) {
                for (int y: a[i]) {
                    if (color[i] == color[y]) {
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

    private static void dfs(int i, int c) {
        color[i] = c;

        for (int y : a[i]) {
            if (color[y] == 0) {
                dfs(y, 3 - c);
            }
        }
    }
}
