package Array;

import java.util.Arrays;
import java.util.Scanner;

public class Q7 {

    static void solution(int[] arr){

        int[] ranks = new int[arr.length];

        for(int i=0; i< arr.length ; i++) {
            int count = 1 ;

            for(int j = 0 ; j < arr.length ; j++){
                if(arr[j] > arr[i]) count ++;
            }
            System.out.print(count + " ");

        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int rep = scanner.nextInt();
        int[] arr = new int[rep];
        for(int i = 0 ; i < rep ; i++){
            arr[i] = scanner.nextInt();
        }

        solution(arr);
    }
}
