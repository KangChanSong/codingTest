package sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class InsertionSort {

    static void insertionSort(int[] arr){

        List<Integer> list = new LinkedList<>();
        loop: for(Integer num: arr){
            for(int i=0; i<list.size(); i++){
                System.out.println("list.toString() = " + list.toString());
                if(list.get(i)>num){
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
        //int[] arr = InputHelper.inputArray();
        //insertionSort(arr);
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new LinkedList<>();
        System.out.println("길이 입력");
        int n = scanner.nextInt();
        System.out.println("요소 입력");
        for(int i = 0 ; i < n ; i++ ){
            list.add(scanner.nextInt());
        }
        boolean flag = true;
        while (flag){
            System.out.println("끼워넣을 인덱스, 숫자 입력");
            int i = scanner.nextInt();
            int num =scanner.nextInt();
            list.add(i,num);
            System.out.println("list = " + list);
            System.out.println("끝내려면 0 입력 아니면 1");
            if(scanner.nextInt() == 0) flag = false;
        }

    }
}
