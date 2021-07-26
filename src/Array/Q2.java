package Array;

import java.util.Scanner;

public class Q2 {
    static int solution(int[] arr){

        int count = 0;

        int currentMax = 0;

        for(int i=0; i<arr.length ; i++){
            if(i == 0){
                count++;
                currentMax = arr[i];
            } else if(currentMax < arr[i]){
                count++;
                currentMax = arr[i];
            }
        }
        return count;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int rep = scanner.nextInt();

        int[] param = new int[rep];

        for(int i = 0 ; i < rep ; i++){
            param[i] = scanner.nextInt();
        }

        System.out.println(solution(param));
    }
}
