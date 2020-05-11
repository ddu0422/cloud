package baekjoon.codeplus.beginner1.s201;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P17298 {
//    public static void main(String[] args) {
//        try {
//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//
//            int count = Integer.parseInt(bufferedReader.readLine());
//            int[] a = new int[count];
//            String[] inputText = bufferedReader.readLine().split(" ");
//            Stack<Integer> stacks = new Stack<>();
//
//            for (int i = 0; i < a.length; i++) {
//                a[i] = Integer.parseInt(inputText[i]);
//            }
//
//            for (int i = 0; i < a.length - 1; i++) {
//                for (int j = i + 1; j < a.length; j++) {
//                    // stack에 있는 top의 수보다 작을 경우 오큰수는 stack의 top이 된다. a[i]다. a[j]로 해서 삽질했다.
//                    if (!stacks.isEmpty() && a[i] < stacks.peek()) {
//                        stacks.push(stacks.peek());
//                        break;
//                    }
//
//                    // stack에 있는 top의 수보다 클 경우 오큰수를 찾아야한다.
//                    // 큰 값이 있다면 새로 push를 한다.
//                    if (a[i] < a[j]) {
//                        stacks.push(a[j]);
//                        break;
//                    } else if (j == a.length - 1) {
//                        // 마지막까지 탐색 후 존재하지 않는다면 -1을 넣어준다.
//                        stacks.push(-1);
//                    }
//                }
//            }
//
//            // 마지막은 항상 -1
//            stacks.push(-1);
//
//            for (int b: stacks) {
//                System.out.print(b + " ");
//            }
//
//        } catch (IOException e) {
//            System.err.println("Error : " + e);
//        }
//    }
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            int count = Integer.parseInt(bufferedReader.readLine());
            String[] inputText = bufferedReader.readLine().split(" ");

            int[] a = new int[count];
            int[] answer = new int[count];
            Stack<Integer> stacks = new Stack<>();

            for (int i = 0; i < a.length; i++) {
                a[i] = Integer.parseInt(inputText[i]);
            }

            stacks.push(0);

            for (int i = 1; i < count; i++) {
                while (!stacks.empty() && a[stacks.peek()] < a[i]) {
                    answer[stacks.pop()] = a[i];
                }
                stacks.push(i);
            }

            while (!stacks.empty()) {
                answer[stacks.pop()] = -1;
            }

            for (int i : answer) {
                System.out.print(i + " ");
            }

        } catch (IOException e) {
            System.err.println("Error : " + e);
        }
    }
}
