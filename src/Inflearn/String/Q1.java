package Inflearn.String;


import java.util.Scanner;

public class Q1 {

    int solution(String string, char c){

        char upper = Character.toUpperCase(c);
        char lower = Character.toLowerCase(c);

        int result = 0;

        for(char i : string.toCharArray()){
            if(i == upper) result ++;
            else if(i == lower ) result ++;
        }

        return result;
    }

    public static void main(String[] args) {

        Q1 q1 = new Q1();

        Scanner scanner = new Scanner(System.in);

        System.out.println("문자열 입력");
        String string = scanner.next();
        char c = scanner.next().charAt(0);

        System.out.println(q1.solution(string, c));
    }
}
