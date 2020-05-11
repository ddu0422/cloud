package baekjoon.codeplus.beginner1.s401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11053 {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            int n = Integer.parseInt(bufferedReader.readLine());
            String[] inputText = bufferedReader.readLine().split(" ");
            int[] a = new int[n];
            int[] d = new int[n];
            int answer = 0;

            for (int i = 0; i < n ; i++) {
                a[i] = Integer.parseInt(inputText[i]);
            }

            for (int i = 0; i < n; i++) {
                d[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (a[j] < a[i] && d[i] < d[j] + 1) {
                        d[i] = d[j] + 1;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                if (answer < d[i]) {
                    answer = d[i];
                }
            }

            System.out.println(answer);

        } catch (IOException e) {
            System.err.println("Error : " + e);
        }
    }
}
