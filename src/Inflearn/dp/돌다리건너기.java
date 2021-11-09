package Inflearn.dp;

import java.util.Scanner;

public class 돌다리건너기 {
    static int answer = 0;
    static void dp(int n){
        if(n == 0){
            answer++;
            return;
        }
        if(n < 0){
            return;
        }

        dp(n-1);
        dp(n-2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        dp(scanner.nextInt()+1);
        System.out.println(answer);
    }
}
