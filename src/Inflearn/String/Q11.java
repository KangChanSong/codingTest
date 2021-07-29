package Inflearn.String;

import java.util.Scanner;

public class Q11 {
    static String solution(String str){

        Integer count = 1;
        int currIdx = 0;
        char[] arr = str.toCharArray();
        String result = "";
        for(int i = 0 ; i < arr.length; i++){
            if(i == 0){
                result += String.valueOf(arr[i]);
            } else {

                if(arr[i] == arr[i-1]){
                    count++;
                    if(i == arr.length-1){
                        result += count.toString();
                    }
                } else {
                    if(count != 1){
                        result += count.toString();
                        result += String.valueOf(arr[i]);
                        count =1 ;
                    } else {
                        result += String.valueOf(arr[i]);
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        System.out.println(solution(str));
    }
}
