package level1;

public class ConvertStringToInteger {
    public static void main(String[] args) {
        String s = "1234";

        System.out.println(solution(s));
    }

    private static int solution(String s) {
        // parseInt()는 10진수로 이루어진 수를 바꿔준다. 맨 앞에 부호(+, -)가 있다면 알아서 계산해준다.
        // if (s.charAt(0) == '+') {
        //     return Integer.parseInt(s.substring(1));
        // }

        return Integer.parseInt(s);
    }
}
