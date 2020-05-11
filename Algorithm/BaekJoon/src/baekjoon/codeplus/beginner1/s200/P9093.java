package baekjoon.codeplus.beginner1.s200;

import java.io.*;
import java.util.Stack;

// 1. 공백으로 구분한다.
// 2. 공백을 제외한 각 단어를 뒤집는다.

public class P9093 {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
            Stack<String> stacks = new Stack<>();
            int count = Integer.parseInt(bufferedReader.readLine());

            while (count-- > 0) {
                for (String text : bufferedReader.readLine().split(" ")) {
                    String[] values = text.split("");

                    for (String value : values) {
                        stacks.push(value);
                    }

                    while (!stacks.empty()) {
                        bufferedWriter.write(stacks.pop());
                    }
                    bufferedWriter.write(" ");
                }

                bufferedWriter.flush();
            }

            bufferedWriter.close();
            bufferedReader.close();

        } catch (IOException e) {
            System.err.println("에러입니다.");
        }
    }
}
