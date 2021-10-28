package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class QuickSort {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(9,2,3,5,1,6,8);

        List<Integer> sortedList = quickSort(list);
        System.out.println(sortedList);
    }

    private static List<Integer> quickSort(List<Integer> numbers) {
        if(numbers.size() < 2) return numbers;

        int pivot = numbers.get(0);
        List<Integer> lower = new ArrayList<>();
        List<Integer> higher = new ArrayList<>();

        for(int i = 1 ; i < numbers.size() ; i++){
            int num = numbers.get(i);
            if(num < pivot) lower.add(num);
            else higher.add(num);
        }

        List<Integer> sorted = quickSort(lower);
        sorted.add(pivot);
        sorted.addAll(quickSort(higher));

        return sorted;
    }
}
