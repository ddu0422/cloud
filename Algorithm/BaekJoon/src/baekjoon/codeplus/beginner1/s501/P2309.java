package baekjoon.codeplus.beginner1.s501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P2309 {
    private static final int COUNT = 9;

    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            int[] a = new int[COUNT];
            int sum = 0;

            for (int i = 0; i < COUNT; i++) {
                a[i] = Integer.parseInt(bufferedReader.readLine());
                sum += a[i];
            }

            Arrays.sort(a);

            for (int i = 0; i < COUNT; i++) {
                for (int j = i + 1; j < COUNT; j++) {
                    if (sum - a[i] - a[j] == 100) {
                        for (int k = 0; k < COUNT; k++) {
                            // 2명을 빼야함
                            if (k == i || k == j) continue;
                            System.out.println(a[k]);
                        }
                        // 프로그램을 종료시켜야함.
                        System.exit(0);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error : " + e);
        }
    }
}
