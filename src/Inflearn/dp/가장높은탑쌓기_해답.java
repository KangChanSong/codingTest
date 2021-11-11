package Inflearn.dp;

import java.util.*;

public class 가장높은탑쌓기_해답 {

    static class Brick implements Comparable<Brick>{
        int s;
        int h;
        int w;
        public Brick(int s, int h, int w) {
            this.s = s;
            this.h = h;
            this.w = w;
        }

        @Override
        public int compareTo(Brick o) {
            return o.s - this.s;
        }
    }

    static int[] dp;

    static int solution(ArrayList<Brick> bricks){
        int answer = 0;
        // 내림차순 정렬
        Collections.sort(bricks);
        
        // 값 초기화
        dp[0] = bricks.get(0).h;
        answer = dp[0];

        for(int i = 1 ; i < bricks.size() ; i++){
            int max_h = 0;
            for(int j = i-1 ; j >= 0 ; j--){
                if(bricks.get(j).w > bricks.get(i).w && dp[j] > max_h){
                    max_h = dp[j];
                }
            }
            dp[i] = max_h + bricks.get(i).h;
            answer = Math.max(answer,  dp[i]);
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Brick> bricks = new ArrayList<>();
        dp = new int[n];
        for(int i = 0 ; i < n ; i++){
            Brick brick = new Brick(
                    scanner.nextInt(),
                    scanner.nextInt(),
                    scanner.nextInt()
            );
            bricks.add(brick);
        }
        solution(bricks);
    }
}
