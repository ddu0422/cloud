package baekjoon.codeplus.beginner1.s601;

import java.util.*;

class Edge {
    int from, to;

    Edge(int from, int to) {
        this.from = from;
        this.to = to;
    }
}

public class P13023 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        boolean[][] a = new boolean[n][n]; // 인접행렬
        List<Integer>[] g = (List<Integer>[]) new ArrayList[n]; // 인접리스트
        List<Edge> edges = new ArrayList<>(); // 간선리스트

        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            edges.add(new Edge(from, to));
            edges.add(new Edge(to, from));
            a[from][to] = a[to][from] = true;
            g[from].add(to);
            g[to].add(from);
        }

        m *= 2; // m은 친구관계의 수

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                int A = edges.get(i).from;
                int B = edges.get(i).to;
                int C = edges.get(j).from;
                int D = edges.get(j).to;

                if (A == B || A == C || A == D || B == C || B == D || C == D) {
                    continue;
                }

                if (!a[B][C]) continue;

                for (int E : g[D]) {
                    if (A == E || B == E || C == E || D == E) {
                        continue;
                    }
                    System.out.println(1);
                    System.exit(0);
                }
            }
        }
        System.out.println(0);
    }
}
