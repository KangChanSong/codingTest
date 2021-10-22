package BakeJoon.silver3;

import java.util.Arrays;
import java.util.Scanner;

public class 피보나치_함수2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        solution(scanner.nextInt());
    }

    private static void solution(int n){
        Long[] dp = new Long[n+1];
        System.out.println(recur(n, dp));
    }

    static long recur(int n, Long[] dp){
        if(dp[n] == null){
            if(n == 1 ) return 1;
            if(n == 0) return 0;
            dp[n] = recur(n-1, dp)  + recur(n-2, dp);
            return dp[n];
        } else{
            return dp[n];
        }
    }
}
