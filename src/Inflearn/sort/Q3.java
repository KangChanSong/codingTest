package Inflearn.sort;

import java.util.Arrays;
import java.util.Scanner;

public class Q3 {

    private static void solution(int[] arr){

        // 자신보다 아래 있고 큰 숫자들을 하나씩 옮긴다.
        // 위 숫자들 중 맨 처음 시작하는 곳에 현재 숫자를 넣는다.

        for(int i = 0 ; i < arr.length ; i++){
            int a = arr[i];

            int index = -1;
            for(int j = i-1 ; j >= 0 ; j--){
                int b = arr[j];
                if(a < b){
                    arr[j+1] = arr[j];
                    index = j;
                }
            }

            if(index != -1) arr[index] = a;

        }

        printArr(arr);
    }

    private static void printArr(int[] arr) {
        for(int i = 0 ; i < arr.length ; i++){
            System.out.print(arr[i]+ " ");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = scanner.nextInt();
        }

        solution(arr);
    }
}
