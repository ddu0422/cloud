package baekjoon.codeplus.beginner2.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 에디터
// L : 왼쪽 스택이 비어있지 않은 경우, 왼쪽 스택에 있는 문자열을 오른쪽 스택으로 옮긴다.
// D : 오른쪽 스택이 비어있지 않은 경우, 오른쪽 스택에 있는 문자열을 왼쪽 스택으로 옮긴다.
// B : 왼쪽 스택이 비어있지 않은 경우, 왼쪽 스택에 있는 문자열을 제거한다.
// P $ : 왼쪽 스택에 추가한다.
// 출력 : 왼쪽 스택에 있는 문자열을 모두 오른쪽으로 보낸 후 오른쪽 스택에서 전부 꺼내어 출력한다.

public class P1406 {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder stringBuilder = new StringBuilder();
            char[] inputText = bufferedReader.readLine().toCharArray();

            Stack<Character> leftStacks = new Stack<>();
            Stack<Character> rightStacks = new Stack<>();

            for (char c : inputText) {
                leftStacks.push(c);
            }

            int m = Integer.parseInt(bufferedReader.readLine());

            while (m-- > 0) {
                String[] commands = bufferedReader.readLine().split(" ");

                switch (commands[0].charAt(0)) {
                    case 'L':
                        if (!leftStacks.isEmpty()) {
                            rightStacks.push(leftStacks.pop());
                        }
                        break;
                    case 'D' :
                        if (!rightStacks.isEmpty()) {
                            leftStacks.push(rightStacks.pop());
                        }
                        break;
                    case 'B' :
                        if (!leftStacks.isEmpty()) {
                            leftStacks.pop();
                        }
                        break;
                    case 'P' :
                        leftStacks.push(commands[1].charAt(0));
                        break;
                }
            }

            while (!leftStacks.isEmpty()) {
                rightStacks.push(leftStacks.pop());
            }

            while (!rightStacks.isEmpty()) {
                stringBuilder.append(rightStacks.pop());
            }

            System.out.println(stringBuilder.toString());

        } catch (IOException e) {
            System.err.println("Error : " + e);
        }
    }
}
