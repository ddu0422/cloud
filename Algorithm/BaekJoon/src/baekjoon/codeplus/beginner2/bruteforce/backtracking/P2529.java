package baekjoon.codeplus.beginner2.bruteforce.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class P2529 {
    private static List<String> numbers = new ArrayList<>();
    private static boolean[] check = new boolean[10];
    private static int n;
    private static String[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        a = new String[n];

        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }

        go(0, "");

        Collections.sort(numbers);

        System.out.println(numbers.get(numbers.size() - 1));
        System.out.println(numbers.get(0));
    }

    private static void go(int index, String number) {
        if (index == n + 1) {
            numbers.add(number);
            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (check[i]) {
                continue;
            }

            if (index == 0 || good(number.charAt(index - 1), (char) (i + '0'), a[index - 1].charAt(0))) {
                check[i] = true;
                go(index + 1, number + i);
                check[i] = false;
            }
        }
    }

    private static boolean good(char x, char y, char operator) {
        if (operator == '<' && x < y) {
            return true;
        }

        if (operator == '>' && x > y) {
            return true;
        }

        return false;
    }
}
