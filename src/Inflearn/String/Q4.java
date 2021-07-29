package Inflearn.String;

import java.util.Scanner;

public class Q4 {

    static void solution(String[] strArray){

        String[] result = new String[strArray.length];
        int index = 0;
        for(String str : strArray){

            String element = "";

            for(int i = str.length() -1 ; i>=0 ; i--){
                Character c = str.toCharArray()[i];
                element +=  c.toString();
            }

            result[index] = element;
            index++;
        }

        for(String s : result){
            System.out.println(s);
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int length  = scanner.nextInt();

        String[] strArr = new String[length];

        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = scanner.next();
        }

        solution(strArr);
    }

}
