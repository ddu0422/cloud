package level1;

public class DartGame {
    public static void main(String[] args) {
        String dartResult = "10D2S#10S";

        System.out.println(solution(dartResult));
    }

    private static int solution(String dartResult) {
        int[] result = new int[3];
        int index = -1;
        char[] c = dartResult.toCharArray();

        for (int i = 0; i < c.length; i++) {
            char temp = c[i];

            if (Character.isDigit(temp)) {
                if (i > 0 && Character.isDigit(c[i - 1])) {
                    result[index] *= 10;
                    continue;
                }
                result[++index] = temp - '0';
            } else if (Character.isAlphabetic(temp)) {
                calculatePowerWithText(result, index, temp);
            } else {
                calculateSpecialSymbol(result, index, temp);
            }
        }

        int sum = 0;

        for (int i : result) {
            sum += i;
        }

        return sum;
    }

    private static void calculatePowerWithText(int[] result, int index, char temp) {
        switch (temp) {
            case 'S':
                break;
            case 'D':
                result[index] = (int) Math.pow(result[index], 2);
                break;
            case 'T':
                result[index] = (int) Math.pow(result[index], 3);
                break;
        }
    }

    private static void calculateSpecialSymbol(int[] result, int index, char temp) {
        switch (temp) {
            case '*':
                if (index != 0) {
                    result[index - 1] *= 2;
                }
                result[index] *= 2;
                break;
            case '#':
                result[index] *= -1;
                break;
        }
    }
}
