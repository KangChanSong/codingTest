package String;

import java.util.Arrays;
import java.util.Scanner;

public class Q10 {

    static void solution(String string, char c){

        char[] arr = string.toCharArray();

        int currIdx = 0;

        int[] result = new int[string.length()];
        for(int i=0 ; i < arr.length ; i++){

            for(int j=0 ; j< arr.length; j++){
                int gap = 0 ;
                if(arr[j] == c){
                    result[j] = 0 ;
                    gap = j - i;
                    int abs = gap < 0 ? -gap : gap;
                    if(result[i] > abs || result[i] == 0){
                        result[i] = abs;
                    }

                }
            }
        }

        for(int i = 0 ; i < result.length ; i++){
            System.out.print(result[i] + " ");
        }

    };

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        String[] arr = string.split(" ");
        solution(arr[0], arr[1].toCharArray()[0]);
    }
}
