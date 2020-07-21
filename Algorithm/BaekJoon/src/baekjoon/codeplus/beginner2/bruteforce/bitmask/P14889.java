package baekjoon.codeplus.beginner2.bruteforce.bitmask;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P14889 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[][] s = new int[n][n];
        int answer = -1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                s[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < (1 << n); i++) {
            List<Integer> team1 = new ArrayList<>();
            List<Integer> team2 = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    team1.add(j);
                } else {
                    team2.add(j);
                }
            }

            if (team1.size() != n / 2) {
                continue;
            }

            int t1 = 0;
            int t2 = 0;

            for (int j = 0; j < n / 2; j++) {
                for (int k = 0; k < n / 2; k++) {
                    if (j == k) {
                        continue;
                    }
                    t1 += s[team1.get(j)][team1.get(k)];
                    t2 += s[team2.get(j)][team2.get(k)];
                }
            }

            int diff = Math.abs(t1 - t2);

            if (answer == -1 || answer > diff) {
                answer = diff;
            }
        }

        System.out.println(answer);
    }
}
