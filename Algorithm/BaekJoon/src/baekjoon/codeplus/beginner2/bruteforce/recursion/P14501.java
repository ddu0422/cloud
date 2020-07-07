package baekjoon.codeplus.beginner2.bruteforce.recursion;

import java.util.Scanner;

// 퇴사
// 1. 변화가 없는 친구들은 필드로 뺀다.

public class P14501 {
    private static int[] t;
    private static int[] p;
    private static int max = 0;
    private static int n = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        t = new int[n];
        p = new int[n];

        for (int i = 0; i < n; i++) {
            t[i] = scanner.nextInt();
            p[i] = scanner.nextInt();
        }

        go(0, 0);

        System.out.println(max);
    }

    private static void go(int day, int sum) {
        if (day == n) {
            if (max < sum) {
                max = sum;
            }
            return;
        }

        if (day > n) {
            return;
        }

        go( day + t[day], sum + p[day]);
        go( day + 1, sum);
    }
}
