package level1;

import java.util.Arrays;
import java.util.Comparator;

public class PlacingIntegersInDescendingOrder {
    public static void main(String[] args) {
        long n = 118372;

        System.out.println(solution(n));
    }

    private static long solution(long n) {
        String[] numbers = String.valueOf(n).split("");

        return Long.parseLong(Arrays.stream(numbers)
                .sorted(Comparator.reverseOrder())
                .reduce("", (a, b) -> a + b));
    }
}
