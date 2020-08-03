package level1;

public class PressKeypad {
    private static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) {
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";

        System.out.println(solution(numbers, hand));
    }

    private static String solution(int[] numbers, String hand) {
        int leftHand = 10;
        int rightHand = 12;

        for (int number : numbers) {
            if (number == 1 || number == 4 || number == 7) {
                leftHand = number;
                answer.append("L");
            } else if (number == 3 || number == 6 || number == 9) {
                rightHand = number;
                answer.append("R");
            } else {
                int leftDistance = calculateDistance(leftHand, number);
                int rightDistance = calculateDistance(rightHand, number);
                int calculate = leftDistance - rightDistance;

                if (calculate == 0) {
                    if ("right".equals(hand)) {
                        rightHand = number;
                        answer.append("R");
                    } else {
                        leftHand = number;
                        answer.append("L");
                    }
                } else if (calculate > 0) {
                    rightHand = number;
                    answer.append("R");
                } else {
                    leftHand = number;
                    answer.append("L");
                }
            }
        }

        return answer.toString();
    }

    private static int calculateDistance(int current, int number) {
        int x = 0;
        int y = calculateY(current);
        int numberX = 1;
        int numberY = calculateY(number);

        if (current == 2 || current == 5 || current == 8 || current == 0) {
            x = 1;
        }

        return numberX - x + Math.abs(y - numberY);
    }

    private static int calculateY(int number) {
        return number == 0 ? 4 : (number - 1) / 3 + 1;
    }
}
