package baekjoon.codeplus.beginner1.s502;

import java.util.Scanner;

public class P15652 {
    private static StringBuilder stringBuilder = new StringBuilder();
    // 수 i를 몇번 포함
    private static int[] cnt = new int[10];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        go(1, 0, scanner.nextInt(), scanner.nextInt());
        System.out.println(stringBuilder.toString());
    }

    private static void go(int index, int selected, int n, int m) {
        if (selected == m) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= cnt[i]; j++) {
                    stringBuilder.append(i).append(" ");
                }
            }
            stringBuilder.append("\n");
            return;
        }

        if (index > n) return;

        for (int i = m - selected; i >= 1; i--) {
            cnt[index] = i;
            go(index + 1, selected + i, n, m);
        }
        cnt[index] = 0;
        go(index + 1, selected, n, m);
    }
}
