package level1;

import java.util.Scanner;

public class PrintStarWithRectangle {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        for (int i = 0; i < b; i++) {
            stringBuilder.append("*".repeat(a));
            stringBuilder.append("\n");
        }

        System.out.print(stringBuilder.toString());
    }
}
