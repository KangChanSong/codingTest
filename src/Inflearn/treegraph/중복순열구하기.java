package Inflearn.treegraph;

import java.util.*;

public class 중복순열구하기 {
    static int n, m;
    static int[] pm;

    static void dfs(int i){
        if(i > m-1){
            for(int x=0; x<m ;x++){
                System.out.print(pm[x] + " ");
            }
            System.out.println();
            return;
        }

        for(int x=1 ;x<=n ; x++){
            pm[i] = x;
            dfs(i+1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        pm = new int[m];
        dfs(0);
    }
}
