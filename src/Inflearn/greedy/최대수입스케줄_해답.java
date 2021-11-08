package Inflearn.greedy;

import java.util.*;

public class 최대수입스케줄_해답 {
    static class Lecture implements Comparable<Lecture>{
        public int money;
        public int time;
        public Lecture(int money, int time) {
            this.money = money;
            this.time = time;
        }

        @Override
        public int compareTo(Lecture o) {
            return o.time - this.time;
        }
    }

    static int n , max = Integer.MIN_VALUE;
    static int solution(ArrayList<Lecture> arr){
        int answer = 0;
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        Collections.sort(arr); // 날짜 내림차순
        int j = 0;
        for(int i = max ; i >= 1 ; i--){
            for( ; j < n ; j++){
                if(arr.get(j).time < i) break; // 시간이 max 보다 작으면 멈춤
                pQ.offer(arr.get(j).money);
            }
            if(!pQ.isEmpty()) answer += pQ.poll(); // 강연료 누적
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        ArrayList<Lecture> arr = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            int money = scanner.nextInt();
            int time = scanner.nextInt();
            arr.add(new Lecture(money, time));
            if(time > max) max = time;
        }
        System.out.println(solution(arr));
    }
}
