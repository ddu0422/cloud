package baekjoon.codeplus.beginner2.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P13023 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        // 인접행렬
        boolean[][] adjacencyMatrix = new boolean[n][n];

        // 인접리스트
        List<List<Integer>> adjacencyList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        // 간선리스트
        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int from = scanner.nextInt();
            int to = scanner.nextInt();

            // 인접행렬 초기화
            adjacencyMatrix[from][to] = adjacencyMatrix[to][from] = true;

            // 인접리스트 초기화
            adjacencyList.get(from).add(to);
            adjacencyList.get(to).add(from);

            // 간선리스트 초기화
            edges.add(new Edge(from, to));
            edges.add(new Edge(to, from));
        }

        m *= 2; // 친구 관계는 양방향이므로 2를 곱해준다.

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {

                // A -> B
                int A = edges.get(i).from;
                int B = edges.get(i).to;

                // C -> D
                int C = edges.get(j).from;
                int D = edges.get(j).to;

                // 서로 달라야한다.
                if (A == B || A == C || A == D || B == C || B == D || C == D) {
                    continue;
                }

                // B -> C
                if (!adjacencyMatrix[B][C]) {
                    continue;
                }

                // D -> E
                for (int E : adjacencyList.get(D)) {
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

    static class Edge {
        int from;
        int to;

        Edge(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }
}