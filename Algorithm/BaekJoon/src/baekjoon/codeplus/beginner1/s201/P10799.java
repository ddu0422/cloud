package baekjoon.codeplus.beginner1.s201;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 1. "(" 일 경우 stack에 넣는다.
// 2. ")" 일 경우 숫자를 더하는데 조건이 있다.
/*
    이 전이 "("인 경우 -> 레이저를 형성한다. stack의 size를 구하면 된다.
    이 전이 ")"인 경우 -> 레이저를 형성하지 않고 막대가 끝남을 의미한다. 막대가 끝나면서 1개를 만들기 때문에 1을 더해준다.
 */

public class P10799 {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            String[] inputText = bufferedReader.readLine().split("");
            Stack<String> stacks = new Stack<>();
            int total = 0;
            boolean tag = false;

            for (String text : inputText) {
                if ("(".equals(text)) {
                    stacks.push(text);
                    tag = false;
                } else {
                    stacks.pop();
                    if (tag) {
                        total += 1;
                    } else {
                        total += stacks.size();
                        tag = true;
                    }
                }
            }
            System.out.println(total);

        } catch (IOException e) {
            System.err.println("Error : " + e);
        }
    }
}
