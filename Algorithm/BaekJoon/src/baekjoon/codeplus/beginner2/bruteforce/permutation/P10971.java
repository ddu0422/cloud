package baekjoon.codeplus.beginner2.bruteforce.permutation;

import java.util.Scanner;

// 외판원 순회 2
// 1. 모든 수열을 찾는다.
// 2. 각 수열의 최소값을 찾는다.

public class P10971 {

    private static final int FIRST_VILLAGE = 0;
    private static final int MAX_VALUE = 10 * 1_000_000 + 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] a = new int[n];
        int[][] p = new int[n][n];

        for (int i = FIRST_VILLAGE; i < n; i++) {
            a[i] = i;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                p[i][j] = scanner.nextInt();
            }
        }

        int min = MAX_VALUE;

        do {
            // 중복제거
            // 1 -> 2 -> 3 -> 4 의 경우와 2 -> 3 -> 4 -> 1, 3 -> 4 -> 1 -> 2, 4 -> 1 -> 2 -> 3의 경우는 모두 동일하므로
            // 1로 고정해놓고 풀면 중복을 제거할 수 있다.
            if (a[0] != FIRST_VILLAGE) {
                break;
            }

            if (canMove(p, a)) {
                min = Math.min(min, calculate(p, a));
            }
        } while (nextPermutation(a));

        System.out.println(min);
    }

    private static boolean canMove(int[][] p, int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (p[a[i]][a[(i + 1) % a.length]] == 0) {
                return false;
            }
        }

        return true;
    }

    private static int calculate(int[][] p, int[] a) {
        int sum = 0;

        for (int i = 0; i < p.length; i++) {
            sum += p[a[i]][a[(i + 1) % a.length]];
        }

        return sum;
    }

    private static boolean nextPermutation(int[] a) {
        int i = a.length - 1;
        int j = a.length - 1;

        while (i > 0 && a[i - 1] >= a[i]) {
            i--;
        }

        if (i <= 0) {
            return false;
        }

        while (a[i - 1] >= a[j]) {
            j--;
        }

        swap(a, i - 1, j);

        j = a.length - 1;

        while (i < j) {
            swap(a, i, j);
            i++;
            j--;
        }

        return true;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}