package level1;

public class GetMiddleCharacter {
    public static void main(String[] args) {
        String s = "abcde";

        System.out.println(solution(s));
    }

    private static String solution(String s) {
        String answer = "";
        int length = s.length();

        if (length % 2 == 0) {
            answer += s.charAt(length / 2 - 1);
        }
        answer += s.charAt(length / 2);

        // 다른 분 풀이
        // 홀수일 경우
        // length / 2 ~ length / 2 + 1 의 값을 구해야한다.
        // length / 2 와 (length - 1) / 2 는 같으므로
        // length / 2 를 (length - 1) / 2 로 대체할 수 있다.

        // 짝수일 경우
        // length / 2 - 1 ~ length / 2 + 1 의 값을 구해야한다.
        // length / 2 - 1 와 (length - 1) / 2는 같으므로
        // length / 2 - 1 을 (length - 1) / 2로 대체할 수 있다.

        // 결론
        // s.substring((s.length() - 1) / 2, s.length() / 2 + 1);

        return answer;
    }
}
