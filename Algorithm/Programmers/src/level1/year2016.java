package level1;

public class year2016 {
    public static void main(String[] args) {
        int a = 5;
        int b = 24;

        System.out.println(solution(a, b));
    }

    private static String solution(int a, int b) {
        String[] dayOfTheWeek = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
        int[] days = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int total = b;

        for (int i = 0; i < a; i++) {
            total += days[i];
        }

        return dayOfTheWeek[total % 7];
    }
}
