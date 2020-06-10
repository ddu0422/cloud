package level1;

public class IntegerSquareRootDiscrimination {
    private static final double NANO = 0.000_000_001;

    public static void main(String[] args) {
        long n = 5;

        System.out.println(solution(n));
    }

    private static long solution(long n) {
        int number = (int) Math.sqrt(n);

        if (Math.abs(number - Math.sqrt(n)) < NANO) {
            long nextNumber = number + 1;
            return nextNumber * nextNumber;
        }

        return -1;
    }
}
