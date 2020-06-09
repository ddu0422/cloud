package level1;

public class SumOfDivisor {
    private static final int LIMIT = 3_000;
    private static boolean[] check = new boolean[LIMIT + 1];

    public static void main(String[] args) {
        int n = 5;

        System.out.println(solution(n));
    }

    private static int solution(int n) {
        int answer = 0;

        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                check[i] = true;
                check[n / i] = true;
            }
        }

        for (int i = 1; i <= n; i++) {
            if (check[i]) {
                answer += i;
            }
        }

        return answer;
    }
}
