package Inflearn.String;

import java.util.Scanner;

public class Q3 {

    static String solution(String string){

        String result = "";
        String[] childs = string.split(" ");
        for(String s: childs){
            if(result.length() < s.length()) {
                result = s;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = "";
        input += scanner.nextLine();
        scanner.close();

        System.out.println(solution(input));
    }
}
