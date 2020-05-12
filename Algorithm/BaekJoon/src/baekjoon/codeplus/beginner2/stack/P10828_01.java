package baekjoon.codeplus.beginner2.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 일차원 배열을 이용해서 스택을 직접 구현해본다.
// 1. push : 값을 넣고 size를 1 증가한다.
// 2. pop : size를 1 감소하고 값을 꺼낸다. 스택이 비어있는 경우 -1을 반환한다.
// 3. top : 마지막 값(size - 1)을 알려준다. 스택이 비어있는 경우 -1을 반환한다.
// 4. size : 현재 값이 몇 개 들어있는지 알려준다.
// 5. empty : 스택이 비어있으면 (size가 0이면) 1, 비어있지 않으면 0을 반환한다.

public class P10828_01 {
    private static final String NEWLINE = "\n";

    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder stringBuilder = new StringBuilder();

            int n = Integer.parseInt(bufferedReader.readLine());
            Stack<String> stacks = new Stack<>();

            while (n-- > 0) {
                String[] inputText = bufferedReader.readLine().split(" ");

                switch (inputText[0]) {
                    case "push":
                        stacks.push(DetermineText(inputText));
                        break;
                    case "pop":
                        stringBuilder.append(stacks.pop()).append(NEWLINE);
                        break;
                    case "top":
                        stringBuilder.append(stacks.top()).append(NEWLINE);
                        break;
                    case "size":
                        stringBuilder.append(stacks.size()).append(NEWLINE);
                        break;
                    case "empty":
                        stringBuilder.append(stacks.empty()).append(NEWLINE);
                        break;
                }
            }

            System.out.println(stringBuilder.toString());

        } catch (IOException e) {
            System.err.println("Error : " + e);
        }
    }

    private static String DetermineText(String[] inputText) {
        if (inputText.length > 1) {
            return inputText[1];
        }

        return "";
    }

    static class Stack<T> {
        private Object[] objects;
        private int size = 0;

        public Stack() {
            objects = new Object[size + 1];
        }

        void push(T t) {
            objects[size()] = t;
            size++;
            objects = Arrays.copyOf(objects, size() + 1);
        }

        T pop() {
            if (size() < 1) {
                return (T) String.valueOf(-1);
            }

            T t = top();
            objects[size() - 1] = null;
            size--;

            return t;
        }

        T top() {
            if (size() < 1) {
                return (T) String.valueOf(-1);
            }

            return (T) objects[size() - 1];
        }

        int size() {
            return size;
        }

        int empty() {
            return size() == 0 ? 1 : 0;
        }
    }
}