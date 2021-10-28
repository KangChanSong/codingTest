package sort;

import java.util.LinkedList;
import java.util.List;

public class InsertionSort {
    static void insertionSort(int[] arr){
        List<Integer> list = new LinkedList<>();
        loop : for(int i = 0 ; i < arr.length ; i++){

            // 맨 처음엔 size 가 0 이기때문에 for 문을 생략함
            for(int j = 0 ; j < list.size() ; j++){
                // 리스트의 요소가 자신보다 크면 그 요소 앞에 들어간다.
                if(list.get(j) > arr[i]){
                    list.add(j, arr[i]);
                    // for loop 으로 돌아간다.
                    continue loop;
                }
            }
            // 리스트 안에서 자신보다 큰 요소가 없으면 자신이 맨 뒤로 들어간다.
            list.add(arr[i]);
        }

        System.out.println(list);
   }

    public static void main(String[] args) {
        int[] arr = InputHelper.inputArray();
        insertionSort(arr);
    }
}
