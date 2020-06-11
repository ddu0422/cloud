package level1;

public class CollatzConjecture {
    public static void main(String[] args) {
        int num = 626331;

        System.out.println(solution(num));
    }

    private static int solution(int num) {
        long answer = num;

        for (int i = 0; i < 500; i++) {
            if (answer == 1) {
                return i;
            }

            if (answer % 2 == 0) {
                answer /= 2;
                continue;
            }

            answer = answer * 3 + 1;
        }

        return -1;
    }
}
