package level1;

import java.util.Arrays;

public class SecretMap {
    private static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) {
        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};

        System.out.println(Arrays.toString(solution(n, arr1, arr2)));
    }

    private static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            answer[i] = binary(arr1[i] | arr2[i], n)
                    .replace("1", "#")
                    .replace("0", " ");
        }

        return answer;
    }

    private static String binary(int number, int n) {
        stringBuilder.setLength(0);

        while (number > 0) {
            stringBuilder.append(number % 2);
            number /= 2;
        }

        String binary = stringBuilder.reverse().toString();

        if (binary.length() < n) {
            stringBuilder.insert(0, "0".repeat(n - binary.length()));
        }

        return stringBuilder.toString();
    }
}
