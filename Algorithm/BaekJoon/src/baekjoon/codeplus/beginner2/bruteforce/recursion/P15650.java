package baekjoon.codeplus.beginner2.bruteforce.recursion;

import java.util.Scanner;

// N과 M (2)
// 순열 관점
// 1. 중복없는 순열
// 2. 오름차순
// 3.
/*      3 2
    ex) 1 2
        1 3
        2 3
 */
// 시간복잡도 : N!

public class P15650 {
    private static boolean[] check;
    private static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        check = new boolean[n + 1];
        a = new int[m + 1];

        go(1, 1, n, m);
    }

    private static void go(int index, int start, int n, int m) {
        if (index == m + 1) {
            for (int i = 1; i <= m; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i <= n; i++) {
            // 오름차순을 추가하면 check 배열이 필요없다.
            if (check[i]) {
                continue;
            }

            check[i] = true;
            a[index] = i;
            go(index + 1, i + 1, n , m);
            check[i] = false;
        }
    }
}
