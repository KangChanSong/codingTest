package Inflearn.Array;

import java.util.Scanner;

public class Q8_1DArr {
    static int solution(int n , int[] arr){

        int rowMax = 0;
        for(int i=n ; i < arr.length ; i= i+n){
            int row = 0;
            for(int j = i-n ; j < i ; j++){
                row += arr[j];
            }
            if(row > rowMax){
                rowMax = row;
            }
        }
        int colMax = 0;
        for(int i=0 ; i < n ; i++ ){
            int col = 0;
            for(int j=i ; j < arr.length ; j = j + n){
                col += arr[j];
            }
            if(col > colMax){
                colMax = col;
            }
        }
        int crossMaxA = 0;
        int crossMaxB = 0;
        int asc  = 0;
        int desc = n;
        for(int i = 0 ; i < arr.length; i = i + n){
            crossMaxA += arr[i+asc];
            asc ++;
            crossMaxB += arr[i+desc];
            desc--;
        }
        int lineMax = colMax > rowMax ? colMax : rowMax;
        int crosMax = crossMaxA > crossMaxB ? crossMaxA : crossMaxB;

        return lineMax > crosMax ? lineMax : crosMax;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int rep = scanner.nextInt();
        int[] arr = new int[rep*rep];
        for(int i = 0 ; i < rep*rep ; i++){
            arr[i] = scanner.nextInt();
        }

        System.out.println(solution(rep , arr));
    }
}
