package String;

import java.util.Scanner;

public class Q9 {

    static int solution(String str){

        String numberString = str.replaceAll("[a-zA-Z]", "");
        return Integer.valueOf(numberString);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();

        System.out.println(solution(string));
    }
}
