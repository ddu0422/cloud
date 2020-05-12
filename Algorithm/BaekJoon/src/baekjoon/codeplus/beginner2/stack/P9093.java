package baekjoon.codeplus.beginner2.stack;

// 단어 뒤집기
// 문장이 주어졌을 때, 단어를 모두 뒤집어서 출력
// 1. 문자열을 stack에 넣다가 공백이 나오면 stack에서 모든 문자열을 출력하고 다시 진행
// 2. 문자열이 끝날때까지 반복

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P9093 {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            int t = Integer.parseInt(bufferedReader.readLine());

            while (t-- > 0) {
                StringBuilder stringBuilder = new StringBuilder();
                Stack<Character> stacks = new Stack<>();
                char[] inputText = bufferedReader.readLine().toCharArray();

                for (char c : inputText) {
                    if (c != ' ') {
                        stacks.push(c);
                    } else {
                        printStack(stringBuilder, stacks);
                    }
                }
                printStack(stringBuilder, stacks);

                System.out.println(stringBuilder.toString());
            }

        } catch (IOException e) {
            System.err.println("Error : " + e);
        }
    }

    private static void printStack(StringBuilder stringBuilder, Stack<Character> stacks) {
        while (!stacks.isEmpty()) {
            stringBuilder.append(stacks.pop());
        }
        stringBuilder.append(" ");
    }
}
