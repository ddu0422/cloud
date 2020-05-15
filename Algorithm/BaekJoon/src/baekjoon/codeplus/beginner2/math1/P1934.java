package baekjoon.codeplus.beginner2.math1;

import java.util.Scanner;

// 최소공배수는 = A * B / 최대공약수
// 최대공약수는 유클리드호제법을 이용 [반복문으로 풀이]

public class P1934 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        while (t-- > 0) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            System.out.println(a * b / gcd(a, b));
        }
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }

        return a;
    }
}
