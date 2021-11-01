package Inflearn.treegraph;

import java.util.Arrays;
import java.util.Scanner;

public class 합이같은부분집합 {

    static String answer = "NO";
    static void solution(int[] arr){

        int n = Arrays.stream(arr).sum();
        if(n % 2 == 1) return;
        n = n / 2;
        dp(arr, 0, n);
    }
    static void dp(int[] arr, int index, int n){
        if(n == 0){
            answer = "YES";
            return;
        }
        if(n < 0 || index == arr.length-1) return;
        dp(arr, index+1, n - arr[index]);
        dp(arr, index+1, n);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = scanner.nextInt();
        }

        solution(arr);
        System.out.println(answer);

    }
}
