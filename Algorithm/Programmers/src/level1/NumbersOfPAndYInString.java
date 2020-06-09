package level1;

public class NumbersOfPAndYInString {
    public static void main(String[] args) {
        String s = "PYyp";

        System.out.println(solution(s));
    }

    private static boolean solution(String s) {
        int p = 0;
        int y = 0;

        for (char c : s.toLowerCase().toCharArray()) {
            if (c == 'p') p++;
            if (c == 'y') y++;
        }

        return p == y;

        // String str = s.toLowerCase();
        // return countCharacters(str, 'p') == countCharacters(str, 'y');
    }

//    private static long countCharacters(String s, char c) {
//        return s.chars().filter(value -> value == c).count();
//    }
}
