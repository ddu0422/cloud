package baekjoon.codeplus.beginner2.bruteforce.recursion;

import java.util.*;

// N과 M (9)

// 1. 숫자 중복 x
// 2. 사전 순 출력
// 3. 수열의 중복 x
// 3번의 조건을 처리하기가 어려워 다른 분들의 코드를 참고했다.
// 이전의 수를 현재의 수와 비교해야하는 건 알았지만, 이전 수를 어디서 지정해야 전부 확인을 할 수 있는지 파악하지 못했다.

public class P15663 {
    private static boolean[] check;
    private static int[] numbers;
    private static int[] results;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        check = new boolean[n];
        numbers = new int[n];
        results = new int[m];

        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        Arrays.sort(numbers);

        go(0, n, m);
    }

    private static void go(int index, int n, int m) {
        if (index == m) {
            for (int result : results) {
                System.out.print(result + " ");
            }
            System.out.println();
            return;
        }

        int previousNumber = -1;

        for (int i = 0; i < n; i++) {
            if (check[i] || previousNumber == numbers[i]) {
                continue;
            }

            check[i] = true;
            results[index] = numbers[i];
            previousNumber = numbers[i];
            go(index + 1, n, m);
            check[i] = false;
        }
    }
}
