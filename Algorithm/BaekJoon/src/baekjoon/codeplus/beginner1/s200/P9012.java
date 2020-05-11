package baekjoon.codeplus.beginner1.s200;

import java.io.*;
import java.util.Stack;

// 1번째 경우 : (가 부족한 경우
// 2번째 경우 : (가 남는 경우

public class P9012 {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

            int count = Integer.parseInt(bufferedReader.readLine());

            while (count-- > 0) {
                Stack<String> stacks = new Stack<>();
                String[] texts = bufferedReader.readLine().split("");
                String answer = "YES";

                for (String text : texts) {
                    if ("(".equals(text)) {
                        stacks.push(text);
                    } else {
                        if (stacks.size() > 0) {
                            stacks.pop();
                        } else {
                            answer = "NO";
                            break;
                        }
                    }
                }

                if (stacks.size() != 0) {
                    answer = "NO";
                }

                bufferedWriter.write(answer + "\n");
                bufferedWriter.flush();
            }

            bufferedReader.close();
            bufferedWriter.close();

        } catch (IOException e) {
            System.err.println("error: " + e);
        }
    }
}
