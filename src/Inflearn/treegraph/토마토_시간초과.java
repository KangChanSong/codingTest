package Inflearn.treegraph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 토마토_시간초과 {

    // 토마토 박스
    static int[][] box;
    // 메모이제이션
    static int[][] dp;
    static int n;
    static int m;

    static int[] dx = {-1 , 0 , 1, 0};
    static int[] dy = {0 , -1 , 0, 1};
    static Queue<Node> queue = new LinkedList<>();

    static class Node{
        int i;
        int j;
        int level;
        public Node(int i, int j, int level){
            this.i = i;
            this.j = j;
            this.level = level;
        }
    }

    static int bfs(){
        int answer = 0;

        while (!queue.isEmpty()){
            Node node = queue.poll();

            for(int n = 0 ; n < dx.length ; n++){
                int i = node.i + dx[n];
                int j = node.j + dy[n];
                if(validateLocation(i, j) && box[i][j] == 0){
                    box[i][j] = 1;
                    queue.offer(new Node(i,j, node.level+1));
                }
            }

            answer = node.level;
        }

        return isThereNotRiped() ? answer : -1;
    }

    static boolean validateLocation(int i, int j) {
        if(i < 0 || i > n-1 || j < 0 || j > m-1) return false;
        return true;
    }

    static boolean isThereNotRiped(){
        for(int i = 0 ; i < n ; i ++){
            for(int j = 0 ; j < m; j++){
                if(box[i][j] == 0) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        m = scanner.nextInt();
        n = scanner.nextInt();
        box = new int[n][m];
        dp = new int[n][m];

        for(int i = 0; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                int x = scanner.nextInt();
                if(x == 1){
                    queue.add(new Node(i, j, 0));
                }
                box[i][j] = x;
            }
        }

        System.out.println(bfs());
    }
}