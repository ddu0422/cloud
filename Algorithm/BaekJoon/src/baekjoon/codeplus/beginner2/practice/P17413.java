package baekjoon.codeplus.beginner2.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 단어 뒤집기 2
// 1. 태그 시작 전 뒤집어서 출력,
// 2. 태그 종료 전 그대로 출력
// 3. 공백 구분해서 단어 뒤집기

public class P17413 {
    private static final String BLANK = " ";

    private static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            Stack<Character> stacks = new Stack<>();
            boolean isTag = false;

            char[] inputText = bufferedReader.readLine().toCharArray();

            for (char c : inputText) {
                if (c == '<') {
                    printStack(stacks);
                    isTag = true;
                    stringBuilder.append(c);
                } else if (c == '>') {
                    isTag = false;
                    stringBuilder.append(c);
                } else if (isTag) {
                    stringBuilder.append(c);
                } else if (c == ' ') {
                    printStack(stacks);
                    stringBuilder.append(BLANK);
                } else {
                    stacks.push(c);
                }
            }
            printStack(stacks);

            System.out.println(stringBuilder.toString());

        } catch (IOException e) {
            System.err.println("Error : " + e);
        }

    }

    private static void printStack(Stack<Character> stacks) {
        while (!stacks.isEmpty()) {
            stringBuilder.append(stacks.pop());
        }
    }
}
