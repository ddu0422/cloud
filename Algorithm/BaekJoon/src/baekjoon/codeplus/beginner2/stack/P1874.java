package baekjoon.codeplus.beginner2.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 스택 수열
// 1. 1 ~ n 까지 스택에 넣었다가 빼면서 스택 수열이 만들어 질 수 있는지 판단
// 2. 가능한 경우 연산을 + (push), - (pop) 으로 출력
// 3. 불가능한 경우 NO를 출력
// 4. 수를 반복적으로 어떻게 넣을 것인가?? List<Integer> 를 통해 1 ~ n 까지의 수를 보관
// 5. stack 에 넣는 방법은?? 빼는 방법은??
// 6. 넣는 방법 : numbers가 비어 있지 않고, stack 에 입력된 값까지 numbers 에서 꺼내서 넣는다.
// 7. 빼는 방법 : stack 이 비어 있지 않고, top 과 입력한 값이 같을 경우 pop

public class P1874 {
    private static final String NEWLINE = "\n";
    private static final String PUSH = "+";
    private static final String POP = "-";
    private static final String NO = "NO";

    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder stringBuilder = new StringBuilder();

            int n = Integer.parseInt(bufferedReader.readLine());

            List<Integer> numbers = new ArrayList<>();
            Stack<Integer> stacks = new Stack<>();

            for (int i = 1; i <= n; i++) {
                numbers.add(i);
            }

            while (n-- > 0) {
                int a = Integer.parseInt(bufferedReader.readLine());

                while (!numbers.isEmpty() && numbers.get(0) <= a) {
                    stacks.push(numbers.remove(0));
                    stringBuilder.append(PUSH).append(NEWLINE);
                }

                while (!stacks.empty() && stacks.peek() == a) {
                    stacks.pop();
                    stringBuilder.append(POP).append(NEWLINE);
                }
            }

            if (!stacks.isEmpty()) {
                stringBuilder.setLength(0);
                stringBuilder.append(NO).append(NEWLINE);
            }

            System.out.print(stringBuilder.toString());
        } catch (IOException e) {
            System.err.println("Error : " + e);
        }
    }
}
