package baekjoon.codeplus.beginner1.s501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1476 {
    //    public static void main(String[] args) {
//        try {
//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//            String[] inputText = bufferedReader.readLine().split(" ");
//            int e = Integer.parseInt(inputText[0]);
//            int s = Integer.parseInt(inputText[1]);
//            int m = Integer.parseInt(inputText[2]);
//
//            int e1 = 1, s1 = 1, m1 = 1;
//
//            for (int i = 1; ; i++) {
//                if (e1 == e && s1 == s && m1 == m) {
//                    System.out.println(i);
//                    break;
//                }
//                e1 += 1;
//                s1 += 1;
//                m1 += 1;
//
//                if (e1 == 16) {
//                    e1 = 1;
//                }
//
//                if (s1 == 29) {
//                    s1 = 1;
//                }
//
//                if (m1 == 20) {
//                    m1 = 1;
//                }
//            }
//
//        } catch (IOException e) {
//            System.err.println("Error : " + e);
//        }
//
//    }
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String[] inputText = bufferedReader.readLine().split(" ");
            int e = Integer.parseInt(inputText[0]) - 1;
            int s = Integer.parseInt(inputText[1]) - 1;
            int m = Integer.parseInt(inputText[2]) - 1;

            for (int i = 0; ; i++) {
                if (i % 15 == e && i % 28 == s && i % 19 == m) {
                    System.out.println(i + 1);
                    break;
                }
            }

        } catch (IOException e) {
            System.err.println("Error : " + e);
        }

    }
}
