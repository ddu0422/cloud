package baekjoon.codeplus.beginner2.math1;

import java.util.Scanner;

// 최대공약수는 유클리드호제법을 이용해서 구한다.
// GCD(a, b) = GCD (b, r) [재귀를 이용해서 풀이]
// 최소공배수는 a * b / GCD 이므로 최대공약수를 이용해서 구한다.

public class P2609 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int gcd = gcd(a, b);

        System.out.println(gcd);
        System.out.println(a * b / gcd);
    }

    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
