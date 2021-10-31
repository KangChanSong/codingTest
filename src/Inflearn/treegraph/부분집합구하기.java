package Inflearn.treegraph;

import java.util.Arrays;
import java.util.Scanner;

public class 부분집합구하기 {

    static int n ;
    static int[] ch;

    static void solution(int L){
        if(L == n + 1 ){
            for(int i = 1 ; i < ch.length ; i++){
                if(ch[i] == 1) System.out.print(i + " ");
            }
            System.out.println();
        } else {
            ch[L] = 1;
            solution(L+1);
            ch[L] = 0;
            solution(L+1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n =scanner.nextInt();
        ch = new int[n+1];
        solution(1);
    }
}
