package BakeJoon.silver3;

import java.util.Scanner;

public class 피보나치_함수_왜시간초과임 {
    private static void solution(int[] arr){
        for(int i = 0 ; i < arr.length ; i++){
            fibonacci(arr[i]);
        }
    }

    private static void fibonacci(int n) {
        int b1 = 1;
        int b2 = 0;
        int c = 0;
        for(int i = 0 ; i < n; i++){
            c = b1 + b2;
            b1 = b2;
            b2 = c;
        }

        System.out.print(b1 + " " + b2);
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i ++){
            arr[i] = scanner.nextInt();
        }
        solution(arr);
    }
}
