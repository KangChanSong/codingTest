package Inflearn.twoPointers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
public class Q1 {

    public static void insertArrays(ArrayList<Integer> list, int[] arr1) {

        for(int i = 0 ; i < arr1.length; i++){
            list.add(arr1[i]);
        }
    }

    private static void printResult(Object[] toArray) {
        for(int i = 0 ; i < toArray.length ; i++){
            System.out.print(toArray[i] + " ");
        }
    }

    public static void solution(int[] arr1 , int[] arr2) {
        // 새로운 배열을 생성해 arr1 , arr2 의 모든 요소들을 넣는다
        ArrayList<Integer> list = new ArrayList<Integer>();
        insertArrays(list, arr1);
        insertArrays(list, arr2);

        // 배열을 오름차순으로 정렬한다.
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 < o2 ? -1 : 1;
            }
        });

        printResult(list.toArray());
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n1 = scanner.nextInt();
        int[] arr1 = new int[n1];
        for(int i = 0 ; i < n1 ; i++){
            arr1[i] = scanner.nextInt();
        }

        int n2 = scanner.nextInt();
        int[] arr2 = new int[n2];
        for(int i =0 ; i < n2 ; i++){
            arr2[i] = scanner.nextInt();
        }

        solution(arr1, arr2);
    }
}
