package BakeJoon.bronze1;

import java.util.Scanner;

public class 기적의_매매법 {

    static int joonhyeon(int deposit, int[] arr){

        int stocks = 0;
        int jDeposit = deposit;
        for(int i=0 ; i < arr.length ; i++){
            while (jDeposit >= arr[i]){
                jDeposit = jDeposit - arr[i];
                stocks++;
            }
        }

        return jDeposit + (stocks * arr[arr.length-1]);
    }

    static int sungmin(int deposit, int[] arr){
        int sDeposit = deposit;

        int stocks = 0;
        int rise = 0;
        int fall = 0;
        for(int i = 1 ; i < arr.length ; i++){

            if(arr[i]> arr[i-1]){
                rise++;
                fall = 0;
            } else if(arr[i] < arr[i-1]){
                fall++;
                rise = 0;
            } else {
                rise = 0;
                fall = 0;
            }
            if(rise >= 3){
                sDeposit = sDeposit + (stocks * arr[i]);
                stocks = 0;
            } else if(fall >= 3){
                while (sDeposit >= arr[i]){
                    sDeposit = sDeposit - arr[i];
                    stocks++;
                }
            }

        }

        return sDeposit + (stocks * arr[arr.length-1]);
    }

    static String solution(int deposit, int[] arr){

        String winner = "";

        if(joonhyeon(deposit, arr) > sungmin(deposit, arr)){
            winner = "BNP";
        } else if(joonhyeon(deposit, arr) < sungmin(deposit, arr)){
            winner = "TIMING";
        } else{
            winner = "SAMESAME";
        }
        return winner;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int deposit = scanner.nextInt();
        int[] arr = new int[14];
        for(int i=0; i<14 ; i++){
            arr[i] = scanner.nextInt();
        }

        System.out.println(solution(deposit, arr));
    }
}
