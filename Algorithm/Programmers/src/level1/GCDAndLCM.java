package level1;

import java.util.Arrays;

public class GCDAndLCM {
    public static void main(String[] args) {
        int n = 2;
        int m = 5;

        System.out.println(Arrays.toString(solution(n, m)));
    }

    private static int[] solution(int n, int m) {
        int gcd = gcd(n, m);
        int lcm = n * m / gcd;

        return new int[]{gcd, lcm};
    }

    private static int gcd(int n, int m) {
        if (m == 0) {
            return n;
        }

        return gcd(m, n % m);
    }
}
