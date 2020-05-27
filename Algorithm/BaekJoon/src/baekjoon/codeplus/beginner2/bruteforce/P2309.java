package baekjoon.codeplus.beginner2.bruteforce;

import java.util.Arrays;
import java.util.Scanner;

// 일곱 난쟁이
// a[i] : 입력으로 들어온 난쟁이의 키 값
// 9개의 입력 값이 주어지므로 2명을 제외하여 키의 합이 100을 만족하는 값을 구한다.
// 아무쌍이나 출력할 수 있기 때문에 한 번만 출력하고 종료한다.

public class P2309 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] a = new int[9];
        int sum = 0;
        boolean find = false;

        for (int i = 0; i < a.length; i++) {
            a[i] = scanner.nextInt();
            sum += a[i];
        }

        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (sum - a[i] - a[j] == 100) {
                    a[i] = 0;
                    a[j] = 0;
                    find = true;
                    break;
                }
            }
            if (find) break;
        }

        Arrays.sort(a);

        for (int i : a) {
            if (i != 0) {
                System.out.println(i);
            }
        }
    }
}
