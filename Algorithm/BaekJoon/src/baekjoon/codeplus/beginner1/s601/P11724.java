package baekjoon.codeplus.beginner1.s601;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class P11724 {
    private static List<Integer>[] a;
    private static boolean[] check;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // 정점의 개수
        int m = scanner.nextInt(); // 간선의 개수

        a = (LinkedList<Integer>[]) new LinkedList[n + 1];
        check = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            a[i] = new LinkedList<>();
        }

        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            a[u].add(v);
            a[v].add(u);
        }

        int answer = 0;

        for (int i = 1; i <= n; i++) {
            if (!check[i]) {
                dfs(i);
                answer += 1;
            }
        }

        System.out.println(answer);
    }

    private static void dfs(int x) {
        if (check[x]) return;
        check[x] = true;

        for (int number: a[x]) {
            if (!check[number]) {
                dfs(number);
            }
        }
    }
}
