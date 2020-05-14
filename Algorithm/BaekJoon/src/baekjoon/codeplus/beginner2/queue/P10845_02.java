package baekjoon.codeplus.beginner2.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class P10845_02 {
    private static final String BLANK = " ";
    private static final String NEWLINE = "\n";

    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder stringBuilder = new StringBuilder();

            Queue<Integer> queue = new LinkedList<>();
            int n = Integer.parseInt(bufferedReader.readLine());
            int back = 0;

            while (n-- > 0) {
                String[] inputText = bufferedReader.readLine().split(BLANK);

                switch (inputText[0]) {
                    case "push":
                        int value = Integer.parseInt(inputText[1]);
                        queue.offer(value);
                        back = value;
                        break;
                    case "pop":
                        if (queue.isEmpty()) {
                            stringBuilder.append(-1).append(NEWLINE);
                        } else {
                            stringBuilder.append(queue.poll()).append(NEWLINE);
                        }
                        break;
                    case "size":
                        stringBuilder.append(queue.size()).append(NEWLINE);
                        break;
                    case "empty":
                        if (queue.isEmpty()) {
                            stringBuilder.append(1).append(NEWLINE);
                        } else {
                            stringBuilder.append(0).append(NEWLINE);
                        }
                        break;
                    case "front":
                        if (queue.isEmpty()) {
                            stringBuilder.append(-1).append(NEWLINE);
                        } else {
                            stringBuilder.append(queue.peek()).append(NEWLINE);
                        }
                        break;
                    case "back":
                        if (queue.isEmpty()) {
                            stringBuilder.append(-1).append(NEWLINE);
                        } else {
                            stringBuilder.append(back).append(NEWLINE);
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
