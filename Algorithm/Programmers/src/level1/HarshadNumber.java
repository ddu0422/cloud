package level1;

public class HarshadNumber {
    public static void main(String[] args) {
        int x = 11;

        System.out.println(solution(x));
    }

    private static boolean solution(int x) {
        return x % addDigit(x) == 0;
    }

    private static int addDigit(int x) {
        int sum = 0;

        while (x != 0) {
            sum += x % 10;
            x /= 10;
        }

        return sum;
    }
}
