package baekjoon.codeplus.beginner2.bruteforce.backtracking;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

// 스타트와 링크
// 흠... 아직 잘모르겠다. 나중에 다시 풀어보자.

public class P14889 {
    private static int n;
    private static int[][] s;
    private static List<Integer> first = new LinkedList<>();
    private static List<Integer> second = new LinkedList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        s = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                s[i][j] = scanner.nextInt();
            }
        }

        System.out.println(go(0));
    }

    private static int go(int index) {
        if (first.size() > n / 2 || second.size() > n / 2) {
            return -1;
        }

        if (index == n) {
            int t1 = 0;
            int t2 = 0;

            for (int i = 0; i < n / 2; i++) {
                for (int j = 0; j < n / 2; j++) {
                    if (i == j) continue;
                    t1 += s[first.get(i)][first.get(j)];
                    t2 += s[second.get(i)][second.get(j)];
                }
            }

            return Math.abs(t1 - t2);
        }

        int answer = -1;

        first.add(index);
        int t1 = go(index + 1);
        if (answer == -1 || (t1 != -1 && answer > t1)) {
            answer = t1;
        }
        first.remove(first.size() - 1);

        second.add(index);
        int t2 = go(index + 1);
        if (answer == -1 || (t2 != -1 && answer > t2)) {
            answer = t2;
        }
        second.remove(second.size() - 1);

        return answer;
    }
}
