package Inflearn.Array;

import java.util.ArrayList;
import java.util.Scanner;

public class Q6실패 {
    static void solution(int[] arr){

        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0 ; i < arr.length ; i ++){
            int temp = arr[i];
            int res = 0;
            while (temp > 0){
                int t = temp % 10;
                res = res * 10 + t;
                temp = temp/10;
            }

            list.add(res);
        }

        System.out.println(list.toString());

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rep = scanner.nextInt();
        int[] arr = new int[rep];
        for(int i = 0 ; i < rep ; i++){
            arr[i] = scanner.nextInt();
        }

        solution(arr);
    }
}
