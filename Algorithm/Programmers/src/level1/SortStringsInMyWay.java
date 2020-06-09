package level1;

import java.util.Arrays;
import java.util.Comparator;

public class SortStringsInMyWay {
    public static void main(String[] args) {
        String[] strings = {"abce", "abcd", "cdx"};
        int n = 2;

        System.out.println(Arrays.toString(solution(strings, n)));
    }

    private static String[] solution(String[] strings, int n) {
        return Arrays.stream(strings)
                .sorted()
                .sorted(Comparator.comparing(text -> text.charAt(n)))
                .toArray(String[]::new);
    }
}
