package BakeJoon.silver3;

public class 재귀호출 {
    public static void main(String[] args) {
        System.out.println("recur = " + recur(6));
    }

    static int recur(int n){
        if(n == 1 || n == 2) return 1;
        else return recur(n-1)  + recur(n-2);
    }
}
