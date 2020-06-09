package level1;

public class CaesarCipher {
    private static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) {
        String s = "a B z";
        int n = 4;

        System.out.println(solution(s, n));
    }

    private static String solution(String s, int n) {
        char[] texts = s.toCharArray();

        for (char text : texts) {
            if (text >= 'a' && text <= 'z') {  // Character.isLowerCase(text)
                encrypt(n, text, 'a');
            } else if (text >= 'A' && text <= 'Z') { // Character.isUpperCase(text)
                encrypt(n, text, 'A');
            } else {
                answer.append(text);
            }
        }

        return answer.toString();
    }

    private static void encrypt(int n, char text, char alpha) {
        answer.append((char) ((text - alpha + n) % 26 + alpha));
    }
}
