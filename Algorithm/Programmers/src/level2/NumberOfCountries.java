package level2;

public class NumberOfCountries {
    public static void main(String[] args) {
        int n = 18;

        System.out.println(solution(n));
    }

    private static String solution(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        int[] numbers = {4, 1, 2};

        while (n != 0) {
            stringBuilder.append(numbers[n % 3]);
            n = (n - 1) / 3;
        }

        return stringBuilder.reverse().toString();
    }
}
