package level1;

import java.util.Arrays;
import java.util.Comparator;

public class PlacingStringsInDescendingOrder {
    public static void main(String[] args) {
        String s = "ZAbcdefg";
        System.out.println(solution(s));
    }

    private static String solution(String s) {
        StringBuilder stringBuilder = new StringBuilder();

        Arrays.stream(s.split(""))
                .map(value -> value.charAt(0)) // 불필요한 동작. reverseOrder 자체에서 비교
                .sorted(Comparator.reverseOrder())
                .forEach(stringBuilder::append);

        return stringBuilder.toString();

        // String을 만들경우에는 Collectors.joining()을 활용하자.
        // return Arrays.stream(s.split(""))
        //                .sorted(Comparator.reverseOrder())
        //                .collect(Collectors.joining());
    }
}
