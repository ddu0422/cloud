package level1;

public class SumBetweenTwoIntegers {
    public static void main(String[] args) {
        int a = 3;
        int b = -100;

        System.out.println(solution(a, b));
    }

    private static long solution(int a, int b) {
        long n = Math.abs(b - a) + 1;

        return n * (a + b) / 2L;
    }
}
