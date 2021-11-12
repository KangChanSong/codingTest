package Inflearn.dp;

import java.util.Arrays;
import java.util.Scanner;

public class 냅색_BottomUp1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt(); // 물건의 개수
        int K = scanner.nextInt(); // 최대 무게

        int[] W = new int[N+1]; // weight
        int[] V = new int[N+1]; // value
        int[][] dp = new int[N+1][K+1];

        for(int i = 1 ; i <= N ; i++){
            W[i] = scanner.nextInt();
            V[i] = scanner.nextInt();
        }

        for(int i = 1 ; i <= N ; i++){
            for(int j = 1; j <= K ; j++){
                if(W[i] > j){
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-W[i]] + V[i]);
                }
                System.out.println("i = " + i);
                System.out.println("j = " + j);
                System.out.println("dp[i][j] = " + dp[i][j]);
            }

            System.out.println(Arrays.toString(dp[i]));
            System.out.println();
        }
        System.out.println(dp[N][K]);
    }
}
