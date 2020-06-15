package baekjoon.codeplus.beginner2.bruteforce.recursion;

import java.util.Scanner;

// N과 M (2)
// 선택 관점
// M개의 수를 뽑을건데 어떤 수를 뽑을지 결정
// 시간복잡도 : 2^N

public class P15650_1 {
    private static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        a = new int[m + 1];

        // number : 실제 자연수, index : 지금까지 선택한 수
        go(1, 1, n, m);
    }

    private static void go(int number, int index, int n, int m) {
        if (index == m + 1) {
            for (int i = 1; i <= m; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
            return;
        }

        if (number > n) return;

        // 해당 수를 선택해라.
        a[index] = number;
        // 다음 수를 찾아라.
        go(number + 1, index + 1, n, m);

        // 해당 수를 선택하지 않았으면 현재 수를 다음으로 바꿔라.
        go(number + 1, index, n, m);
    }
}
