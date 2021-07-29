package Inflearn.String;

import java.util.Scanner;

public class Q12 {

    static String solution(int length, String string){

        String result = "";
        for(int i = 0 ; i < length ; i++){
            String s = string.substring(0, 7).replace("#", "1").replace("*", "0");
            int num = Integer.valueOf(s , 2);
            result += (char) num;

            string = string.substring(7);
        }

        return result;
    };

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        String s = scanner.next();

        System.out.println(solution(num, s));
    }
}
