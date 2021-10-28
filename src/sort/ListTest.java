package sort;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ListTest {
    public static void main(String[] args) {
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
