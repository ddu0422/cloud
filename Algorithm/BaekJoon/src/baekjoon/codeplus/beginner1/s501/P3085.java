package baekjoon.codeplus.beginner1.s501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P3085 {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            int n = Integer.parseInt(bufferedReader.readLine());
            char[][] a = new char[n][n];
            int answer = 0;

            for (int i = 0; i < n; i++) {
                a[i] = bufferedReader.readLine().toCharArray();
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n - 1; j++) {
                    // 오른쪽으로 바꾸는 경우
                    if (j + 1 < n) {
                        char temp = a[i][j];
                        a[i][j] = a[i][j + 1];
                        a[i][j + 1] = temp;

                        int temp2 = check(a);
                        if (answer < temp2) answer = temp2;

                        a[i][j + 1] = a[i][j];
                        a[i][j] = temp;
                    }

                    // 아래로 바꾸는 경우
                    if (i + 1 < n) {
                        char temp = a[i][j];
                        a[i][j] = a[i + 1][j];
                        a[i + 1][j] = temp;

                        int temp2 = check(a);
                        if (answer < temp2) answer = temp2;

                        a[i + 1][j] = a[i][j];
                        a[i][j] = temp;
                    }
                }
            }

            System.out.println(answer);

        } catch (IOException e) {
            System.err.println("Error : " + e);
        }
    }

    private static int check(char[][] a) {
        int n = a.length;
        int answer = 1;

        for (int i = 0; i < n; i++) {
            // i행
            int cnt = 1;
            for (int j = 1; j < n; j++) {
                if (a[i][j] == a[i][j - 1]) {
                    cnt += 1;
                } else {
                    cnt = 1;
                }
                if (answer < cnt) answer = cnt;
            }

            // i열
            cnt = 1;
            for (int j = 1; j < n; j++) {
                if (a[j][i] == a[j - 1][i]) {
                    cnt += 1;
                } else {
                    cnt = 1;
                }
            }
            if (answer < cnt) answer = cnt;
        }

        return answer;
    }
}
