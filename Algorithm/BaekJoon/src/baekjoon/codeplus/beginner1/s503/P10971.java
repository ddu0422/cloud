package baekjoon.codeplus.beginner1.s503;

import java.util.Scanner;

public class P10971 {
    // 방문순서
    private static int[] d;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] w = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                w[i][j] = scanner.nextInt();
            }
        }

        d = new int[n];
        for (int i = 0; i < n; i++) {
            d[i] = i;
        }

        int answer = Integer.MAX_VALUE;

        do {
            // 1로 고정하기 위해서
            if (d[0] != 0) break;
            // 갈 수 있으면 true 없으면 false
            boolean ok = true;
            // 비용의 합계
            int sum = 0;

            for (int i = 0; i < n - 1; i++) {
                // 비용이 0이라면 갈 수 없음
                if (w[d[i]][d[i + 1]] == 0) {
                    ok = false;
                } else {
                    // 비용이 0이 아니라면 sum에 더해라
                    sum += w[d[i]][d[i + 1]];
                }
            }

            // 갈 수 있다(비대칭이기 때문에 확인해야한다.) && 되돌아오는 비용이 0이 아니다.
            if (ok && w[d[n - 1]][d[0]] != 0) {
                sum += w[d[n - 1]][d[0]];
                if (answer > sum) {
                    answer = sum;
                }
            }
        } while (nextPermutation(n));

        System.out.println(answer);
    }

    private static boolean nextPermutation(int n) {
        // 1번 : a[i - 1] < a[i] 를 만족하는 i중 가장 큰 값
        int i = n - 1;
        while (i > 0 && d[i - 1] >= d[i]) {
            i -= 1;
        }

        if (i <= 0) return false; // 마지막 순열 !!

        // 2번 a[i - 1] < a[j]를 만족하는 j중 가장 큰 값
        int j = n - 1;
        while (d[j] <= d[i - 1]) {
            j -= 1;
        }

        // 3번 자리 바꿈 (swap)
        int temp = d[i - 1];
        d[i - 1] = d[j];
        d[j] = temp;

        // 4번 a[i] 뒤 쪽을 뒤집는다.
        j = n - 1;
        while (i < j) {
            int temp1 = d[i];
            d[i] = d[j];
            d[j] = temp1;
            i += 1;
            j -= 1;
        }

        return true;
    }
}
