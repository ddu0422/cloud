package baekjoon.codeplus.beginner1.s200;

import java.util.Scanner;
import java.util.Stack;

public class P10828 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        Stack<Integer> stacks = new Stack<>();

        while(num-- > 0) {
            String input = scanner.nextLine();
            String[] texts = input.split(" ");
            String select = texts[0];
            int result = -1;

            if ("push".equals(select)) {
                stacks.push(Integer.valueOf(texts[1]));
                continue;
            } else if ("pop".equals(select) && stacks.size() > 0) {
                result = stacks.pop();
            } else if ("size".equals(select)) {
                result = stacks.size();
            } else if ("empty".equals(select)) {
                if (stacks.empty()) {
                    result = 1;
                } else {
                    result = 0;
                }
            } else if ("top".equals(select) && stacks.size() > 0) {
                    result = stacks.peek();
            }

            System.out.println(result);
        }
    }
}
