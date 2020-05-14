package baekjoon.codeplus.beginner2.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class P10866 {
    private static final String BLANK = " ";
    private static final String NEWLINE = "\n";

    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder stringBuilder = new StringBuilder();
            LinkedList<String> deque = new LinkedList<>();

            int n = Integer.parseInt(bufferedReader.readLine());

            while (n-- > 0) {
                String[] inputText = bufferedReader.readLine().split(BLANK);

                switch (inputText[0]) {
                    case "push_front":
                        deque.addFirst(inputText[1]);
                        break;
                    case "push_back":
                        deque.addLast(inputText[1]);
                        break;
                    case "pop_front":
                        if (deque.isEmpty()) {
                            stringBuilder.append(-1).append(NEWLINE);
                        } else {
                            stringBuilder.append(deque.removeFirst()).append(NEWLINE);
                        }
                        break;
                    case "pop_back":
                        if (deque.isEmpty()) {
                            stringBuilder.append(-1).append(NEWLINE);
                        } else {
                            stringBuilder.append(deque.removeLast()).append(NEWLINE);
                        }
                        break;
                    case "size":
                        stringBuilder.append(deque.size()).append(NEWLINE);
                        break;
                    case "empty":
                        if (deque.isEmpty()) {
                            stringBuilder.append(1).append(NEWLINE);
                        } else {
                            stringBuilder.append(0).append(NEWLINE);
                        }
                        break;
                    case "front":
                        if (deque.isEmpty()) {
                            stringBuilder.append(-1).append(NEWLINE);
                        } else {
                            stringBuilder.append(deque.getFirst()).append(NEWLINE);
                        }
                        break;
                    case "back":
                        if (deque.isEmpty()) {
                            stringBuilder.append(-1).append(NEWLINE);
                        } else {
                            stringBuilder.append(deque.getLast()).append(NEWLINE);
                        }
                        break;
                }
            }

            System.out.print(stringBuilder.toString());

        } catch (IOException e) {
            System.err.println("Error : " + e);
        }

    }
}
