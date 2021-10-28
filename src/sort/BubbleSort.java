package sort;

import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort {

    static void bubbleSort(int[] arr){
        boolean switched = true;
        while (switched){
            switched = false;
            for(int i = 0 ; i < arr.length-1 ; i++){
                if(arr[i+1] < arr[i]){
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    switched = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = InputHelper.inputArray();
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
