package Inflearn.greedy;

import java.util.Scanner;

// 서로소 집합을 만들어 두 학생이 같은 집합 안에 있으면 YES 아니면 NO 를 반환하도록 작성
public class 친구인가_해답 {
    static int[] unf; // 서로소 집합을 표현할 배열

    static int find(int v){ // v 학생의 집합 번호를 리턴해준다.
        if(v == unf[v]) return v;
        return unf[v] = find(unf[v]);
    }

    static void union(int a, int b){
        int fa = find(a);
        int fb = find(b);
        if(fa != fb) unf[fa] = fb;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        unf = new int[n+1];
        for(int i = 1; i <= n ; i++) unf[i] = i;
        for(int i = 1 ; i <= m ; i++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            union(a, b);
        }

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int fa = find(a);
        int fb = find(b);
        System.out.println(fa == fb ? "YES" : "NO");
    }
}
