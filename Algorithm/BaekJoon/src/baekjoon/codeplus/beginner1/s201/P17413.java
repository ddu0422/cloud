package baekjoon.codeplus.beginner1.s201;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 1. 태그인 경우는 뒤집지 않고 출력한다.
// 2. 태그가 아닌 경우 뒤집어서 출력한다.

public class P17413 {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder stringBuilder = new StringBuilder();

            String[] inputText = bufferedReader.readLine().split("");
            Stack<String> stacks = new Stack<>();
            boolean isTag = false;

            for (String text : inputText) {
                if ("<".equals(text)) {
                    print(stringBuilder, stacks);
                    isTag = true;
                    stringBuilder.append(text);
                } else if (">".equals(text)) {
                    isTag = false;
                    stringBuilder.append(text);
                } else if (isTag) {
                    stringBuilder.append(text);
                } else {
                    if (" ".equals(text)) {
                        print(stringBuilder, stacks);
                        stringBuilder.append(text);
                    } else {
                        stacks.push(text);
                    }
                }
            }
            print(stringBuilder, stacks);

            System.out.println(stringBuilder.toString());

        } catch (IOException e) {
            System.err.println("Error : " + e);
        }

    }

    private static void print(StringBuilder stringBuilder, Stack<String> stacks) {
        while (!stacks.isEmpty()) {
            stringBuilder.append(stacks.pop());
        }
    }
}
