package Inflearn.dp;

import java.util.Arrays;
import java.util.Scanner;

public class 냅색 {

    static Integer[][] dp;
    static int[] W; // weight
    static int[] V; // value

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        W = new int[n];
        V = new int[n];

        dp = new Integer[n][k+1];

        for(int i = 0 ; i < n ; i++){
            W[i] = scanner.nextInt();
            V[i] = scanner.nextInt();
        }
        System.out.println(knapsack(n-1, k));
    }

    static int knapsack(int i , int k){
        if(i < 0) return 0;

        if(dp[i][k] == null){
            
            // 현재 물건의 무게가 최대 무게보다 크다면 
            if(W[i] > k){
                dp[i][k] = knapsack(i-1 , k);
            }
            // 현재 물건의 무게가 최대 무게보다 작거나 같다면
            else {
                // 이전 물건의 무게와 , 최대무게 - 현재 물건의 무게 의 무게로 담을수 있는 물건의 가치와 현재 물건의 가치를 더한 값중 큰 값을 저장.
                dp[i][k] = Math.max(knapsack(i-1, k), knapsack(i-1, k - W[i]) + V[i]);
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[i][k];
    }
}
