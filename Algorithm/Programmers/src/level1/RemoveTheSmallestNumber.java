package level1;

import java.util.Arrays;

public class RemoveTheSmallestNumber {
    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4};

        System.out.println(Arrays.toString(solution(arr)));
    }

    private static int[] solution(int[] arr) {
        int[] answer = new int[arr.length - 1];

        // 제거
        int min = arr[0];
        int minValueIndex = 0;
        int index = 0;

        for (int i = 0; i < arr.length; i++) {
            // if (arr[minValueIndex] > arr[i])
            if (min > arr[i]) {
                min = arr[i]; // 불필요
                minValueIndex = i;
            }
        }

        for (int i = 0; i < arr.length; i++, index++) {
            if (i == minValueIndex) {
                index--;
                continue;
            }
            answer[index] = arr[i];
        }

        return answer.length != 0 ? answer : new int[]{-1};
    }
}
