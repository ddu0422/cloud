package baekjoon.codeplus.beginner2.bruteforce;

import java.util.Scanner;

// 사탕 게임
// 1. 인접한 두 칸을 고르고 교환을 한다.
// 2. 인접해있기 때문에 오른쪽, 아래쪽으로만 교환해도 된다.
// 3. 교환 후 가장 긴 길이를 찾는다.

public class P3085 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        char[][] a = new char[n][n];
        int answer = 0;

        for (int i = 0; i < a.length; i++) {
            a[i] = scanner.next().toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                // 오른쪽으로 이동
                if (j + 1 < n) {
                    char t = a[i][j];
                    a[i][j] = a[i][j + 1];
                    a[i][j + 1] = t;

                    int temp = check(a);
                    if (answer < temp) answer = temp;

                    t = a[i][j];
                    a[i][j] = a[i][j + 1];
                    a[i][j + 1] = t;
                }

                // 아래쪽으로 이동
                if (i + 1 < n) {
                    char t = a[i][j];
                    a[i][j] = a[i + 1][j];
                    a[i + 1][j] = t;

                    int temp = check(a);
                    if (answer < temp) answer = temp;

                    t = a[i][j];
                    a[i][j] = a[i + 1][j];
                    a[i + 1][j] = t;
                }
            }
        }

        System.out.println(answer);
    }

    private static int check(char[][] a) {
        int n = a.length;
        int answer = 1;

        for (int i = 0; i < n; i++) {
            int cnt = 1;

            // 행 검사
            for (int j = 1; j < n; j++) {
                if (a[i][j] == a[i][j - 1]) {
                    cnt += 1;
                } else {
                    cnt = 1;
                }
                if (answer < cnt) answer = cnt;
            }

            cnt = 1;

            // 열 검사
            for (int j = 1; j < n; j++) {
                if (a[j][i] == a[j - 1][i]) {
                    cnt += 1;
                } else {
                    cnt = 1;
                }
                if (answer < cnt) answer = cnt;
            }
        }

        return answer;
    }
}
