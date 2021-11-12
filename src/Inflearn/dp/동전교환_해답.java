package Inflearn.dp;

import java.util.Arrays;
import java.util.Scanner;

public class 동전교환_해답 {

    static int n, m;
    static int[] dy;
    static int solution(int[] coin){
        Arrays.fill(dy, Integer.MAX_VALUE);
        dy[0] = 0;
        for(int i=0; i<n ; i++){
            for(int j = coin[i] ; j <= m ;  j++){
                dy[j] = Math.min(dy[j], dy[j-coin[i]] + 1);
            }
        }
        return dy[m];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n; i++){
            arr[i] = scanner.nextInt();
        }
        m = scanner.nextInt();
        dy = new int[m+1];
        System.out.println(solution(arr));
    }
}
