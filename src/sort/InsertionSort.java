package sort;

import java.util.LinkedList;
import java.util.List;

public class InsertionSort {
    static void insertionSort(int[] arr){
        List<Integer> list = new LinkedList<>();
        loop : for(int num : arr){
            for(int i = 0 ; i < list.size() ; i++){
                if(list.get(i) > num){
                    list.add(i, num);
                    continue loop;
                }
            }
            list.add(num);
        }

        System.out.println(list);
   }

    public static void main(String[] args) {
        int[] arr = InputHelper.inputArray();
        insertionSort(arr);
    }
}
