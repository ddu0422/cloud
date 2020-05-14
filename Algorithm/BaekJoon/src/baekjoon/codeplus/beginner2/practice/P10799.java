package baekjoon.codeplus.beginner2.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 쇠막대기
// 1. '('가 들어올 경우 stack에 넣기
// 2. ')'가 들어올 경우 stack 하나 제거
//  2-1 이전이 ')' 일 경우 + 1
//  2-2 이전이 '(' 일 경우 + stack.size()

public class P10799 {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            Stack<Character> stacks = new Stack<>();
            char[] inputText = bufferedReader.readLine().toCharArray();
            int answer = 0;
            boolean isRightParenthesis = true;

            for (char c : inputText) {
                if (c == '(') {
                    stacks.push(c);
                    isRightParenthesis = false;
                } else {
                    stacks.pop();
                    if (isRightParenthesis) {
                        answer += 1;
                    } else {
                        answer += stacks.size();
                        isRightParenthesis = true;
                    }
                }
            }

            System.out.println(answer);

        } catch (IOException e) {
            System.err.println("Error : " + e);
        }
    }
}
