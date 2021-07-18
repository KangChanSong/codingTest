package String;

import java.util.Scanner;

public class Q2 {

    static String solution(String str){

        String result = "";

        for(char c : str.toCharArray()){

            if(c > 'Z'){
                result += Character.toUpperCase(c);
            } else if(c <= 'Z') {
                result += Character.toLowerCase(c);
            }

        }

        return result;
    };

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String result = solution(scanner.next());

        System.out.println(result);

    }
}
