package Inflearn.greedy;

import java.util.*;

public class 최대수입스케줄 {

    static PriorityQueue<Lesson> queue = new PriorityQueue<>(new Comparator<Lesson>() {
        @Override
        public int compare(Lesson o1, Lesson o2) {
            if(o1.day == o2.day) return o1.price < o2.price ? 1: -1;
            if(o1.price == o2.price) return o1.day < o2.day ? 1 : -1;
            return o1.price < o2.price ? 1 : -1;
        }
    });

    static List<Lesson> lessons = new ArrayList<>();

    static class Lesson{
        int price;
        int day;

        public Lesson(int price, int day) {
            this.price = price;
            this.day = day;
        }

        @Override
        public String toString() {
            return "Lesson{" +
                    "price=" + price +
                    ", day=" + day +
                    '}';
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int maxDay = 0;
        for(int i = 0 ; i < n ; i++){
            int price = scanner.nextInt();
            int day = scanner.nextInt();
            lessons.add(new Lesson(price, day));
            maxDay = Math.max(maxDay, day);
        }
        System.out.println(recurse(maxDay));
    }

    private static int recurse(int day) {
        // 현재 시간에 할 수 있는 강연들 중 가장 강연료가 높은 강연을 뽑는다.
        //  반복.
        if(day < 1 || lessons.size() < 1) return 0;
        lessons.stream().filter(lesson -> lesson.day >= day).forEach(lesson -> queue.offer(lesson));
        Lesson lesson = queue.poll();
        lessons.remove(lesson);
        queue.clear();
        if(lesson == null) return recurse(day-1);
        return lesson.price + recurse(day-1);
    }
}
