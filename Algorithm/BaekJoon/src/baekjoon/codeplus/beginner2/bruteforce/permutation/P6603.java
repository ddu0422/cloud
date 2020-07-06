package baekjoon.codeplus.beginner2.bruteforce.permutation;

import java.util.Scanner;

// 로또
// 1. 모든 순열을 구한다. (선택은 0, 선택하지 않으면 1)
// 2. 선택한 숫자를 출력한다.

public class P6603 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int k = scanner.nextInt();

            if (k == 0) {
                break;
            }

            int[] s = new int[k];
            int[] select = new int[k];

            for (int i = 0; i < k; i++) {
                s[i] = scanner.nextInt();
            }

            for (int i = 6; i < k; i++) {
                select[i] = 1;
            }

            do {
                for (int i = 0; i < k; i++) {
                    if (select[i] == 0) {
                        System.out.print(s[i] + " ");
                    }
                }
                System.out.println();
            } while (nextPermutation(select));
            System.out.println();
        }
    }

    private static boolean nextPermutation(int[] select) {
        int i = select.length - 1;
        int j = select.length - 1;

        while (i > 0 && select[i - 1] >= select[i]) {
            i--;
        }

        if (i <= 0) {
            return false;
        }

        while (select[i - 1] >= select[j]) {
            j--;
        }

        swap(select, i - 1, j);

        j = select.length - 1;

        while (i < j) {
            swap(select, i, j);
            i++;
            j--;
        }

        return true;
    }

    private static void swap(int[] select, int i, int j) {
        int temp = select[i];
        select[i] = select[j];
        select[j] = temp;
    }
}
