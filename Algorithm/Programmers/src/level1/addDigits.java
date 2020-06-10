package level1;

import java.util.Arrays;

public class addDigits {
    public static void main(String[] args) {
        int n = 987;

        System.out.println(solution(n));
    }

    private static int solution(int n) {
        return Arrays.stream(String.valueOf(n).split(""))
                .mapToInt(Integer::valueOf)
                .sum();
    }
}
