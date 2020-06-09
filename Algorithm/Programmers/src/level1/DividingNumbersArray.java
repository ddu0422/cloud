package level1;

import java.util.Arrays;

public class DividingNumbersArray {
    public static void main(String[] args) {
        int[] arr = {3,2,6};
        int divisor = 10;

        System.out.println(Arrays.toString(solution(arr, divisor)));
    }

    private static int[] solution(int[] arr, int divisor) {
        int[] answer = Arrays.stream(arr)
                .filter((value) -> divisible(divisor, value))
                .sorted()
                .toArray();

        return answer.length > 0 ? answer : new int[]{-1};
    }

    private static boolean divisible(int divisor, int value) {
        return value % divisor == 0;
    }
}
