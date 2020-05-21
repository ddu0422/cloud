package baekjoon.codeplus.beginner2.dp;

import java.util.Scanner;

// 가장 긴 바이토닉 부분 수열
// d[n] = d1[n] + d2[n] - 1
// 1. 바이토닉 : 오름차순 -> 내림차순을 만족하는 수열
// 2. d[n] : 가장 긴 바이토닉 부분 수열의 길이
// 3. d1[n] : 오름차순 부분 수열의 길이
// 4. d2[n] : 내림차순 부분 수열의 길이
// 5. 오름차순, 내림차순으로 바뀔 때 길이 1 중복

public class P11054 {
    private static int[] d1;
    private static int[] d2;
    private static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        d1 = new int[n + 1];
        d2 = new int[n + 1];
        a = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            d1[i] = 1;
            for (int j = 1; j <= n; j++) {
                if (a[j] < a[i] && d1[i] < d1[j] + 1) {
                    d1[i] = d1[j] + 1;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            d2[i] = 1;
        }

        // 앞에서부터 진행하면 거꾸로 추적해야한다.
        // 고정 시킬 i, 움직일 j
        // i는 오른쪽에서 왼쪽으로 이동 [0 까지]
        // j는 i보다 크고 왼쪽에서 오른쪽으로 이동 [n 까지]
        for (int i = n; i > 0; i--) {
            for (int j = i + 1; j <= n ; j++) {
                if (a[j] < a[i] && d2[i] < d2[j] + 1) {
                    d2[i] = d2[j] + 1;
                }
            }
        }

        int answer = d1[1] + d2[1] - 1;

        for (int i = 1; i <= n; i++) {
            answer = Math.max(answer, d1[i] + d2[i] - 1);
        }

        System.out.println(answer);
    }
}
