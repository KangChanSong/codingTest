package sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class InsertionSort {

    static void insertionSort(int[] arr){

        List<Integer> list = new LinkedList<>();
        loop: for(int x = 0 ; x < arr.length ; x++){
            int num = arr[x];
            for(int i=0; i<list.size(); i++){
                int n = list.get(i);
                System.out.println("n = " + n);
                if(n>num){
                    list.add(i, num); //중간에 삽입하면 뒤의 데이터들은 자동으로 밀립니다.
                    continue loop;
                }
            }
            list.add(num);
        }

        for(Integer num: list)
            System.out.print(num +" ");
    }

    public static void main(String[] args) {
        int[] arr = InputHelper.inputArray();
        insertionSort(arr);


    }
}
