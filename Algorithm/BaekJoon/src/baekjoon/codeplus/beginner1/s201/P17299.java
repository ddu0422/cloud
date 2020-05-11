package baekjoon.codeplus.beginner1.s201;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P17299 {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            int count = Integer.parseInt(bufferedReader.readLine());
            int[] frequency = new int[1_000_001];
            int[] arr = new int[count];
            int[] answer = new int[count];
            String[] inputText = bufferedReader.readLine().split(" ");

            Stack<Integer> stacks = new Stack<>();

            for (int i = 0; i < count; i++) {
                arr[i] = Integer.parseInt(inputText[i]);
            }

            for (int i = 0; i < count; i++) {
                frequency[arr[i]] += 1;
            }

            stacks.push(0);

            for (int i = 1; i < count; i++) {
                while (!stacks.isEmpty() && frequency[arr[stacks.peek()]] < frequency[arr[i]]) {
                    answer[stacks.pop()] = arr[i];
                }
                stacks.push(i);
            }

            while (!stacks.empty()) {
                answer[stacks.pop()] = -1;
            }

            for (int value: answer) {
                System.out.print(value + " ");
            }

        } catch (IOException e) {
            System.err.println("Error : " + e);
        }
    }
}
