package level1;

public class StringHandlingBasics {
    private static final char ZERO = '0';
    private static final char NINE = '9';

    public static void main(String[] args) {
        String s = "12345";

        System.out.println(solution(s));
    }

    private static boolean solution(String s) {
        long a = s.chars().filter(StringHandlingBasics::isNumber).count();

        return a == (long) s.length() && (a == 4 || a == 6);
    }

    private static boolean isNumber(int value) {
        return value >= ZERO && value <= NINE;
    }
}
