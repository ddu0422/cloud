package baekjoon.codeplus.beginner1.s502;

import java.util.Scanner;

// 중복 x
// 오름차순
// 선택 문제

public class P15650 {
//    // 순서로 생각 O(N!)
//    private static boolean[] c = new boolean[10];
//    private static int[] a = new int[10];
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        int n = scanner.nextInt();
//        int m = scanner.nextInt();
//
//        // 첫 자리 index는 0 첫 숫자는 1
//        go(0, 1, n, m);
//    }
//
//    private static void go(int index, int start, int n, int m) {
//        if (index == m) {
//            for (int i : a) {
//                if (i != 0) System.out.print(i + " ");
//            }
//            System.out.println();
//            return;
//        }
//
//        for (int i = start; i <= n; i++) {
//            if (c[i]) continue;
//            c[i] = true;
//            a[index] = i;
//            go(index + 1, i + 1, n, m);
//            c[i] = false;
//        }
//    }

    // 선택으로 생각 O(2^N)
    private static int[] a = new int[10];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 여기서 의미하는 index는 숫자를 의미, selected는 숫자가 선택된 개수를 의미
        go(1, 0, scanner.nextInt(), scanner.nextInt());
    }

    private static void go(int index, int selected, int n, int m) {
        // m개가 선택이 되면 멈춘다.
        if (selected == m) {
            for (int i : a) {
                if (i != 0) System.out.print(i + " ");
            }
            System.out.println();
            return;
        }
        // 아무것도 선택을 안한 경우에는 index가 n보다 커질 수 있다.
        if (index > n) return;

        // index를 결과에 추가
        a[selected] = index;
        go(index + 1, selected + 1, n, m);

        // index를 결과에 추가하지 않음
        a[selected] = 0;
        go(index + 1, selected, n, m);
    }
}
