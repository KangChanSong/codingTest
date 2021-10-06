package Inflearn.sort;

import java.util.Scanner;

public class Q1 {

    private static void solution(int[] arr){

        for(int i = 0 ; i < arr.length ; i++){
            int min = 101;
            int index = 0;
            for(int j = i ; j < arr.length ; j++){
                if(arr[j] < min) {
                    min = arr[j];
                    index = j;
                };
            }
            arr[index] = arr[i];
            arr[i] = min;
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
