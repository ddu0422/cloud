package level1;

public class MakingWeirdWords {

    private static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) {
        String s = " abc ";

        System.out.println(solution(s));
    }

    private static String solution(String s) {
        int index = 0;
        char[] texts = s.toCharArray();

        for (char text : texts) {
            if (text == ' ') {
                index = 0;
                stringBuilder.append(" ");
                continue;
            }
            convertWord(index, text);
            index++;
        }

        return stringBuilder.toString();
    }

    private static void convertWord(int index, char text) {
        if (index % 2 == 0) {
            stringBuilder.append(String.valueOf(text).toUpperCase());
            return;
        }
        stringBuilder.append(String.valueOf(text).toLowerCase());
    }
}
