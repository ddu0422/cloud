package baekjoon.codeplus.beginner2.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 괄호 문자열
// 올바른 괄호 문자열이면 YES, 아니면 NO
// 1. "(" 이면 push ")" 이면 pop
// 2. "("가 들어온 경우
//  2-1. 스택이 남으면 NO
//  2-2. 스택이 남지 않으면 YES
// 3. 스택이 비었을 때 ")"가 들어온 경우 --> NO를 출력

public class P9012 {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            int t = Integer.parseInt(bufferedReader.readLine());

            while (t-- > 0) {
                String answer = "YES";

                Stack<Character> stacks = new Stack<>();
                char[] inputText = bufferedReader.readLine().toCharArray();

                for (char c : inputText) {
                    if (c == '(') {
                        stacks.push(c);
                    } else {
                        if (stacks.isEmpty()) {
                            answer = "NO";
                            break;
                        } else {
                            stacks.pop();
                        }
                    }
                }

                if (!stacks.isEmpty()) {
                    answer = "NO";
                }

                System.out.println(answer);
            }

        } catch (IOException e) {
            System.err.println("Error : " + e);
        }
    }
}
