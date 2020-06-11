package level1;

import java.util.Arrays;

public class GetAverage {
    public static void main(String[] args) {
        int[] arr = {5, 5};

        System.out.println(solution(arr));
    }

    private static double solution(int[] arr) {
//        return Arrays.stream(arr)
//                .average()
//                .orElse(0);

        double answer = 0;

        for (int i : arr) {
            answer += i;
        }

        return answer / arr.length;
    }
}
