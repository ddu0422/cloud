package level1;

public class FindingKimSeobangInSeoul {
    public static void main(String[] args) {
        String[] seoul = {"Jane", "Kim"};

        System.out.println(solution(seoul));
    }

    private static String solution(String[] seoul) {
        int answer = 0;

        for (int i = 0; i < seoul.length; i++) {
            if ("Kim".equals(seoul[i])) {
                answer = i;
                break;
            }
        }

        return "김서방은 " + answer + "에 있다";

        // 천재적인 사람들이 많다. 열공해야겠다.
        // return "김서방은 " + Arrays.asList(seoul).indexOf("Kim") + "에 있다";
    }
}
