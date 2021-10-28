package sort;

import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort {

    static void bubbleSort(int[] arr){
        // 정렬됐는지 확인
        boolean switched = true;

        while (switched){
            switched = false;
            for(int i = 0 ; i < arr.length-1 ; i++){
                if(arr[i+1] > arr[i]){
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    // 정렬이 일어나면 switched 를 true 로 바꾸어 while 문을 다시 돌린다.
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
