package baekjoon.codeplus.beginner1.s200;

// 주어진 수열의 스택은 입력한 만큼 빠져나와야한다. [중요 포인트]
// 출처 : https://blog.naver.com/PostView.nhn?blogId=yongyos&logNo=221427497263

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P1874 {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder stringBuilder = new StringBuilder();
            int n = Integer.parseInt(bufferedReader.readLine());
            List<Integer> numbers = new ArrayList<>();
            Stack<Integer> stacks = new Stack<>();

            for (int i = 0; i < n; i++) {
                numbers.add(Integer.parseInt(bufferedReader.readLine()));
            }

            for (int i = 1; i <= n; i++) {
                stacks.push(i);
                stringBuilder.append("+\n");

                while (!stacks.empty() && !numbers.isEmpty() && stacks.peek().equals(numbers.get(0))) { // 이 부분
                    stacks.pop();
                    numbers.remove(0); // 이 부분
                    stringBuilder.append("-\n");
                }
            }

            if (!stacks.isEmpty()) {
                stringBuilder.setLength(0);
                stringBuilder.append("NO");
            }

            System.out.println(stringBuilder.toString());

            bufferedReader.close();

        } catch (IOException e) {
            System.err.println("Error : " + e);
        }
    }
}