package String;

import java.util.Locale;
import java.util.Scanner;

public class Q7 {
    static String solution(String s) {

        String result;
        int count = 0;
        char[] charArr = s.toUpperCase().toCharArray();
        int middleIdx = (int)Math.ceil(charArr.length - 1 / 2);
        for (int i=0 ; i < middleIdx ; i++) {

            char element = charArr[i];
            char opposite = charArr[charArr.length - 1 - i];

            if(element == opposite){
                count ++;
            }

        }

        if(count == Math.ceil(middleIdx)){
            return "YES";
        } else {
            return "NO";
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();

        System.out.println(solution(string));
    }

}
