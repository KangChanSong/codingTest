package Inflearn.String;

import java.util.Scanner;

public class Q6 {

    static String solution(String s){

        String string = "";
        for(Character c : s.toCharArray()){

            if(string.contains(String.valueOf(c))){

            } else {
                string += c;
            }
        }

        return string;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();

        System.out.println(solution(string));
    }
}
