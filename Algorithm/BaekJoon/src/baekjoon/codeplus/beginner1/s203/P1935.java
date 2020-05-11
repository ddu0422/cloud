package baekjoon.codeplus.beginner1.s203;

// 1. 주어진 식을 stack에 넣는다.
// 2. 숫자일 경우 stack에 넣는다.
// 3. 연산자일 경우 stack에서 숫자 2개를 꺼내와 연산을 한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P1935 {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            int count = Integer.parseInt(bufferedReader.readLine());
            String[] inputText = bufferedReader.readLine().split(""); // 연산식을 받는다.
            double[] numbers = new double[count];
            Stack<Double> stacks = new Stack<>();

            // 연산식에 대응되는 숫자를 입력받는다.
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = Double.parseDouble(bufferedReader.readLine());
            }

            // 첫번째는 항상 A
            stacks.push(numbers[0]);

            for (int i = 1; i < inputText.length; i++) {
                String text = inputText[i];
                // 연산자일 경우 연산 후 다시 stack에 담기
                if (!stacks.isEmpty() && "+".equals(text) || "-".equals(text) || "*".equals(text) || "/".equals(text)) {
                    operation(stacks, text);
                    // 연산 후 다음 text로 넘어가야한다.
                    continue;
                }
                // 숫자일 경우만 stack에 push
                stacks.push(numbers[text.charAt(0) - 65]);
            }
            System.out.println(String.format("%.2f", stacks.pop()));

        } catch (IOException e) {
            System.err.println("Error : " + e);
        }
    }

    private static void operation(Stack<Double> stacks, String text) {
        // 연산 순서를 맞춰주기 위해
        double b = stacks.pop();
        double a = stacks.pop();

        switch (text) {
            case "+":
                stacks.push(a + b);
                break;
            case "-":
                stacks.push(a - b);
                break;
            case "*":
                stacks.push(a * b);
                break;
            case "/":
                stacks.push(a / b);
                break;
        }
    }
//    public static void main(String[] args) {
//        try {
//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//
//            int count = Integer.parseInt(bufferedReader.readLine());
//            String[] inputText = bufferedReader.readLine().split(""); // 연산식을 받는다.
//            double[] numbers = new double[count];
//            Stack<Double> stacks = new Stack<>();
//
//            // 연산식에 대응되는 숫자를 입력받는다.
//            for (int i = 0; i < numbers.length; i++) {
//                numbers[i] = Double.parseDouble(bufferedReader.readLine());
//            }
//
//            // 첫번째는 항상 A
//            stacks.push(numbers[0]);
//
//            for (int i = 1; i < inputText.length; i++) {
//                String text = inputText[i];
//                // 연산자일 경우 연산 후 다시 stack에 담기
//                if (!stacks.isEmpty() && Operator.isOperator(text)) {
//                    operation(stacks, text);
//                    // 연산 후 다음 text로 넘어가야한다.
//                    continue;
//                }
//                // 숫자일 경우만 stack에 push
//                stacks.push(numbers[text.charAt(0) - 65]);
//            }
//            System.out.println(String.format("%.2f", stacks.pop()));
//
//        } catch (IOException e) {
//            System.err.println("Error : " + e);
//        }
//    }
//
//    public enum Operator {
//        PLUS("+", (a, b) -> (a + b)),
//        MINUS("-", (a, b) -> (a - b)),
//        MULTIPLY("*", (a, b) -> (a * b)),
//        DIVIDE("/", (a, b) -> (a / b));
//
//        private final String name;
//        private final BiFunction<Double, Double, Double> biFunction;
//
//        Operator(String name, BiFunction<Double, Double, Double> biFunction) {
//            this.name = name;
//            this.biFunction = biFunction;
//        }
//
//        public Double calculate(double a, double b) {
//            return this.biFunction.apply(a, b);
//        }
//
//        public static boolean isOperator(String text) {
//            return Arrays.stream(Operator.values())
//                    .anyMatch(operator -> text.equals(operator.name));
//        }
//
//        public static Operator findOperator(String text) {
//            return Arrays.stream(Operator.values())
//                    .filter((operator) -> text.equals(operator.name))
//                    .findAny()
//                    .orElseThrow(IllegalArgumentException::new);
//        }
//    }
//
//    private static void operation(Stack<Double> stacks, String text) {
//        // 연산 순서를 맞춰주기 위해
//        double b = stacks.pop();
//        double a = stacks.pop();
//
//        stacks.push(Operator.findOperator(text).calculate(a, b));
//    }
}
