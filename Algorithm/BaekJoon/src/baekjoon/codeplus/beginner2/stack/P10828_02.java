package baekjoon.codeplus.beginner2.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P10828_02 {
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
                        stacks.push(inputText[1]);
                        break;
                    case "pop":
                        if (stacks.size() < 1) {
                            stringBuilder.append(-1).append(NEWLINE);
                        } else {
                            stringBuilder.append(stacks.pop()).append(NEWLINE);
                        }
                        break;
                    case "top":
                        if (stacks.size() < 1) {
                            stringBuilder.append(-1).append(NEWLINE);
                        } else {
                            stringBuilder.append(stacks.peek()).append(NEWLINE);
                        }
                        break;
                    case "size":
                        stringBuilder.append(stacks.size()).append(NEWLINE);
                        break;
                    case "empty":
                        if (stacks.empty()) {
                            stringBuilder.append(1).append(NEWLINE);
                        } else {
                            stringBuilder.append(0).append(NEWLINE);
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
