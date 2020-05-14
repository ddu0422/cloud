package baekjoon.codeplus.beginner2.queue;

// 큐
// 일차원 배열을 이용해서 직접 구현
// push : 값을 넣고 size 를 1 증가
// pop : 값을 빼고 size 를 1 감소
// empty : 큐가 비어있으면 1, 아니면 0
// front : 큐의 가장 앞에 있는 정수 출력. 큐가 비어있으면 -1
// back : 큐의 가장 뒤에 있는 정수를 츨력. 큐가 비어있으면 -1

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P10845_01 {
    private static final String BLANK = " ";
    private static final String NEWLINE = "\n";

    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder stringBuilder = new StringBuilder();

            Queue<Integer> queue = new Queue<>();
            int n = Integer.parseInt(bufferedReader.readLine());

            while (n-- > 0) {
                String[] inputText = bufferedReader.readLine().split(BLANK);

                switch (inputText[0]) {
                    case "push":
                        queue.push(Integer.parseInt(inputText[1]));
                        break;
                    case "pop":
                        stringBuilder.append(queue.pop()).append(NEWLINE);
                        break;
                    case "size":
                        stringBuilder.append(queue.size()).append(NEWLINE);
                        break;
                    case "empty":
                        stringBuilder.append(queue.empty()).append(NEWLINE);
                        break;
                    case "front":
                        stringBuilder.append(queue.front()).append(NEWLINE);
                        break;
                    case "back":
                        stringBuilder.append(queue.back()).append(NEWLINE);
                        break;
                }

            }

            System.out.println(stringBuilder.toString());

        } catch (IOException e) {
            System.err.println("Error :" + e);
        }
    }

    private static class Queue<T> {
        private Object[] objects;
        private int size = 0;

        public Queue() {
            objects = new Object[size() + 1];
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

            T t = (T) objects[0];

            objects = Arrays.copyOfRange(objects, 1, size() + 1);
            size--;

            return t;
        }

        int size() {
            return size;
        }

        int empty() {
            return size() == 0 ? 1 : 0;
        }

        T front() {
            return size() > 0 ? (T) objects[0] : (T) String.valueOf(-1);
        }

        T back() {
            return size() > 0 ? (T) objects[size() - 1] : (T) String.valueOf(-1);
        }
    }
}
