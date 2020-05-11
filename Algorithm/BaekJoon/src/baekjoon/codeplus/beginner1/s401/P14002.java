package baekjoon.codeplus.beginner1.s401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P14002 {
    private static int[] d;
    private static int[] a;
    private static int[] v;

    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            // 입력
            int n = Integer.parseInt(bufferedReader.readLine());
            String[] inputText = bufferedReader.readLine().split(" ");

            // 초기화
            d = new int[n];
            a = new int[n];
            v  = new int[n];
            int answer = 0; // 길이
            int index = 0; // 해당 길이일 때 몇번째 index인지

            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputText[i]);
            }

            // 문제풀이
            for (int i = 0; i < n; i++) {
                d[i] = 1;
                v[i] = -1;
                for (int j = 0; j < i; j++) {
                    if (a[j] < a[i] && d[i] < d[j] + 1) {
                        d[i] = d[j] + 1;
                        v[i] = j;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                if (answer < d[i]) {
                    answer = d[i];
                    index = i;
                }
            }

            System.out.println(answer);
            go(index);

        } catch (IOException e) {
            System.err.println("Error : " + e);
        }
    }

    private static void go(int n) {
        if (n == -1) return;

        go(v[n]);
        System.out.print(a[n] + " ");
    }
}
