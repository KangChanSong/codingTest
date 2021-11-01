package engineerKorea.sort;

import java.util.Arrays;
import java.util.LinkedList;

public class Sort {
    public static void main(String[] args) {
        int[] arr1 = createNotSortedArray();
        selectionSort(arr1);
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = createNotSortedArray();
        bubbleSort(arr2);
        System.out.println(Arrays.toString(arr2));

        int[] arr3 = createNotSortedArray();
        mergeSort(arr3);
        System.out.println(Arrays.toString(arr3));

        int[] arr4 = createNotSortedArray();
        insertionSort(arr4);
        System.out.println(Arrays.toString(arr4));

    }

    static int[] createNotSortedArray(){
        return new int[]{6,3,5,4,1,2,9,8,7};
    }

    static void insertionSort(int[] arr){
        for(int i = 1; i < arr.length ; i++){
            // 요소 백업
            int temp = arr[i];
            int aux = i - 1;
            // 자리를 찾을때까지 자기보다 큰 배열을 한칸씩 뒤로 민다.
            while ((aux >= 0) && ( arr[aux] > temp)){
                arr[aux+1] = arr[aux];
                aux--;
            }
            arr[aux + 1] = temp;
        }
    }

    static void bubbleSort(int[] arr){
        boolean sorted = false;
        while (!sorted){ // 정렬이 전부 되었으면 멈춘다.
            sorted = true;  // sorted 를 true 로 세팅
            for(int i = 1 ; i < arr.length ; i++){
                if(arr[i-1] > arr[i]){
                    sorted = false; // 한번이라도 정렬이 발생했으면 sorted 를 false 로 바꾼다.
                    int temp = arr[i-1];
                    arr[i-1] = arr[i];
                    arr[i] = temp;
                }
            }
            // 정렬이 한번도 되지 않고 for문이 끄나면 sorted 는 true 이기때문에 while문이 종료된다.
        }
    }

    static void selectionSort(int[] arr){
        for(int i = 0 ; i < arr.length ; i++){
            int min = arr[i]; // 최솟값
            int index = i; 
            for(int j = i+1 ; j<arr.length ; j++){
                if(arr[j] < min){
                    min = arr[j]; // 최솟값 갱신
                    index = j; // 인덱스 갱신
                }
            }
            if(index != i){ // 스왑
                arr[index] = arr[i];
                arr[i] = min;
            }
        }
    }

    static void mergeSort(int[] arr){
        int[] temp = new int[arr.length];
        mergeSort(arr, temp, 0, arr.length-1);
    }

    private static void mergeSort(int[] arr, int[] temp, int start, int end) {
        if(start < end){
            System.out.println(Arrays.toString(arr));
            int mid = (start + end) / 2;
            mergeSort(arr, temp , start, mid); // 현재 배열의 왼쪽 반에 대해 재귀호출
            mergeSort(arr, temp , mid+1, end); // 현재 배열의 오른쪽 반에 대해 재귀호출
            merge(arr, temp , start, mid , end); // 왼쪽과 오른쪽을 병합
        }
    }

    private static void merge(int[] arr, int[] temp, int start, int mid, int end) {
        for(int i = start ; i <= end ; i++){
            temp[i] = arr[i];
        }

        int left = start;
        int right = mid+1;
        int index = start;
        while (left <= mid && right <= end){
            if(temp[left] <= temp[right]){
                arr[index] = temp[left];
                left++;
            }else {
                arr[index] = temp[right];
                right++;
            }
            index++;
        }

        for(int i = 0 ; i < mid - left ; i++){
            arr[index + i] = temp[left + i];
        }
    }

}
