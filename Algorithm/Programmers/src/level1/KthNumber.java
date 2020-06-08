package level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KthNumber {
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {
                {2, 5, 3},
                {4, 4, 1},
                {1, 7, 3}
        };

        System.out.println(Arrays.toString(solution(array, commands)));
    }

    private static int[] solution(int[] array, int[][] commands) {
        List<Integer> temps = new ArrayList<>();

        for (int[] command : commands) {
            int[] temp = Arrays.copyOfRange(array, command[0] - 1, command[1]);
            Arrays.sort(temp);
            temps.add(temp[command[2] - 1]);
        }

        int[] answer = new int[temps.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = temps.get(i);
        }

        return answer;
    }
}
