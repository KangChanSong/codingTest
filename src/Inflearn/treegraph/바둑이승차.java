package Inflearn.treegraph;

import java.util.Scanner;

public class 바둑이승차 {

    static int max = 0;
    static int answer = 0;
    static void solution(int[] arr){
        dp(arr, 0, 0);
    }

    private static void dp(int[] arr, int index, int sum) {
        if(index > arr.length-1) {
            if(sum > answer) answer = sum;
            return;
        }
        if(sum + arr[index] > max) {
            System.out.println(sum);
            if(sum > answer) answer = sum;
            return;
        }
        dp(arr, index+1, sum+arr[index]);
        dp(arr, index+1, sum);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        max = scanner.nextInt();
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = scanner.nextInt();
        }
        solution(arr);
        System.out.println(answer);
    }
}
