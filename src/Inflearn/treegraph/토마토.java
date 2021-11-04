package Inflearn.treegraph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 토마토 {

    static class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] board, dis;
    static int n, m;
    static Queue<Point> Q = new LinkedList<>();

    static void bfs(){
        while (!Q.isEmpty()){
            Point tmp = Q.poll();
            for(int i = 0 ; i < 4 ; i++){
                // 상하좌우 좌표
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];

                // 여기서 탐색했던 노드를 이미 걸러내기때문에 더 빨랏음
                if(nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] == 0){
                    board[nx][ny] = 1; // 토마토 익히고
                    Q.offer(new Point(nx, ny)); // 큐에 넣는다
                    dis[nx][ny] = dis[tmp.x][tmp.y] + 1; // 현재 좌표로부터의 거리
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        m = kb.nextInt();
        n = kb.nextInt();
        board = new int[n][m];
        dis = new int[n][m];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                board[i][j] = kb.nextInt();
                if(board[i][j] == 1) Q.offer(new Point(i, j));
            }
        }
        bfs();
        boolean flag = true;
        int answer = Integer.MIN_VALUE;

        for(int i = 0 ; i < n ; i ++){
            for(int j = 0 ; j < m ; j++){
                if(board[i][j] == 0) flag = false;
            }
        }
        if(flag){
            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ; j < m ; j++){
                    if(dis[i][j] > answer) answer = dis[i][j];
                }
            }
            System.out.println(answer);
        } else System.out.println(-1);
    }

}
