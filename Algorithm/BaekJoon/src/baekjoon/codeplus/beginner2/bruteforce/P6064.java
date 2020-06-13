package baekjoon.codeplus.beginner2.bruteforce;

import java.util.Scanner;

// 카잉 달력
// 1. i = x 로 놓는다.
// 2. x += m 을 해준다면 x의 끝자리에서 출발하기 때문에 x를 만족할 때의 y 값을 구하면 된다.

public class P6064 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = scanner.nextInt();

        while (count-- > 0) {
            int answer = -1;
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            for (int i = x; i <= m * n; i += m) {
                if ((i - 1) % n == y - 1) {
                    answer = i;
                    break;
                }
            }

            System.out.println(answer);
        }
    }
}
