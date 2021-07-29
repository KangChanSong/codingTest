package Inflearn.Array;

import java.util.Scanner;

public class Q3 {

    static void solution(int[] a, int[] b){

        for(int i=0 ; i < a.length ; i ++){
            int num = a[i] - b[i];
            if(num ==0){
                System.out.println("D");
            } else if (num == -1 || num == 2){
                System.out.println("B");
            } else {
                System.out.println("A");
            }
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int rep = scanner.nextInt();
        int[] param = new int[rep];
        int[] param1 = new int[rep];

        for(int i = 0 ; i < rep ; i++){
            param[i] = scanner.nextInt();
        }
        for(int i = 0 ; i < rep ; i++){
            param1[i] = scanner.nextInt();
        }
        solution(param, param1);
    }
}
