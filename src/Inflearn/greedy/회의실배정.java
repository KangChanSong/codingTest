package Inflearn.greedy;

import java.sql.ClientInfoStatus;
import java.util.*;

public class 회의실배정 {
    static class Conference{
        int start;
        int end;
        public Conference(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Conference{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
    static int solution(List<Conference> conferences){

        // 가장 빨리 시작하는 회의를 고른다.
        // 최대 회의 수를 구하고 리스트에서 없앤다.
        // 두번째로 빨리 시작하는 회의를 반복한다.
        int answer = 0;

        Collections.sort(conferences, new Comparator<Conference>() {
            @Override
            public int compare(Conference o1, Conference o2) {
                return o1.end < o2.end ? -1 : 1;
            }
        });

        while (!conferences.isEmpty()){
            List<Conference> checked = new LinkedList<>();
            Conference early = conferences.get(0);
            checked.add(early);
            int end = early.end;
            for(Conference conference : conferences){
                if(conference.start >= end){
                    end = conference.end;
                    checked.add(conference);
                }
            }
            conferences.removeAll(checked);

            answer = Math.max(checked.size(), answer);
        }

        return answer;
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Conference> conferences = new LinkedList<>();
        for(int i = 0 ; i < n ; i++){
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            conferences.add(new Conference(start, end));
        }

        System.out.println(solution(conferences));
    }
}
