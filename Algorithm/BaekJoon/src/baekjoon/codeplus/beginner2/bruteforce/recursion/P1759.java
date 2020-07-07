package baekjoon.codeplus.beginner2.bruteforce.recursion;

import java.util.Arrays;
import java.util.Scanner;

// 암호 만들기
// 1. 조건
//   1-1. 몇글자 password를 만들것인가
//   1-2. 현재 password는 무엇인가
//   1-3. 어떤 알파벳을 사용할 수 있는가
//   1-4. 어떤 알파벳을 선택할 것인가
// 2. 종료 조건
//   2-1. 현재 password와 l이 동일
//   2-2. 확인 => 모음 1개 이상, 자음 2개 이상
// 3. 불가 조건
//   3-1. password가 l과 다를 경우
//   3-2. password가 완성되지 않았을 때, 더 이상 선택할 수 있는 알파벳이 없는 경우
// 4. 다음 조건
//   4-1. 현재 알파벳을 선택한다.
//   4-2. 현재 알파벳을 선택하지 않는다.

public class P1759 {
    private static int l = 0;
    private static char[] alpha;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        l = scanner.nextInt();
        int c = scanner.nextInt();
        scanner.nextLine();
        String[] text = scanner.nextLine().split(" ");
        alpha = new char[c];

        for (int i = 0; i < c; i++) {
            alpha[i] = text[i].charAt(0);
        }

        Arrays.sort(alpha);

        go("", 0);
    }

    private static void go(String password, int index) {
        if (password.length() == l) {
            if (check(password)) {
                System.out.println(password);
            }
            return;
        }

        if (index >= alpha.length) {
            return;
        }

        go(password + alpha[index], index + 1);
        go( password, index + 1);
    }

    private static boolean check(String password) {
        int consonants = 0;
        int vowels = 0;

        for (char c : password.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                vowels++;
            } else {
                consonants++;
            }
        }

        return consonants >= 2 && vowels >= 1;
    }
}
