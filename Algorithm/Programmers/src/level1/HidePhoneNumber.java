package level1;

public class HidePhoneNumber {
    public static void main(String[] args) {
        String phoneNumber = "1231231234444";

        System.out.println(solution(phoneNumber));
    }

    private static String solution(String phoneNumber) {
        int length = phoneNumber.length();
        return "*".repeat(length - 4) + phoneNumber.substring(length - 4, length);
    }
}
