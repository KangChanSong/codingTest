package Inflearn.sort;

import java.util.Arrays;
import java.util.Scanner;

public class Q6해답 {

    private static void selectionSort(int[] arr){
        for(int i = 0 ; i < arr.length ; i++){
            int min = 1000;
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
    }

    private static void solution(int[] arr){

        // arr 를 복사한다.
        // 원본과 복사본을 비교한다.

        int[] copy = Arrays.copyOf(arr, arr.length);
        selectionSort(copy);


        int x = -1;
        int y = -1;
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] != copy[i]){
                if(x == -1) x = i+1;
                else y = i+1;
            }
        }

        System.out.print(x + " " + y);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = scanner.nextInt();
        }
        solution(arr);
    }
}
