package Inflearn.treegraph;

import java.util.Scanner;

public class 미로탐색 {

    static int count;
    static int[][] maze = new int[7][7];
    static int[][] dp = new int[7][7];
    static void dfs(int i , int j){
        if(!validateLocation(i, j) || maze[i][j] == 1)  return;
        if(i == 6 && j == 6) {
            count++;
            return;
        }

        if(dp[i][j] == 0){
            dp[i][j] = 1;
        } else{
            return;
        }

        dfs(i, j+1);
        dfs(i, j-1);
        dfs(i+1, j);
        dfs(i-1, j);

        dp[i][j] = 0;

    }

    private static boolean validateLocation(int i, int j) {
        if(i < 0 || i > 6 || j < 0 || j > 6) return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for(int i = 0 ; i < 7 ; i++){
            for(int j = 0 ; j < 7; j++){
                maze[i][j] = scanner.nextInt();
            }
        }
        dfs(0,0);
        System.out.println(count);
    }
}
