package Inflearn.treegraph;

import jdk.jfr.BooleanFlag;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 송아지찾기_해답 {

    static int answer = 0;
    static int[] dis = {1, -1, 5};
    static int[] ch;
    static Queue<Integer> Q = new LinkedList<>();
    static int BFS(int s, int e){
        ch = new int[10001];
        ch[s] = 1;
        Q.offer(s);
        int L = 0;
        while (!Q.isEmpty()){
            int len = Q.size();
            // q 의 크기만큼 노드를 꺼내 자식들을 다시 offer한다.
            for(int i = 0 ; i < len ; i++){
                int x = Q.poll();
                for(int j=0; j < 3; j++){
                    int nx = x + dis[j];
                    if(nx == e) return L+1;
                    if(nx >= 1 && nx <= 10000 && ch[nx] == 0){
                        ch[nx] = 1;
                        Q.offer(nx);
                    }
                }
            }
            L++;
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner kb= new Scanner(System.in);
        int s = kb.nextInt();
        int e = kb.nextInt();
        System.out.println(BFS(s ,e));
    }
}
