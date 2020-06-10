package level1;

public class EvenAndOdd {
    public static void main(String[] args) {
        int num = 0;

        System.out.println(solution(num));
    }

    private static String solution(int num) {
        return num % 2 == 0 ? "Even" : "Odd";
    }
}
