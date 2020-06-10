package level1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class InvertNaturalNumbersIntoArrays {
    public static void main(String[] args) {
        long n = 10_000_000_000L;

        System.out.println(Arrays.toString(solution(n)));
    }

    private static int[] solution(long n) {
        List<Long> lists = new LinkedList<>();

        while (n != 0) {
            lists.add(n % 10L);
            n /= 10L;
        }

        return lists.stream()
                .mapToInt(Long::intValue)
                .toArray();
    }
}
