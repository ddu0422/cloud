package baekjoon.codeplus.beginner1.s203;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
    중위표기식 -> 후위표기식은
    우선순위가 정해져있기 때문에 우선순위를 신경써야한다.
 */

public class P1918 {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder stringBuilder = new StringBuilder();

            String[] inputText = bufferedReader.readLine().split("");
            Stack<String> stacks = new Stack<>();

            for (String text : inputText) {
                int p = priority(text);

                switch (text) {
                    case "+":
                    case "-":
                    case "*":
                    case "/":
                        while (!stacks.isEmpty() && priority(stacks.peek()) >= p) {
                            stringBuilder.append(stacks.pop());
                        }
                        stacks.push(text);
                    case "(":
                        stacks.push(text);
                        break;
                    case ")":
                        while (!stacks.isEmpty() && !"(".equals(stacks.peek())) {
                            stringBuilder.append(stacks.pop());
                        }
                        stacks.pop();
                        break;
                    default:
                        stringBuilder.append(text);
                        break;
                }
            }

            while (!stacks.isEmpty()) {
                stringBuilder.append(stacks.pop());
            }
            System.out.println(stringBuilder.toString());

        } catch (IOException e) {
            System.err.println("Error : " + e);
        }

    }

    private static int priority(String text) {
        switch (text) {
            case "*":
            case "/":
                return 2;
            case "+":
            case "-":
                return 1;
            case "(":
            case ")":
                return 0;
            default:
                return -1;
        }
    }
}
