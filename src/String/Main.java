package String;

import java.util.Scanner;

public class Main {
    static int solution(int arr[]){

        int result = 0;

        int score = 0;
        for(int i = 0 ; i < arr.length ; i++){

            if(arr[i] == 1){
                score++;
                result+= score;

                if( i != arr.length-1 && arr[i+1] == 0 ){
                    score = 0;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rep = scanner.nextInt();
        int[] arr = new int[rep];
        for(int i = 0 ; i < rep ; i++){
            arr[i] = scanner.nextInt();
        }
        System.out.println(solution(arr));

    }
}
