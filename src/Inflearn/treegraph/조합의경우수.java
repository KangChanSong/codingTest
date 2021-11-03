package Inflearn.treegraph;

import java.util.Scanner;

public class 조합의경우수 {
    static int[][] dp;
    static int recurse(int n, int r){
        if(n == 0) return 0;
        if(r == 1) return n;

        if(dp[n][r] == 0) {
            dp[n][r] = recurse(n-1, r-1) + recurse(n-1, r);
            return dp[n][r];
        }

        return dp[n][r];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int r = scanner.nextInt();
        dp = new int[n+1][r+1];
        System.out.println(recurse(n,r ));
    }
}
