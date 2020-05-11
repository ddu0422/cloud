package baekjoon.codeplus.beginner1.s501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//public class P1107 {
//    private static boolean[] broken = new boolean[10];
//
//    public static void main(String[] args) {
//        try {
//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//            int n = Integer.parseInt(bufferedReader.readLine());
//            int m = Integer.parseInt(bufferedReader.readLine());
//            String[] inputText = bufferedReader.readLine().split(" ");
//
//            // 고장났다.
//            for (int i = 0; i < m; i++) {
//                broken[Integer.parseInt(inputText[i])] = true;
//            }
//
//            // 현재 채널이 100번이므로
//            int answer = n - 100;
//            if (answer < 0) {
//                answer = -answer;
//            }
//
//            for (int i = 0; i <= 1_000_000; i++) {
//                int c = i;
//                int len = possible(c);
//
//                if (len > 0) {
//                    int press = c - n;
//                    if (press < 0) {
//                        press = -press;
//                    }
//
//                    if (answer > len + press) {
//                        answer = len + press;
//                    }
//                }
//            }
//
//            System.out.println(answer);
//
//        } catch (IOException e) {
//            System.err.println("Error : " + e);
//        }
//    }
//
//    private static int possible(int channel) {
//        if (channel == 0) {
//            if (broken[0]) {
//                return 0;
//            } else {
//                return 1;
//            }
//        }
//
//        int len = 0;
//
//        while (channel > 0) {
//            if (broken[channel % 10]) return 0;
//            len += 1;
//            channel /= 10;
//        }
//
//        return len;
//    }
//}
// BufferedReader 가 안된다.

public class P1107 {
    static boolean[] broken = new boolean[10];
    static int possible(int c) {
        if (c == 0) {
            if (broken[0]) {
                return 0;
            } else {
                return 1;
            }
        }
        int len = 0;
        while (c > 0) {
            if (broken[c % 10]) {
                return 0;
            }
            len += 1;
            c /= 10;
        }
        return len;
    }

    public static void main(String args[]) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(bufferedReader.readLine());
            int m = Integer.parseInt(bufferedReader.readLine());
            String[] inputText = bufferedReader.readLine().split(" ");

            for (int i = 0; i < m; i++) {
                broken[Integer.parseInt(inputText[i])] = true;
            }
            int ans = n - 100;
            if (ans < 0) {
                ans = -ans;
            }
            for (int i = 0; i <= 1000000; i++) {
                int c = i;
                int len = possible(c);
                if (len > 0) {
                    int press = c - n;
                    if (press < 0) {
                        press = -press;
                    }
                    if (ans > len + press) {
                        ans = len + press;
                    }
                }
            }

            System.out.println(ans);
        } catch (IOException e) {
            System.err.println("Error : " + e);
        }
    }
}