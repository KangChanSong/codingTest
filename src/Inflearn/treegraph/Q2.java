package Inflearn.treegraph;

import java.util.Scanner;

public class Q2 {

    static void solution(int n){
        if(n == 1) {
            System.out.print(1);
            return;
        }
        if(n == 0) {
            System.out.print(0);
            return;
        }

        System.out.print(n % 2);
        solution(n / 2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        solution(n);
    }
}
