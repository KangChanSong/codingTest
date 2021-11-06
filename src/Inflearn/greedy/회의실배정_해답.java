package Inflearn.greedy;

import com.sun.tools.javac.Main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Time implements Comparable<Time>{
    public int s,e;

    public Time(int s, int e) {
        this.s = s;
        this.e = e;
    }


    @Override
    // 요게 핵심이엇음... 어떻게 정렬하느냐
    public int compareTo(Time o) {
        if(this.e == o.e) return this.s - o.s; // 끝이 같다면 시작순으로 정렬
        else return this.e - o.e; // 기본적으로 끝 시간으로 정렬
    }
}

public class 회의실배정_해답 {
    static int solution(ArrayList<Time> arr, int n){
        int cnt = 0;
        Collections.sort(arr);
        int et =0; // 종료 시간
        for (Time ob: arr) {
            if(ob.s >= et){
                cnt++;
                et = ob.e;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        ArrayList<Time> arr= new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            int x = kb.nextInt();
            int y = kb.nextInt();
            arr.add(new Time(x, y));
        }
        System.out.println(solution(arr, n));
    }
}
