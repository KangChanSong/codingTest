package Inflearn.greedy;

import java.util.*;

public class 친구인가 {

    static class Student{
        int number;
        List<Student> closeFriends;
        boolean isMarked;

        public Student(int number) {
            this.number = number;
            this.closeFriends = new LinkedList<>();
            this.isMarked = false;
        }
        void addCloseFriend(Student friend){
            if(!this.closeFriends.contains(friend)) this.closeFriends.add(friend);
        }

        @Override
        public String toString() {
            return "Student{" +
                    "number=" + number + '}';
        }
    }

    static String solution(Student[] students, int x, int y){

        Queue<Student> queue = new LinkedList<>();

        queue.offer(students[x]);

        while (!queue.isEmpty()){
            Student student = queue.poll();
            if(!student.isMarked){
                student.isMarked = true;
                if(student.number == y) return "YES";
                if(!student.closeFriends.isEmpty()) student.closeFriends.forEach(s -> queue.add(s));
            }
        }

        return "NO";
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        Student[] students = new Student[n+1];
        // n + 1 의 배열을 만들고
        // n 에 n 번 학생을 넣는다.
        for(int i = 0 ; i < m; i++){
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            Student s1 = students[x];
            Student s2 = students[y];

            if(s1 == null){
                s1 = new Student(x);
            }
            if(s2 == null){
                s2 = new Student(y);
            }
            s1.addCloseFriend(s2);
            s2.addCloseFriend(s1);
            students[x] = s1;
            students[y] = s2;
        }

        int x = scanner.nextInt();
        int y = scanner.nextInt();
        System.out.println(solution(students,x,y));
    }
}
