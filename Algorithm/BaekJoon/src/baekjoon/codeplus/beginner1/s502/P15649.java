package baekjoon.codeplus.beginner1.s502;

import java.util.Scanner;

public class P15649 {
    private static boolean[] c = new boolean[9];
    private static int[] a = new int[9];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 첫 자리 index는 0
        go(0, scanner.nextInt(), scanner.nextInt());
    }

    private static void go(int index, int n, int m) {
        // 수열 출력
        if (index == m) {
            for (int i : a) {
                if (i != 0) System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++) {
            // 이전에 숫자를 씀
            if (c[i]) continue;
            // 지금 숫자를 씀
            c[i] = true;
            a[index] = i;
            // 재귀로 확인
            go(index + 1, n, m);
            // 끝나면 전부다 false로
            c[i] = false;
        }
    }
}
