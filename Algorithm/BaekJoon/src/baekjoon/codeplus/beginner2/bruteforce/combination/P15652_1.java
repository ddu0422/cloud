package baekjoon.codeplus.beginner2.bruteforce.combination;

// N과 M (4)
// 선택
// 중복 가능
// 비내림차순
// 시간복잡도 : 2^N

import java.util.Scanner;

public class P15652_1 {
    private static StringBuilder stringBuilder = new StringBuilder();
    private static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        a = new int[n + 1];

        go(1, 1, n, m);
        System.out.print(stringBuilder.toString());
    }

    private static void go(int index, int selected, int n, int m) {
        if (selected == m + 1) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= a[i]; j++) {
                    stringBuilder.append(i).append(" ");
                }
            }
            stringBuilder.append("\n");
            return;
        }

        if (index > n) return;

        // 중복 가능이므로, 몇 개를 선택할 것인가
        // 오름차순이므로 많이 들어간 것부터 1 까지 구한다.
        for (int i = m - selected + 1; i >= 1; i--) {
            // 수 i를 몇 번 포함해야하는지
            a[index] = i;
            go(index + 1, selected + i, n, m);
        }
        a[index] = 0;
        go(index + 1, selected, n, m);
    }
}
