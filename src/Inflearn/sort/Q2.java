package Inflearn.sort;

import java.util.Arrays;
import java.util.Scanner;

public class Q2 {

    private static void solution(int[] arr){

        for(int i = 1 ; i < arr.length ; i++){
            for(int j = 0 ; j < arr.length - i ; j++){
                int x = arr[j];
                int y = arr[j+1];
                if(x > y){
                    arr[j] = y;
                    arr[j+1] = x;
                }
            }
        }

        for(int i = 0 ; i < arr.length ; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<arr.length ;i++){
            arr[i] = scanner.nextInt();
        }
        solution(arr);
    }
}
