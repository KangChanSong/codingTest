package Inflearn.dp;

import java.util.Arrays;
import java.util.Scanner;

public class 동전교환 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] coins = new int[n+1];
        for(int i = 1 ; i <= n ; i++){
            coins[i] = scanner.nextInt();
        }

        int k = scanner.nextInt();
        int dp[][] = new int[n+1][k+1];

        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= k ; j++){
                if(coins[i] > j){
                    dp[i][j] = dp[i-1][j];
                } else {
                    int div = j / coins[i];
                    int rest = j % coins[i];
                    dp[i][j] = div + dp[i-1][rest];
                }
            }
        }

        System.out.println(dp[n][k]);
    }
}
