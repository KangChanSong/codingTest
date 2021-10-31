package engineerKorea;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickSort {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 5, 2, 6, 3, 7, 4, 8);
        System.out.println(quicksort(list));
    }

    private static List<Integer> quicksort(List<Integer> list) {
        if(list.size() < 2){ return list;}
        int pivot = list.get(0);
        List<Integer> lower = new ArrayList<>();
        List<Integer> higher = new ArrayList<>();
        for(int i = 0 ; i < list.size() ; i++){
            int n = list.get(i);
            if(n < pivot) lower.add(list.get(i));
            if(n > pivot) higher.add(list.get(i));
        }

        List<Integer> sorted = new ArrayList<>();
        sorted.addAll(quicksort(lower));
        sorted.add(pivot);
        sorted.addAll(quicksort(higher));
        return sorted;
    }
}
