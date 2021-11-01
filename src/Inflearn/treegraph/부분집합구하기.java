package Inflearn.treegraph;

import java.util.Scanner;

public class 부분집합구하기 {

    static int n ;
    static int[] ch;

    static void solution(int L){
        if(L == n+1){
            for(int i = 1 ; i <= n ; i++){
                if(ch[i] == i) System.out.print(i + " ");
            }
            System.out.println();
        } else {
            ch[L] = 1; // 출력한다..
            solution(L);
            ch[L] = 0; // 출력하지 않는다.
            solution(L);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n =scanner.nextInt();
        ch = new int[n+1];
        solution(1);
    }
}
