package String;

import java.util.Scanner;

public class Q5 {

    static String solution(String str){

        String lower = "qwertyuiopasdfghjklzxcvbnm";
        String upper = lower.toUpperCase();
        String alphabet = lower + upper;

        char[] charArr = str.toCharArray();
        char[] resultCharArr = new char[charArr.length];

        for(int i=0; i< charArr.length ; i ++){

            Character c = charArr[i];

            if(alphabet.contains(c.toString())){

                int index = str.indexOf(c);
                int oppositeIndex = str.length() - index - 1;

                resultCharArr[oppositeIndex] = c;

            } else {

                resultCharArr[i] = c;
            }
        }

        return String.valueOf(resultCharArr);
    };

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String string = scanner.next();
        System.out.println(solution(string));
    }
}
