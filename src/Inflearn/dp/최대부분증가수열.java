package Inflearn.dp;

import java.util.Arrays;
import java.util.Scanner;

public class 최대부분증가수열 {

    static int[] dp;

    static int solution(int[] arr){
        for(int i = 0 ; i < arr.length ; i++) recurse(arr, i);
        return Arrays.stream(dp).max().getAsInt();
    }

    private static int recurse(int[] arr, int i) {

        int count = 0;
        if(dp[arr[i]] == 0) {
            for (int j = i + 1; j < arr.length; j++) {
                int temp = arr[j];
                if (temp > arr[i]) {
                    if (dp[temp] == 0) count = Math.max(count, recurse(arr, j));
                    else count = Math.max(count, dp[temp]);
                }
            }
            return dp[arr[i]] = count+1;
        } else
            return dp[arr[i]];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n =scanner.nextInt();
        int[] arr = new int[n];
        int max = 0;
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = scanner.nextInt();
            max = Math.max(max, arr[i]);
        }
        dp = new int[max+1];
        System.out.println(solution(arr));
    }
}
