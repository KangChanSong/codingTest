package Inflearn.String;

import java.util.Scanner;

public class Q8 {
    static String solution(String s){

        String answer = "NO";
        s=  s.toUpperCase().replaceAll("[^A-Z]", "");
        String tmp = new  StringBuilder(s).reverse().toString();
        if(s.equals(tmp)) answer = "YES";
        return answer;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        System.out.println(solution(string));
    }
}
