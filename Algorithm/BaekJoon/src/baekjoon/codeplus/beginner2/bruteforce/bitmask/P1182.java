package baekjoon.codeplus.beginner2.bruteforce.bitmask;

import java.util.Scanner;

public class P1182 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int[] arr = new int[n];
        int answer = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        for (int i = 1; i < (1 << n); i++) {
            int sum = 0;

            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    sum += arr[j];
                }
            }

            if (sum == s) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
