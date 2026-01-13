import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String input = sc.next();
        String result = "";

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            // 대문자라면 소문자로 변환
            if (Character.isUpperCase(c)) {
                result += Character.toLowerCase(c);
            } 
            // 소문자라면 대문자로 변환
            else if (Character.isLowerCase(c)) {
                result += Character.toUpperCase(c);
            } 
            // 영문자가 아닌 경우 그대로 유지
            else {
                result += c;
            }
        }

        System.out.println(result);
        
        sc.close();
    }
}