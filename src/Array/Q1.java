package Array;

import java.util.Scanner;

public class Q1 {

    static void solution(int[] arr){

        for(int i=0 ; i < arr.length ; i++){
            if(i == 0){
                System.out.print(arr[i] + " ");
            } else if( arr[i-1] < arr[i]){
                System.out.print(arr[i] + " ");
            }
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int rep = scanner.nextInt();

        int[] param = new int[rep];

        for(int i = 0 ; i < rep ; i++){
            param[i] = scanner.nextInt();
        }

        solution(param);
    }
}
