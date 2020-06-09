package level1;

public class RepeatWaterMelon {
    public static void main(String[] args) {
        int n = 3;

        System.out.println(solution(n));
    }

    private static String solution(int n) {
//        StringBuilder stringBuilder = new StringBuilder();
//        String[] waterMelon = {"수", "박"};
//
//        for (int i = 0; i < n; i++) {
//            stringBuilder.append(waterMelon[i % 2]);
//        }
//
//        return stringBuilder.toString();

        // since 11
        return "수박".repeat((n + 1) / 2).substring(0, n);
    }
}
