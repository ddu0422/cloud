package level1;

// 잃어버리지 않고 여분의 옷이 없는 경우: 0
// 잃어버린 옷이 있는 경우: 1
// 여분의 옷이 있는 경우: 2
// 여분의 옷이 있는 아이가 도난 당한 경우: 3
public class GymSuit {
    public static void main(String[] args) {
        int n = 5;
        int[] lost = {2, 3, 5};
        int[] reserve = {5};

        System.out.println(solution(n, lost, reserve));
    }

    private static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] states = new int[n + 1];

        for (int value : lost) {
            states[value] = 1;
        }

        for (int value : reserve) {
            if (states[value] == 1) {
                states[value] = 3;
                continue;
            }
            states[value] = 2;
        }

        for (int i = 1; i < states.length; i++) {
            if (states[i] == 1 && states[i - 1] == 2) {
                states[i - 1] = 0;
                states[i] = 0;
            }

            if (i + 1 < states.length && states[i] == 1 && states[i + 1] == 2) {
                states[i + 1] = 0;
                states[i] = 0;
            }
        }

        for (int i = 1; i < states.length; i++) {
            if (states[i] != 1) {
                answer++;
            }
        }

        return answer;
    }
}
