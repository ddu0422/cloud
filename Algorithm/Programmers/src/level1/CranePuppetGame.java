package level1;

import java.util.Stack;

public class CranePuppetGame {
    public static void main(String[] args) {
        int[][] board = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 3},
                {0, 2, 5, 0, 1},
                {4, 2, 4, 4, 2},
                {3, 5, 1, 3, 1}
        };

        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};

        System.out.println(solution(board, moves));
    }

    private static int solution(int[][] board, int[] moves) {
        Stack<Integer> baskets = new Stack<>();
        int answer = 0;

        for (int move : moves) {
            for (int j = 0; j < board.length; j++) {
                int dollNumber = board[j][move - 1];

                if (dollNumber != 0) {
                    if (!baskets.isEmpty() && baskets.peek() == dollNumber) {
                        baskets.pop();
                        answer += 2;
                    } else {
                        baskets.add(dollNumber);
                    }
                    board[j][move - 1] = 0;
                    break;
                }
            }
        }

        return answer;
    }
}
