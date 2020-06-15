package baekjoon.codeplus.beginner2.bruteforce.recursion;

import java.util.Scanner;

// N과 M (1)
// 1. N개 중 중복 없이 M개를 뽑아야한다.
// 2. 중복 확인을 위한 배열을 생성한다.
// 3. 수열을 저장할 배열을 생성한다.
// 4. 수열을 출력한다.

public class P15649 {
    private static boolean[] check;
    private static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        check = new boolean[n + 1];
        a = new int[m + 1];

        go(1, n, m);
    }

    private static void go(int index, int n, int m) {
        if (index == m + 1) {
            for (int i = 1; i <= m; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (check[i]) {
                continue;
            }

            check[i] = true;
            a[index] = i;
            go(index + 1, n, m);
            check[i] = false;
        }
    }
}