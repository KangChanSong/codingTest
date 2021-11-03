package Inflearn.treegraph;

import java.util.Scanner;

public class 수열추측하기 {

    static int[] ans;
    static boolean isAnswered = false;
    static int f;
    static int n;

    static void solution(int k){

        if(isAnswered) return;

        if(checkIfFilled()){
            if(recurse(ans) == f) {
                isAnswered = true;
                printArr(ans);
            }
            return;
        }

        for(int i = 0 ; i < ans.length ; i++){
            if(ans[i] == 0 ){
                ans[i] = k;
                solution(k+1);
                ans[i] = 0;
            }
        }

    }

    private static boolean checkIfFilled() {
        for(int i = 0 ; i < ans.length ; i++){
            if(ans[i] == 0) return false;
        }
        return true;
    }

    private static void printArr(int[] ans) {
        for(int i = 0 ; i < ans.length ; i++){
            System.out.print(ans[i] + " ");
        }
    }

    static int recurse(int[] arr){
        if(arr.length == 1) return arr[0];
        int[] newArr = new int[arr.length-1];
        for(int i = 0 ; i < arr.length-1 ; i++){
            newArr[i] = arr[i] + arr[i+1];
        }
        return recurse(newArr);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        f = scanner.nextInt();
        ans = new int[n];
        solution(1);
    }
}
