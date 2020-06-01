package baekjoon.codeplus.beginner2.bruteforce;

import java.util.Scanner;

// 날짜 게산
// 1. e, s, m 을 만족하는 years를 구해야한다.
// 2. e는 15진수, s는 28진수, m은 19진수로 생각한다.

public class P1476 {
    private static final int E = 15;
    private static final int S = 28;
    private static final int M = 19;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int e = scanner.nextInt() - 1;
        int s = scanner.nextInt() - 1;
        int m = scanner.nextInt() - 1;
        int years = 1;

        while (true) {
            if (e == (years - 1) % E && s == (years - 1) % S && m == (years - 1) % M) {
                System.out.println(years);
                break;
            }
            years++;
        }
    }
}
